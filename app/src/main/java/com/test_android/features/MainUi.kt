package com.gamexpert.test_android.features

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.gamexpert.test_android.navigation.NavigationUi
import com.gamexpert.test_android.ui.theme.TestandroidTheme

@Composable
fun MainUi() {
    TestandroidTheme {
        val navController = rememberNavController()

        NavigationUi(navController = navController)
    }
}
