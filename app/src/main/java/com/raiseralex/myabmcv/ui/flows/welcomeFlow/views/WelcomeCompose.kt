package com.raiseralex.myabmcv.ui.flows.welcomeFlow.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.raiseralex.myabmcv.R
import com.raiseralex.myabmcv.ui.flows.welcomeFlow.views.shareviews.NextButton
import com.raiseralex.myabmcv.ui.shareViews.TypewriterText
import com.raiseralex.myabmcv.ui.theme.CustomTheme

@Preview(showBackground = true)
@Composable
private fun Preview() {
    WelcomeCompose(
        Modifier,
        onNextButton = {},
    )
}

@Composable
fun WelcomeCompose(
    modifier: Modifier = Modifier,
    onNextButton: () -> Unit,
) {
    val listContent = listOf(
        "\uD83E\uDD4BHabilidades y competencias.",
        "\uD83E\uDDD9\u200DMí presentación personal.",
        "\uD83D\uDC54Historial laboral.",
        "\uD83D\uDCDDReferencias.",
        "\uD83C\uDF92Educación. ",
    )
    Column(
        modifier = modifier
            .background(CustomTheme.colors.primaryDark),
    ) {
        Column(
            modifier = modifier
                .padding(CustomTheme.dimens.smallPadding)
                .fillMaxWidth(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            TypewriterText(texts = "\uD83D\uDC4B¡Binvenido!\uD83D\uDC4B ", textSize = 30.sp)
            Image(painter = painterResource(id = R.drawable.cv_ic), contentDescription = "Image CV")
        }

        Surface(
            modifier = modifier
                .padding(CustomTheme.dimens.smallPadding)
                .weight(1f),
            color = CustomTheme.colors.background,
        ) {
            Column(
                modifier = modifier
                    .padding(CustomTheme.dimens.mediumPadding)
                    .fillMaxWidth(1f),
                horizontalAlignment = Alignment.Start,
            ) {
                TypewriterText(texts = "Modulos:", textSize = 30.sp)
                listContent.forEach { content ->
                    Spacer(modifier = modifier.height(CustomTheme.dimens.smallPadding))
                    TypewriterText(texts = content, textSize = 18.sp)
                }
            }
        }

        Row(
            modifier = modifier
                .padding(CustomTheme.dimens.smallPadding)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.End,
        ) {
            NextButton(modifier = modifier, onNextButton)
        }
    }
}
