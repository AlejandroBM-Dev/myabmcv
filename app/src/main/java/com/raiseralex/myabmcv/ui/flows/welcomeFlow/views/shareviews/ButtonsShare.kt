package com.raiseralex.myabmcv.ui.flows.welcomeFlow.views.shareviews

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.raiseralex.myabmcv.ui.theme.CustomTheme

@Composable
fun NextButton(
    modifier: Modifier,
    onClick: () -> Unit,
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = CustomTheme.colors.buttonPositiveContent),
    ) {
        Text(text = "NEXT", color = CustomTheme.colors.textButtonColor)
    }
}
