package com.example.learningcompose.sample

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import kotlinx.coroutines.delay

private interface Disposable {
    fun dispose()
}

private interface UserDataRequest
private interface UserDataResponse

private interface UserRepository {
    fun fetchUserData(
        request: UserDataRequest,
        onError: (Throwable) -> Unit,
        onSuccess: (UserDataResponse) -> Unit,
    ): Disposable
}

private sealed class UserDataState {
    object Loading : UserDataState()
    class UserData(val name: String, val avatar: String) : UserDataState() {
        constructor(response: UserDataResponse) : this("", "")
    }
    class Error(val message: String?) : UserDataState()
}

fun disposableEffectSample() {
    @Composable
    fun UserProfile(userRepository: UserRepository, userRequest: UserDataRequest) {
        var userDataState by remember { mutableStateOf<UserDataState>(UserDataState.Loading) }

        // If either the repository or request change, we must cancel our old data fetch
        // and begin a new data fetch. We will cancel the current data fetch if UserProfile
        // leaves the composition.
        DisposableEffect(userRepository, userRequest) {
            val requestDisposable = userRepository.fetchUserData(
                userRequest,
                onSuccess = { response ->
                    userDataState = UserDataState.UserData(response)
                },
                onError = { throwable ->
                    userDataState = UserDataState.Error(throwable.message)
                }
            )

            onDispose {
                requestDisposable.dispose()
            }
        }

        // ...
    }
}

private interface Dispatcher {
    fun addListener(listener: () -> Unit): Disposable
}

@Suppress("UnnecessaryLambdaCreation")
fun rememberUpdatedStateSampleWithDisposableEffect() {
    @Composable
    fun EventHandler(dispatcher: Dispatcher, onEvent: () -> Unit) {

        val currentOnEvent by rememberUpdatedState(onEvent)

        // Event handlers are ordered and a new onEvent should not cause us to re-register,
        // losing our position in the dispatcher.
        DisposableEffect(dispatcher) {
            val disposable = dispatcher.addListener {
                // currentOnEvent will always refer to the latest onEvent function that
                // the EventHandler was recomposed with
                currentOnEvent()
            }
            onDispose {
                disposable.dispose()
            }
        }
    }
}

private interface NotificationState {
    val currentNotification: Notification?
}

private interface Notification {
    fun dismiss()
}

private const val NotificationTimeout = 5_000L

fun rememberUpdatedStateSampleWithLaunchedTask() {
    @Composable
    fun NotificationHost(state: NotificationState, onTimeout: (Notification) -> Unit) {
        val currentOnTimeout by rememberUpdatedState(onTimeout)

        state.currentNotification?.let { currentNotification ->
            LaunchedEffect(currentNotification) {
                // We should not restart this delay if onTimeout changes, but we want to call
                // the onTimeout we were last recomposed with when it completes.
                delay(NotificationTimeout)
                currentOnTimeout(currentNotification)
            }
        }

        // ...
    }
}