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
import androidx.compose.ui.unit.TextUnit
import com.raiseralex.myabmcv.ui.theme.CustomTheme
import com.raiseralex.myabmcv.utils.extensions.emptyString
import kotlinx.coroutines.delay

@Composable
fun TypewriterText(
    texts: String,
    textSize: TextUnit,
) {
    var textIndex by remember { mutableIntStateOf(0) }
    var textToDisplay by remember { mutableStateOf(emptyString()) }
    val delayWriterText = 65L

    LaunchedEffect(key1 = texts) {
        texts.forEachIndexed { charIndex, _ ->
            textToDisplay = texts
                .substring(
                    startIndex = 0,
                    endIndex = charIndex + 1,
                )
            delay(delayWriterText)
        }
        textIndex += 1
    }
    Text(
        text = textToDisplay,
        color = CustomTheme.colors.textColor,
        fontSize = textSize,
        fontWeight = FontWeight.Bold,
    )
}
