package com.example.castshow.cast_show_feature.presentation.cast_detail

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Hub
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Transgender
import androidx.compose.material.icons.filled.Tv
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.castshow.core.util.CharacterStatus
import com.example.castshow.ui.theme.DarkerGreen
import com.example.castshow.ui.theme.GradientGreenDarkerGreen
import com.example.castshow.ui.theme.Green
import com.example.castshow.ui.theme.White

@Composable
fun DetailedInfoCharacterScreen(
    navController: NavController,
    state: CastDetailState
) {

    state.character?.let { character ->

        val tintStatus = when (character.status.uppercase()) {
            CharacterStatus.DEAD.name -> Color.Red
            CharacterStatus.ALIVE.name -> Green
            else -> Color.Gray
        }

        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .background(GradientGreenDarkerGreen),
            ) {
                Box(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .clip(CircleShape),

                    ) {
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(character.image)
                            .crossfade(true)
                            .build(),
                        contentDescription = "${character.name} photo",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(200.dp)
                            .border(4.dp, tintStatus, CircleShape)
                    )

                }

                Text(
                    text = character.name,
                    color = White,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomCenter)
                        .padding(10.dp)

                )
            }

            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .weight(weight = 1f, fill = false)
            ) {
                if (state.character.type.isNotEmpty()) {
                    IconText(Icons.Default.Face, character.type)
                    Divider()
                }

                IconText(Icons.Default.Hub, character.species)
                Divider()
                IconText(Icons.Default.Transgender, character.gender)
                Divider()
                IconText(Icons.Default.Home, character.origin)
                Divider()
                IconText(Icons.Default.LocationOn, character.location)
                Text(
                    modifier = Modifier.padding(top = 10.dp, start = 5.dp, bottom = 10.dp),
                    text = "Episodes in which the character has appeared:",
                    color = Color.Gray,
                    fontWeight = FontWeight.Bold,
                )
                IconText(
                    Icons.Default.Tv,
                    "${character.episode} episode${if (character.episode > 1) "s" else ""}"

                )
            }
        }
    }
}

@Composable
fun IconText(icon: ImageVector, text: String) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(10.dp)
            .height(50.dp),
    ) {
        Icon(
            modifier = Modifier
                .size(45.dp),
            imageVector = icon,
            contentDescription = "status color",
            tint = DarkerGreen
        )

        Text(
            text = text,
            textAlign = TextAlign.Start,
            modifier = Modifier.padding(start = 5.dp),
        )
    }
}