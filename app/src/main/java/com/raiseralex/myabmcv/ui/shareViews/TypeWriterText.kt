package com.raiseralex.myabmcv.ui.shareViews

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

@Composable
fun TypewriterText(
    texts: List<String>,
) {
    var textIndex by remember { mutableIntStateOf(0) }
    var textToDisplay by remember { mutableStateOf("") }
    val delayWriterText = 100L
    val textsMaxIndex = texts.size

    LaunchedEffect(key1 = texts) {
        while (textIndex < textsMaxIndex) {
            texts[textIndex].forEachIndexed { charIndex, _ ->
                textToDisplay = texts[textIndex]
                    .substring(
                        startIndex = 0,
                        endIndex = charIndex + 1,
                    )
                delay(delayWriterText)
            }
            textIndex += 1
        }
    }
    Text(
        text = textToDisplay,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
    )
}
