package com.raiseralex.myabmcv.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import javax.annotation.concurrent.Immutable

@Immutable
data class Dimens(
    val horizontalPadding: Dp = 8.dp,
    val smallPadding: Dp = 8.dp,
    val mediumPadding: Dp = 12.dp,
    val largePadding: Dp = 16.dp,
    val listSpacing: Dp = 8.dp,
)

@Immutable
data class CustomColors(
    val primary: Color,
    val primaryDark: Color,
    val accent: Color,
    val background: Color,
    val textColor: Color,
    val textButtonColor: Color,
    val buttonPositiveContent: Color,
    val buttonNegativeContent: Color,
    val buttonErrorContent: Color,
)

val DefaultDimens = Dimens()

val DefaultColors = CustomColors(
    Color.Unspecified,
    Color.Unspecified,
    Color.Unspecified,
    Color.Unspecified,
    Color.Unspecified,
    Color.Unspecified,
    Color.Unspecified,
    Color.Unspecified,
    Color.Unspecified,
)
val TabletDimens = Dimens(
    horizontalPadding = 24.dp,
)

internal val LocalDimens = staticCompositionLocalOf { DefaultDimens }
internal val LocalCustomColors = staticCompositionLocalOf { DefaultColors }

object CustomTheme {
    val colors: CustomColors
        @Composable
        @ReadOnlyComposable
        get() = LocalCustomColors.current
    val dimens: Dimens
        @Composable
        @ReadOnlyComposable
        get() = LocalDimens.current
}
