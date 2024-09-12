package com.gamexpert.test_android.navigation

sealed class Screen (val name: String, val path: String) {
    data object SignIn : Screen(name = "SignIn", path = "sign_in")
    data object WelcomeScreen : Screen(name = "Welcome", path = "welcome")
}
