package com.core.movieslatest

import androidx.compose.ui.window.ComposeUIViewController
import com.core.movieslatest.navigation.AppNavigation
import moe.tlaster.precompose.PreComposeApplication

class IosView {
    fun MainViewController() = ComposeUIViewController { AppNavigation() }
    fun MainViewController2() = PreComposeApplication("Compose"){
        AppNavigation()
    }

}