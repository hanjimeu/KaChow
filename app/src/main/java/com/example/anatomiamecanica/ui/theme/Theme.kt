package com.example.anatomiamecanica.ui.theme

import android.app.Activity
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = VermelhoMcQueen,
    secondary = AmareloRaioMcQueen,
    tertiary = LaranjaChamaMcQueen,
    background = AsfaltoEscuro,
    surface = MetalLixado,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = TextoCorpoClaro,
    onSurface = TextoCorpoClaro
)

@Composable
fun AnatomiaMecanicaTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = DarkColorScheme,
        typography = Typography,
        content = content
    )
}