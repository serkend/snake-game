package com.development.unique_snakegame.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val DarkColorPalette = darkColors(
    primary = DarkGreen,
    secondary = DarkGreen,
    background = LightGreen,
    onBackground = DarkGreen
)

private val LightColorPalette = lightColors(
    primary = DarkGreen,
    secondary = DarkGreen,
    background = LightGreen,
    onBackground = DarkGreen

)

@Composable
fun SnakeGameTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    val systemUiController = rememberSystemUiController()
    if (darkTheme) {
        systemUiController.setSystemBarsColor(
            color = DarkGreen
        )
    } else {
        systemUiController.setSystemBarsColor(
            color = DarkGreen
        )
    }

    MaterialTheme(
            colors = colors,
            typography = Typography,
            shapes = Shapes,
            content = content
    )
}