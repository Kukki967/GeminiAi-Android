package com.groot.geminiAi.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.google.ai.client.generativeai.GenerativeModel
import com.groot.geminiAi.ui.module.menu.MenuScreen
import com.groot.geminiAi.ui.module.summarize.SummarizeViewModel
import com.groot.geminiAi.ui.module.summarize.SummarizeRoute

@Composable
fun NavHostController(navController: NavHostController, generativeModel: GenerativeModel) {
    NavHost(navController = navController, startDestination = Route.menuScreen) {
        composable(Route.menuScreen) {
            MenuScreen(navController)
        }
        composable(Route.summarizeScreen) {
            val viewModel = SummarizeViewModel(generativeModel)
            SummarizeRoute(navController, viewModel)
        }
    }
}