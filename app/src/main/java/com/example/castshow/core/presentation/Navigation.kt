package com.example.castshow.core.presentation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.castshow.cast_show_feature.presentation.cast_detail.DetailedInfoCharacterScreen
import com.example.castshow.cast_show_feature.presentation.cast_detail.DetailedInfoViewModel
import com.example.castshow.cast_show_feature.presentation.cast_list.CastListScreen
import com.example.castshow.cast_show_feature.presentation.cast_list.CastListViewModel

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = ScreenRoute.CastListScreen.route
    ) {

        composable(ScreenRoute.CastListScreen.route) {
            val viewModel: CastListViewModel = hiltViewModel()
            CastListScreen(
                state = viewModel.state,
                events = viewModel::onTriggerEvent,
                navController = navController,
            )
        }
        composable(ScreenRoute.DetailedInfoCharacterScreen.route + "/{characterId}") {

            val viewModel: DetailedInfoViewModel = hiltViewModel()

            DetailedInfoCharacterScreen(
                state = viewModel.state,
                navController = navController
            )


        }
    }

}

sealed class ScreenRoute(val route: String) {
    object CastListScreen : ScreenRoute("show_cast_list_screen")
    object DetailedInfoCharacterScreen : ScreenRoute("detailed_info_character_screen")
}