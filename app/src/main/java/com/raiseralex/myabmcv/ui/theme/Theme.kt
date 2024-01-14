package com.raiseralex.myabmcv.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.hilt.navigation.compose.hiltViewModel
import com.raiseralex.myabmcv.ui.flows.welcomeFlow.viewmodels.ThemeViewModel

val DarkColorScheme = darkColorScheme(
    primary = Color.Black, // Azul oscuro
    secondary = Color(0xFF7A939E), // Gris azulado
    tertiary = Color(0xFFB71C1C), // Rojo oscuro
    background = Color(0x94494F58), // Gris oscuro
    surface = Color(0xFFFFFFFF), // Negro ligeramente más claro que el fondo
    onPrimary = Color.White, // POSITIVE BUTTON
    onSecondary = Color.White, // TEXT COLOR
    onTertiary = Color.Black,
    onBackground = Color.White,
    onSurface = Color.White,
    onError = Color.Red,
)

val LightColorScheme = lightColorScheme(
    primary = Color(0xFF1976D2), // Azul primario
    secondary = Color(0xFF64B5F6), // Azul claro
    tertiary = Color(0xFFE57373), // Rojo claro
    background = Color.White,
    surface = Color(0xFFE7D274), // Gris claro
    onPrimary = Color(0xFFFB8C00), // POSITIVE BUTTON
    onSecondary = Color.Black, // TEXT COLOR
    onTertiary = Color.White,
    onBackground = Color.Black,
    onSurface = Color.Black,

)

@Composable
fun CustomTheme(
    themeViewModel: ThemeViewModel = hiltViewModel(),
    dimens: Dimens = CustomTheme.dimens,
    content: @Composable () -> Unit,
) {
    val themeState by themeViewModel.themeSate.collectAsState()

    val lightColors = CustomColors(
        primary = Color(0xFF64B5F6),
        primaryDark = Color(0xFF1976D2),
        accent = Color(0xFFEF6C00),
        background = Color.White,
        textColor = Color.White,
        textButtonColor = Color.Black,
        buttonPositiveContent = Color(0xE419D24D),
        buttonNegativeContent = Color(0xFFFF0000),
        buttonErrorContent = Color.Red,
    )
    val darkColors = CustomColors(
        primary = Color.Gray,
        primaryDark = Color.Black,
        accent = Color(0xFFEF6C00),
        background = Color(0xFF646370),
        textColor = Color.White,
        textButtonColor = Color.Black,
        buttonPositiveContent = Color.White,
        buttonNegativeContent = Color(0xFFAD1421),
        buttonErrorContent = Color.Yellow,
    )
    val colorScheme = when {
        themeState.isDarkMode -> darkColors
        else -> lightColors
    }

    CompositionLocalProvider(
        LocalDimens provides dimens,
        LocalCustomColors provides colorScheme,
    ) {
        MaterialTheme(
            typography = Typography(
                bodyLarge = TextStyle(
                    fontFamily = themeViewModel.getFontFamily(),
                ),
            ),
            content = content,
        )
    }
}
