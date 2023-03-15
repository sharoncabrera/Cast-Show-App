package com.example.castshow.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.FilterList
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.example.castshow.cast_show_feature.domain.model.Filter
import com.example.castshow.ui.theme.Black
import com.example.castshow.ui.theme.DarkerGreen
import com.example.castshow.ui.theme.Green
import com.example.castshow.ui.theme.White

@Composable
fun FilterBar(
    filters: List<Filter>,
    icon: ImageVector = Icons.Rounded.FilterList,
    onClickFilter: (filterName: String) -> Unit
) {

    LazyRow(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(start = 10.dp, end = 5.dp),
        modifier = Modifier.heightIn(min = 56.dp)
    ) {
        item {

            Icon(
                imageVector = icon,
                tint = Color.White,
                contentDescription = "filter icon",
            )

        }

        items(filters) { filter ->
            FilterChip(filter = filter, onClickFilter = onClickFilter)
        }
    }
}

@Composable
fun FilterChip(
    filter: Filter,
    modifier: Modifier = Modifier,
    onClickFilter: (filterName: String) -> Unit

) {
    val (selected, setSelected) = filter.enabled
    val backgroundColor by animateColorAsState(
        if (selected) {
            onClickFilter(filter.name)
            Green
        } else {
            DarkerGreen
        }
    )
    val textColor by animateColorAsState(
        if (selected) White else Black
    )

    Card(
        contentColor = Black,
        shape = RoundedCornerShape(15.dp),
        elevation = 2.dp,
        modifier = modifier
            .height(28.dp)
            .border(1.dp, color = Color.Black, shape = RoundedCornerShape(15.dp))


    ) {
        val interactionSource = remember { MutableInteractionSource() }

        val pressed by interactionSource.collectIsPressedAsState()

        val backgroundPressed =
            if (pressed) {
                Modifier.background(Color.Green)
            } else {
                Modifier.background(Color.White)
            }
        Box(
            modifier = Modifier
                .toggleable(
                    value = selected,
                    onValueChange = setSelected,
                    interactionSource = interactionSource,
                    indication = null
                )
                .then(backgroundPressed)
                .background(backgroundColor)


        ) {
            Text(
                text = filter.name,
                style = MaterialTheme.typography.caption,
                maxLines = 1,
                modifier = Modifier.padding(
                    horizontal = 20.dp,
                    vertical = 6.dp
                )

            )
        }
    }
}