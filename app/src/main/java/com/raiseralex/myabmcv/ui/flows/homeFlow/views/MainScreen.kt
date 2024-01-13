package com.raiseralex.myabmcv.ui.flows.homeFlow.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.raiseralex.myabmcv.ui.shareViews.TypewriterText

@Preview(showBackground = true)
@Composable
private fun Preview() {
    MainScreen(
        Modifier,
        onNextButton = {},
    )
}

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    onNextButton: () -> Unit,
) {
    val helloList = remember {
        "MAIN...."
    }

    Column(
        modifier = modifier
            .padding(5.dp)
            .fillMaxHeight(1f)
            .fillMaxWidth(1f),
    ) {
        TypewriterText(texts = helloList)
    }
}
