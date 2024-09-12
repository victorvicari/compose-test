package com.gamexpert.test_android.features.signin.model

import android.util.Patterns

sealed class LoginState {
    data object None : LoginState()
    data object Success : LoginState()
}

data class LoginModel(
    val email: String = "",
    val password: String = "",
    val emailError: String? = "",
    val loginError: String? = "",
    val loading: Boolean = false,
) {
    private val hasError: Boolean
        get() = !emailError.isNullOrEmpty() && !loginError.isNullOrEmpty()

    val emailValid: Boolean
        get() = if (email.length > 5) Patterns.EMAIL_ADDRESS.matcher(email).matches() else true

    val buttonEnabled: Boolean
        get() = emailValid && !hasError && password.isNotEmpty()
}
