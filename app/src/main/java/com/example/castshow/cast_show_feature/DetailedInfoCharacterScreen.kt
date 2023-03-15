package com.example.castshow.cast_show_feature

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
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
import androidx.hilt.navigation.compose.hiltViewModel
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
    characterId: String?,
    detailedInfoViewModel: DetailedInfoViewModel = hiltViewModel()
) {
    val tintStatus = when (detailedInfoViewModel.characterItem.status.uppercase()) {
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
                        .data(detailedInfoViewModel.characterItem.image)
                        .crossfade(true)
                        .build(),
                    contentDescription = "${detailedInfoViewModel.characterItem.name} photo",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(200.dp)
                        .border(4.dp, tintStatus, CircleShape)
                )

            }

            Text(
                text = detailedInfoViewModel.characterItem.name,
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
            if (detailedInfoViewModel.characterItem.type.isNotEmpty()) {
                IconText(Icons.Default.Face, detailedInfoViewModel.characterItem.type)
                Divider()
            }

            IconText(Icons.Default.Hub, detailedInfoViewModel.characterItem.species)
            Divider()
            IconText(Icons.Default.Transgender, detailedInfoViewModel.characterItem.gender)
            Divider()
            IconText(Icons.Default.Home, detailedInfoViewModel.characterItem.origin)
            Divider()
            IconText(Icons.Default.LocationOn, detailedInfoViewModel.characterItem.location)
            Text(
                modifier = Modifier.padding(top = 10.dp, start = 5.dp, bottom = 10.dp),
                text = "Episodes in which the character has appeared:",
                color = Color.Gray,
                fontWeight = FontWeight.Bold,
            )
            IconText(
                Icons.Default.Tv,
                "${detailedInfoViewModel.characterItem.episode} episode${if (detailedInfoViewModel.characterItem.episode > 1) "s" else ""}"

            )
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