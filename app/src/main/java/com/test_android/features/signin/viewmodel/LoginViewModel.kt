package com.gamexpert.test_android.features.signin.viewmodel

import com.gamexpert.test_android.features.signin.model.LoginModel
import com.gamexpert.test_android.features.signin.model.LoginState
import com.gamexpert.test_android.features.signin.repository.LoginRepository
import com.gamexpert.test_android.features.signin.repository.SignInState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class LoginViewModel {

    private val repo by lazy { LoginRepository() }

    private val _uiModel = MutableStateFlow(LoginModel())
    val uiModel = _uiModel.asStateFlow()

    private val _uiState = MutableStateFlow<LoginState>(LoginState.None)
    val uiState = _uiState.asStateFlow()

    fun onEmailUpdate(email: String) {
        val updatedModel = _uiModel.value.copy(email = email, emailError = null, loginError = null)
        _uiModel.value = updatedModel
    }

    fun onPasswordUpdate(password: String) {
        val updatedModel = _uiModel.value.copy(password = password, loginError = null)
        _uiModel.value = updatedModel
    }

    fun login() {
        _uiModel.value = _uiModel.value.copy(loading = true)
        val model = _uiModel.value
        when (val result = repo.signIn(model)) {
            is SignInState.Failure -> {
                val errorState = _uiModel.value.copy(loginError = result.message)
                _uiModel.value = errorState
            }
            SignInState.Success -> {
                _uiModel.value = _uiModel.value
                navigateToWelcomeScreen()
            }
        }
    }

    private fun navigateToWelcomeScreen() {
        _uiState.value = LoginState.Success
    }
}
