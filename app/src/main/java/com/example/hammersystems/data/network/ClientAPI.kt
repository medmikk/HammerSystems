package com.example.hammersystems.data.network

import com.example.hammersystems.domain.model.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ClientAPI {

    @GET("search?")
    suspend fun getPizzas(
        @Query("apiKey") apiKey: String,
        @Query("query") query: String,
        @Query("number") number: Int
    ): ApiResponse
}