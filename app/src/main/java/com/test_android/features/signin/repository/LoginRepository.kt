package com.gamexpert.test_android.features.signin.repository

import com.gamexpert.test_android.features.signin.model.LoginModel

sealed class SignInState {
    data object Success : SignInState()
    data class Failure(val message: String): SignInState()
}

interface Repository {
    fun signIn(model: LoginModel): SignInState
}

class LoginRepository : Repository {

    private val validEmail = "a.b.c@gmail.com"
    private val emailPassword = "123456"

    override fun signIn(model: LoginModel): SignInState {
        val emailValid = model.email == validEmail
        val passwordValid = model.password == emailPassword

        return if (emailValid && passwordValid) SignInState.Success else SignInState.Failure("exception")
    }
}