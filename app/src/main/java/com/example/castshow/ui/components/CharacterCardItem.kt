package com.example.castshow.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Circle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.castshow.core.data.model.Character
import com.example.castshow.core.util.CharacterStatus
import com.example.castshow.ui.theme.DarkerGreen
import com.example.castshow.ui.theme.Green

@Composable
fun CharacterCardItem(
    character: Character,
    onClick: () -> Unit,
) {

    val tintStatus = when (character.status.uppercase()) {
        CharacterStatus.DEAD.name -> Color.Red
        CharacterStatus.ALIVE.name -> Green
        else -> Color.Gray
    }

    Card(
        elevation = 5.dp,
        shape = RoundedCornerShape(15.dp),
        modifier = Modifier
            .fillMaxWidth(0.95f)
            .fillMaxHeight(0.8f)
            .clickable {
                onClick()
            }
            .padding(top = 10.dp)
            .border(1.dp, Color.Black, RoundedCornerShape(15.dp))

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
                    .padding(start = 5.dp, end = 5.dp)
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
                        .size(80.dp)
                        .border(1.dp, Color.Black, CircleShape)
                )

            }

            Column {
                Text(
                    text = character.name,
                    color = DarkerGreen,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Start,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 15.dp, start = 10.dp)
                )

                Row(
                    verticalAlignment = CenterVertically,
                    modifier = Modifier
                        .padding(start = 10.dp),
                ) {
                    Icon(
                        modifier = Modifier
                            .size(12.dp),
                        imageVector = Icons.Default.Circle,
                        contentDescription = "status color",
                        tint = tintStatus
                    )

                    Text(
                        text = "${character.status} ",
                        textAlign = TextAlign.Start,
                        modifier = Modifier.padding(start = 5.dp),
                    )
                }

            }
        }
    }
}