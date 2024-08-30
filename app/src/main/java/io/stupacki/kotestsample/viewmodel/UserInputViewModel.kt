package io.stupacki.kotestsample.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.stupacki.kotestsample.usecase.ValidateUserEmailUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

sealed interface UserEmailValidationState {
    data class Valid(val email: String) : UserEmailValidationState
    data object Invalid : UserEmailValidationState
    data object Empty : UserEmailValidationState
    data object Submitted : UserEmailValidationState
}

internal class UserInputViewModel(
    private val validateUserEmail: ValidateUserEmailUseCase = ValidateUserEmailUseCase(),
) : ViewModel(), CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = viewModelScope.coroutineContext

    private val _userEmailState: MutableStateFlow<UserEmailValidationState> by lazy { MutableStateFlow(UserEmailValidationState.Empty) }
    val userEmailState: StateFlow<UserEmailValidationState>
        get() = _userEmailState.asStateFlow()

    fun updateUserEmail(email: String) {
        launch {
            validateUserEmail(email).let { validatedEmailResult ->
                _userEmailState.value = when {
                    email.isEmpty() -> UserEmailValidationState.Empty
                    validatedEmailResult.isSuccess -> UserEmailValidationState.Valid(validatedEmailResult.getOrDefault(email))
                    else -> UserEmailValidationState.Invalid
                }
            }
        }
    }

    fun submitUserEmail() {
        launch {
            when (_userEmailState.value) {
                is UserEmailValidationState.Valid -> _userEmailState.value = UserEmailValidationState.Submitted
                else -> _userEmailState.value = UserEmailValidationState.Invalid
            }
        }
    }
}
