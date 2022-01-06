package com.log.eventtimer.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = Purple200,
    primaryVariant = Purple700,
    secondary = Teal200
)

private val LightColorPalette = lightColors(
    primary = Purple500,
    primaryVariant = Purple700,
    secondary = Teal200

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

val crane_caption = Color.DarkGray
val crane_divider_color = Color.LightGray
private val crane_red = Color(0xFFE30425)
private val crane_white = Color.White
private val crane_purple_700 = Color(0xFF720D5D)
private val crane_purple_800 = Color(0xFF5D1049)
private val crane_purple_900 = Color(0xFF4E0D3A)

val eventTimerColors = lightColors(
    primary = crane_purple_800,
    secondary = crane_red,
    surface = crane_white,
    onSurface = crane_purple_900,
    primaryVariant = crane_purple_700
)

@Composable
fun EventTimerTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    /*val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }*/

    MaterialTheme(
        colors = eventTimerColors,
        typography = eventTimerTypography,
        shapes = Shapes,
        content = content
    )
}