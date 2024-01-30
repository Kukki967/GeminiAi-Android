package com.groot.geminiAi.ui.module.menu

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.groot.geminiAi.R
import com.groot.geminiAi.navigation.Route

@Composable
fun MenuScreen(
    navController: NavController,
) {

    val context = LocalContext.current

    // view model objects


    // text fields objects


    //permissions

    //flag


    BackHandler {
        navController.navigateUp()
    }

    LaunchedEffect(key1 = true) {

    }


    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {

        },
        snackbarHost = {

        },
        content = {
            // alert
            // camera launcher
            // dialog pop or bottom sheet

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
            ) {
                MenuListView {
                    navController.navigate(it)
                }
            }
        })

}

@Composable
fun MenuListView(
    onItemClicked: (String) -> Unit = { }
) {
    val menuItems = listOf(
        MenuItem(
            Route.summarizeScreen,
            R.string.menu_summarize_title,
            R.string.menu_summarize_description
        ),
        MenuItem(
            Route.photoReasoning,
            R.string.menu_reason_title,
            R.string.menu_reason_description
        ),
    )
    LazyColumn(
        Modifier
            .padding(top = 16.dp, bottom = 16.dp)
    ) {
        itemsIndexed(menuItems) { index, menuItem ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                Column(
                    modifier = Modifier
                        .padding(all = 16.dp)
                        .fillMaxWidth()
                ) {
                    Text(
                        text = stringResource(menuItem.titleResId),
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(
                        text = stringResource(menuItem.descriptionResId),
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                    TextButton(
                        onClick = {
                            onItemClicked(menuItem.routeId)
                        },
                        modifier = Modifier.align(Alignment.End)
                    ) {
                        Text(text = stringResource(R.string.action_try))
                    }
                }
            }
        }
    }
}


/* **********************************************  Preview ************************************************************/
@Preview(showBackground = true)
@Composable
fun MenuScreenPreview() {
    MenuListView()
}


