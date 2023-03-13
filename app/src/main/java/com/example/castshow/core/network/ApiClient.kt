package com.example.castshow.core.network

import com.example.castshow.core.domain.model.ApiResponse
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import com.example.castshow.core.domain.model.CharacterResponse

class ApiClient {
    companion object {
        lateinit var instance: ApiClient
    }
    var page = 1
    var numberTotalofPages = 1

    private val baseUrl = "https://rickandmortyapi.com/api/"
    private val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(Json { ignoreUnknownKeys = true })
        }
    }

    suspend fun getData(): Result<List<CharacterResponse>> {

        if (page > numberTotalofPages) {
            return Result.success(listOf())
        }

        //"https://rickandmortyapi.com/api/character?page=2"
        val response = client.get {
            url("${baseUrl}character")
            parameter("page", page)
        }
        return if (response.status.isSuccess()) {
            page++
            val result: ApiResponse = response.body()

          //  numberTotalofPages = result.total
            Result.success(result.results)
        } else {
            Result.failure(error("Something went wrong"))
        }
    }

    suspend fun getDataFilteredBy(status: String, gender: String) :  Result<List<CharacterResponse>>{
        //https://rickandmortyapi.com/api/character/?status=alive
        //https://rickandmortyapi.com/api/character/?gender=male&?status=alive?
        val response = client.get {
            url("${baseUrl}character")
            parameter("status", status)
            parameter("gender", gender)
        }
        return if (response.status.isSuccess()) {
            val result: ApiResponse = response.body()
            Result.success(result.results)
        } else {
            Result.failure(error("Something went wrong"))
        }
    }
}