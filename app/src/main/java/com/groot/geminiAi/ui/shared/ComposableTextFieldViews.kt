package com.groot.geminiAi.ui.shared

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.groot.geminiAi.R

//ComposableTextFieldViews


@Composable
fun BasicTextFieldView(prompt: MutableState<String>, modifier: Modifier) {
    TextField(
        value = prompt.value,
        label = { Text(stringResource(R.string.summarize_label)) },
        placeholder = { Text(stringResource(R.string.summarize_hint)) },
        onValueChange = { prompt.value = it },
        modifier = modifier
    )
}

@Composable
fun BasicTextFieldButtonView(
    modifier: Modifier,
    labelTextId: Int,
    placeHolderTextId: Int,
    onClick: (prompt: String) -> Unit
) {
    val prompt = remember { mutableStateOf("") }

    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        TextField(
            value = prompt.value,
            label = { Text(stringResource(labelTextId)) },
            placeholder = { Text(stringResource(placeHolderTextId)) },
            onValueChange = { prompt.value = it },
            modifier = modifier
        )

        TextButton(
            onClick = {
                if (prompt.value.isNotBlank()) {
                    onClick(prompt.value)
                }
            },
            modifier = Modifier
                .weight(2f)
                .padding(all = 4.dp)
                .align(Alignment.CenterVertically)
        ) {
            Text(stringResource(R.string.action_go))
        }

    }
}
