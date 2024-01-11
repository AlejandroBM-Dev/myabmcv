package com.raiseralex.myabmcv.ui.welcomeFlow.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.raiseralex.myabmcv.ui.shareViews.TypewriterText
import com.raiseralex.myabmcv.ui.welcomeFlow.views.shareviews.NextButton

@Composable
fun StartCV(
    modifier: Modifier,
    onNextButton: () -> Unit,
) {
    val list = "StartCV"
    Column(
        modifier = modifier
            .padding(5.dp)
            .fillMaxHeight(1f)
            .fillMaxWidth(1f),
    ) {
        TypewriterText(texts = list)

        Spacer(modifier = modifier.weight(1f))
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.End,
        ) {
            NextButton(modifier = modifier, onNextButton)
        }
    }
}