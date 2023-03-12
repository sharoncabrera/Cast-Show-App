package com.example.castshow.cast_show_feature

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.castshow.cast_show_feature.components.CharacterCardItem
import com.example.castshow.core.presentation.ScreenRoute
import com.example.castshow.ui.theme.DarkerGreen
import com.example.castshow.ui.theme.GradientGreenDarkerGreen
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
                backgroundColor = DarkerGreen,
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

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(DarkerGreen),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp, end = 10.dp, bottom = 5.dp),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "searchIcon"
                        )
                    },
                    value = "",//orderChooseVendorViewModel.vendorsSearchQuery,
                    onValueChange = {
                        // orderChooseVendorViewModel.onSearchQueryChange(it)
                    },
                    colors = TextFieldDefaults.textFieldColors(
                        textColor = White,
                        cursorColor = White,
                        focusedLabelColor = White,
                        focusedIndicatorColor = White,

                        ),
                    label = {
                        Text("Search Character")
                    },
                    maxLines = 1
                )

            Divider()

            if (castListViewModel.characterList.isEmpty()) {

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(GradientGreenDarkerGreen),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "There are not characters", color = White)
                }

            } else {

                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(GradientGreenDarkerGreen),
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
                        ) { navController.navigate(ScreenRoute.DetailedInfoCharacterScreen.route + "/${it}") }

                    }
                }

            }


        }
    }
}