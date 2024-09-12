package com.gamexpert.test_android.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.gamexpert.test_android.di.DependencyInjection
import com.gamexpert.test_android.di.DependencyInjection.loginViewModel
import com.gamexpert.test_android.features.signin.model.LoginState
import com.gamexpert.test_android.features.signin.view.LoginView
import com.gamexpert.test_android.features.welcome.WelcomeView

@Composable
fun NavigationUi(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.SignIn.path
    ) {
        composable(route = Screen.SignIn.path) {
            val uiModel = loginViewModel.uiModel.collectAsStateWithLifecycle().value
            val uiState = loginViewModel.uiState.collectAsStateWithLifecycle().value

            LoginView(
                uiModel,
                loginViewModel::onEmailUpdate,
                loginViewModel::onPasswordUpdate,
                loginViewModel::login
            )

            LaunchedEffect(uiState) {
                if (uiState == LoginState.Success) navController.navigateToWelcome()
            }
        }

        composable(route = Screen.WelcomeScreen.path) {
            WelcomeView()
        }
    }
}

fun NavHostController.navigateToWelcome() = navigate(Screen.WelcomeScreen.path) {
    popUpTo(graph.startDestinationId) { inclusive = true }
    launchSingleTop = true
    restoreState = true
}
