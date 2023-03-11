package com.example.castshow.cast_show_feature

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.castshow.cast_show_feature.components.CharacterCardItem
import com.example.castshow.core.presentation.ScreenRoute
import com.example.castshow.ui.theme.DarkerGreen
import com.example.castshow.ui.theme.Green
import com.example.castshow.ui.theme.White


@Composable
fun CastListScreen(
    navController: NavController,
    castListViewModel: CastListViewModel = hiltViewModel()
) {

    val scaffoldState = rememberScaffoldState()


    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                backgroundColor = Green,
                title = {
                    Text(
                        text = "Rick and Morty cast",
                        color = White,
                    )
                }
            )
        }

    ) { padding ->
        print(padding)
        val gradientGreenDarkerGreen = Brush.verticalGradient(0f to Green, 1000f to DarkerGreen)

        //TODO: modificar quitando !
        if (castListViewModel.characterList.isEmpty()) {

            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "There are not characters")
            }

        } else {

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .background(gradientGreenDarkerGreen),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                items(
                    castListViewModel.characterList,
                    key = { character ->
                        character.id
                    }
                ) {
                    CharacterCardItem(
                        it
                    ) { navController.navigate(ScreenRoute.DetailedInfoCharacterScreen.route + "/${it.id}") }

                }
            }

        }


    }
}