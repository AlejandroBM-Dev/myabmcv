package com.raiseralex.myabmcv.ui.flows.homeFlow.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.raiseralex.myabmcv.ui.shareViews.TypewriterText

@Composable
fun HistoryNavScreen(
    modifier: Modifier = Modifier,
) {
    val list = "HistoryNavScreen"
    Column(
        modifier = modifier
            .padding(5.dp)
            .fillMaxHeight()
            .fillMaxWidth(),
    ) {
        TypewriterText(texts = list, textSize = 22.sp)
    }
}
