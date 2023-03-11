package com.example.castshow.cast_show_feature.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import com.example.castshow.cast_show_feature.state.CharacterListItem
import com.example.castshow.ui.theme.Black

@Composable
fun CharacterCardItem(
    character: CharacterListItem,
    onClick: () -> Unit,
) {

    Card(
        elevation = 5.dp,
        shape = RoundedCornerShape(15.dp),
        modifier = Modifier
            .fillMaxWidth(0.95f)
            .fillMaxHeight(0.8f)
            .border(1.dp, color = Black, shape = RoundedCornerShape(15.dp))
            .clickable {
                onClick()
            }
            .padding(top = 10.dp)

    ) {

        Row(
            modifier = Modifier
                .height(100.dp)
                .background(Color.White)

        ) {

            //Circle image

            Box(
                modifier = Modifier
                    .align(CenterVertically)
                    .padding(start = 5.dp)
                    .clip(CircleShape),

                ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                            //TODO: coger url de datos cargados
                        .data("https://wallpapers-clan.com/wp-content/uploads/2021/01/rick-and-morty-toxic-rick-green-wallpaper-scaled.jpg")
                        .crossfade(true)
                        .build(),
                    contentDescription = "character photo",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(80.dp)
                )

            }


        }


    }
}

