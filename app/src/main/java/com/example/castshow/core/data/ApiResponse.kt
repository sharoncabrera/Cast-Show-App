package com.example.castshow.core.data

import kotlinx.serialization.Serializable


@Serializable
data class ApiResponse(var info: InfoResponse, var results: List<CharacterResponse>)
