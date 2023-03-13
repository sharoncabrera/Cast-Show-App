package com.example.castshow.cast_show_feature.domain.model

import androidx.compose.runtime.Stable
import androidx.compose.runtime.mutableStateOf


@Stable
class Filter(
    val name: String,
    enabled: Boolean = false,
) {
    val enabled = mutableStateOf(enabled)
}

val statusFilters = listOf(
    Filter(name = "alive"),
    Filter(name = "dead"),
    Filter(name = "unknown"),
)
val genderFilters = listOf(
    Filter(name = "female"),
    Filter(name = "male"),
    Filter(name = "genderless"),
    Filter(name = "unknown"),
)
