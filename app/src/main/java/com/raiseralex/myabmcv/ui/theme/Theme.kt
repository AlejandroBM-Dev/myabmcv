package com.raiseralex.myabmcv.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.TextStyle
import androidx.core.view.WindowCompat
import androidx.hilt.navigation.compose.hiltViewModel
import com.raiseralex.myabmcv.ui.flows.welcomeFlow.viewmodels.ThemeViewModel

val DarkColorScheme = darkColorScheme(
    primary = Color.Black, // Azul oscuro
    secondary = Color(0xFF7A939E), // Gris azulado
    tertiary = Color(0xFFB71C1C), // Rojo oscuro
    background = Color(0x94494F58), // Gris oscuro
    surface = Color(0xFFFDD835), // Negro ligeramente más claro que el fondo
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color.White,
    onSurface = Color.White,
    onError = Color.Red
)

val LightColorScheme = lightColorScheme(
    primary = Color(0xFF1976D2), // Azul primario
    secondary = Color(0xFF64B5F6), // Azul claro
    tertiary = Color(0xFFE57373), // Rojo claro
    background = Color.White,
    surface = Color(0xFFE7D274), // Gris claro
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onTertiary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
)

@Composable
fun CustomTheme(
    themeViewModel: ThemeViewModel = hiltViewModel(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit,
) {
    val themeState by themeViewModel.themeSate.collectAsState()

    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (themeState.isDarkMode) {
                dynamicDarkColorScheme(context)
            } else {
                dynamicLightColorScheme(
                    context,
                )
            }
        }
        themeState.isDarkMode -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current

    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat
                .getInsetsController(window, view)
                .isAppearanceLightStatusBars = themeState.isDarkMode
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography(
            bodyLarge = TextStyle(
                fontFamily = themeViewModel.getFontFamily(),
            ),
        ),
        content = content,
    )
}
