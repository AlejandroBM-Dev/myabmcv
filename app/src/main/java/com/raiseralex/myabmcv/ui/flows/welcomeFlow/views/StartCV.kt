package com.raiseralex.myabmcv.ui.flows.welcomeFlow.views

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
import com.raiseralex.myabmcv.ui.flows.welcomeFlow.views.shareviews.NextButton
import com.raiseralex.myabmcv.ui.shareViews.TypewriterText

@Composable
fun StartCV(
    modifier: Modifier = Modifier,
    onNextButton: () -> Unit,
) {
    val list = "StartCV"
    Column(
        modifier = modifier
            .padding(5.dp)
            .fillMaxHeight()
            .fillMaxWidth(),
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
