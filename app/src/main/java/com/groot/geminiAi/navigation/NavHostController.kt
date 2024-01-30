package com.groot.geminiAi.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.google.ai.client.generativeai.GenerativeModel
import com.groot.geminiAi.BuildConfig
import com.groot.geminiAi.ui.module.menu.MenuScreen
import com.groot.geminiAi.ui.module.reasoning.PhotoReasoningRoute
import com.groot.geminiAi.ui.module.reasoning.PhotoReasoningViewModel
import com.groot.geminiAi.ui.module.summarize.SummarizeRoute
import com.groot.geminiAi.ui.module.summarize.SummarizeViewModel

@Composable
fun NavHostController(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Route.menuScreen) {
        composable(Route.menuScreen) {
            MenuScreen(navController)
        }
        composable(Route.summarizeScreen) {
            val generativeModel = GenerativeModel(
                // For text-only input, use the gemini-pro model
                modelName = "gemini-pro",
                // Access your API key as a Build Configuration variable (see "Set up your API key" above)
                apiKey = BuildConfig.apiKey
            )

            val viewModel = SummarizeViewModel(generativeModel)
            SummarizeRoute(navController, viewModel)
        }
        composable(Route.photoReasoning) {
            val generativeModel = GenerativeModel(
                // For text-and-images input (multimodal), use the gemini-pro-vision model
                modelName = "gemini-pro-vision",
                // Access your API key as a Build Configuration variable (see "Set up your API key" above)
                apiKey = BuildConfig.apiKey
            )
            val viewModel = PhotoReasoningViewModel(generativeModel)
            PhotoReasoningRoute(navController, viewModel)
        }
    }
}