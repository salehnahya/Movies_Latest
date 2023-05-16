package com.core.movieslatest.presentation.splash

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.core.movieslatest.navigation.AppScreens
import com.core.movieslatest.ui.theme.colorBlackBackground
import kotlinx.coroutines.delay
import moe.tlaster.precompose.navigation.Navigator
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun SplashScreen(navigator: Navigator) {
    val scale = remember {
        Animatable(0f)
    }
    LaunchedEffect(key1 = true, block = {
        scale.animateTo(
            0.9f,
            animationSpec = spring(
                dampingRatio = Spring.DampingRatioHighBouncy, // this would define how far the overshoot would happen.
                stiffness = 1000f // with custom speed less than medium speed.
            )
        )
        delay(1000)
        navigator.navigate(AppScreens.MainScreen.path)
    })

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorBlackBackground)
            .paint(
                painter = painterResource("splash_background.png"),
                contentScale = ContentScale.FillBounds
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {


        val linearGradient = Brush.linearGradient(
            listOf(
                Color(0xFFFE53BB),
                Color(0xFF9E95C4),
                Color(0xFF6AB9CA),
                Color(0xFF09FBD3)
            )
        )
        Surface(
            modifier = Modifier
                .padding(15.dp)
                .size(300.dp)
                .border(
                    6.dp, shape = CircleShape,
                    brush = linearGradient
                )
                .scale(scale.value),
            shape = CircleShape,
            color = Color.Transparent

        ) {
            Column(
                modifier = Modifier.background(
                    color = Color.Transparent
                ),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource("logo_vrs.png"),
                    contentDescription = "", modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Fit
                )

            }

        }

        Text(
            text = "Watch movies in Virtual Reality",
            color = Color.White,
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(top = 10.dp, start = 16.dp, end = 16.dp),
            textAlign = TextAlign.Center
        )
    }
}



