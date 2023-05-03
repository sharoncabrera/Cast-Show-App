package com.example.castshow.cast_show_feature.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.castshow.core.presentation.ScreenRoute
import com.example.castshow.ui.components.CharacterCardItem
import com.example.castshow.ui.theme.DarkerGreen
import com.example.castshow.ui.theme.GradientGreenDarkerGreen
import com.example.castshow.ui.theme.White

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun CastListScreen(
    navController: NavController,
    castListViewModel: CastListViewModel = hiltViewModel()
) {

    val scaffoldState = rememberScaffoldState()
    val keyboardController = LocalSoftwareKeyboardController.current
    var filtersVisible by rememberSaveable { mutableStateOf(false) }
    val isLoading by castListViewModel.isLoading.collectAsState()

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
                },
            )
        }

    ) { padding ->
        print(padding)

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .background(DarkerGreen),
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
                value = castListViewModel.charactersSearchQuery,
                onValueChange = {
                    castListViewModel.onSearchQueryChange(it)
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
                singleLine = true,
                maxLines = 1,
                keyboardOptions = KeyboardOptions.Default.copy(
                    capitalization = KeyboardCapitalization.Words,
                ),
                keyboardActions = KeyboardActions(onDone = {
                    keyboardController?.hide()
                }),
            )

            Divider()

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(GradientGreenDarkerGreen),
                contentAlignment = Alignment.Center
            ) {


                if (castListViewModel.charactersToShow.isEmpty()) {

                    Text(text = "There are not characters", color = White)

                } else {

                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(GradientGreenDarkerGreen),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center

                    ) {

                        itemsIndexed(castListViewModel.charactersToShow) { index, item ->
                            CharacterCardItem(
                                item
                            ) {
                                navController.navigate(ScreenRoute.DetailedInfoCharacterScreen.route + "/${item.id}")
                            }
                            if (index == castListViewModel.charactersToShow.lastIndex) {
                                castListViewModel.getMoreCharacters()
                            }
                        }

                    }
                }
                if (isLoading) {
                    CircularProgressIndicator()
                }

            }
        }
    }
}

