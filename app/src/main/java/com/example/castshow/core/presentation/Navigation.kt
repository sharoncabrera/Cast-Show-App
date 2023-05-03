package com.example.castshow.core.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.castshow.cast_show_feature.presentation.CastListScreen
import com.example.castshow.cast_show_feature.presentation.DetailedInfoCharacterScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = ScreenRoute.CastListScreen.route
    ) {

        composable(ScreenRoute.CastListScreen.route) {
            CastListScreen(navController = navController)
        }
        composable(ScreenRoute.DetailedInfoCharacterScreen.route + "/{characterId}") {

            DetailedInfoCharacterScreen(
                navController = navController,
                characterId = it.arguments?.getString("characterId")
            )


        }
    }

}

sealed class ScreenRoute(val route: String) {
    object CastListScreen : ScreenRoute("show_cast_list_screen")
    object DetailedInfoCharacterScreen : ScreenRoute("detailed_info_character_screen")
}