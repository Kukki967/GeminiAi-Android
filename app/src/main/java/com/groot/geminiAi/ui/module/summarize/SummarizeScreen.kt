package com.groot.geminiAi.ui.module.summarize

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.groot.geminiAi.R
import com.groot.geminiAi.ui.shared.BasicTextFieldButtonView
import com.groot.geminiAi.ui.shared.LoaderIndicator

@Composable
internal fun SummarizeRoute(
    navController: NavHostController,
    summarizeViewModel: SummarizeViewModel = viewModel()
) {
    val summarizeUiState by summarizeViewModel.uiState.collectAsState()

    SummarizeScreen(
        uiState = summarizeUiState,
        onSummarizeClicked = { inputText ->
            summarizeViewModel.summarize(inputText)
    })
}

@Composable
fun SummarizeScreen(
    uiState: SummarizeUiState = SummarizeUiState.Initial,
    onSummarizeClicked: (String) -> Unit = {}
) {

    Column(
        modifier = Modifier
            .padding(all = 8.dp)
            .verticalScroll(rememberScrollState())
    ) {
        BasicTextFieldButtonView(Modifier.weight(8f), R.string.summarize_label, R.string.summarize_hint, onSummarizeClicked)

        when (uiState) {
            is SummarizeUiState.Initial -> {
                // Nothing is shown
            }

            is  SummarizeUiState.Loading -> {
                LoaderIndicator()
            }

            is SummarizeUiState.Success -> {
                Row(modifier = Modifier.padding(all = 8.dp)) {
                    Icon(
                        Icons.Outlined.Person,
                        contentDescription = "Person Icon"
                    )
                    Text(
                        text = uiState.outputText,
                        modifier = Modifier.padding(horizontal = 8.dp)
                    )
                }
            }

            is SummarizeUiState.Error -> {
                Text(
                    text = uiState.errorMessage,
                    color = Color.Red,
                    modifier = Modifier.padding(all = 8.dp)
                )
            }
        }

    }
}


/* **********************************************  Preview ************************************************************/
@Preview(showBackground = true)
@Composable
fun SummarizeScreenPreview() {
    SummarizeScreen()
}


