package com.raiseralex.myabmcv.ui.welcomeFlow.views

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.raiseralex.myabmcv.ui.shareViews.TypewriterText

@Preview(showBackground = true)
@Composable
private fun preview() {
    HelloCompose(Modifier)
}

@Composable
fun HelloCompose(modifier: Modifier = Modifier) {
    val helloList = remember {
        listOf(
            "Bienvenido a mi App!.",
        )
    }
    val helloFindList = remember {
        listOf(
            "Aquí encontraras:\n - Mí presentación personal.\n - Historial laboral.\n - Educación.\n - Habilidades y competencias.\n - Referencias.",
        )
    }

    Column(
        modifier = modifier
            .padding(5.dp)
            .fillMaxHeight(1f)
            .fillMaxWidth(1f),
    ) {
        TypewriterText(texts = helloList)
        TypewriterText(texts = helloFindList)
        Spacer(modifier = modifier.weight(1f))
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.End,
        ) {
            NextButton(modifier = modifier)
        }
    }
}

@Composable
fun NextButton(
    modifier: Modifier,
) {
    val context = LocalContext.current
    OutlinedButton(
        modifier = modifier,
        onClick = { Toast.makeText(context, " NEXT ", Toast.LENGTH_SHORT).show() },
    ) {
        Text(text = "NEXT")
    }
}
