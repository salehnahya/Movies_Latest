package com.core.movieslatest.navigation

import androidx.compose.runtime.Composable
import com.core.movieslatest.mainViewModel
import com.core.movieslatest.presentation.main.MainScreen
import com.core.movieslatest.presentation.splash.SplashScreen
import com.core.movieslatest.ui.theme.MoviesTheme
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.rememberNavigator


@Composable
fun AppNavigation() {
    val navigator = rememberNavigator()
    MoviesTheme {
    NavHost(
        navigator = navigator,
        initialRoute = AppScreens.SplashScreen.path
    ) {
        scene(AppScreens.SplashScreen.path) {
            SplashScreen(navigator)
        }
        scene(AppScreens.MainScreen.path) {
            MainScreen(navigator, mainViewModel())

        }
    }
    }
}


