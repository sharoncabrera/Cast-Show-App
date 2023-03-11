package com.example.castshow.cast_show_feature

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
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

    ) {
        val gradientGreenDarkerGreen = Brush.verticalGradient(0f to Green, 1000f to DarkerGreen)
/*
        if (castListViewModel.characterList.isEmpty) {

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
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(
                    castListViewModel.characterList,
                    key = { character ->
                       // character.id
                    }
                ) {

                    //TODO: presentarlo como

                }
            }

        }


 */

    }
}