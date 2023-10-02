package com.example.mymovies.network

import com.example.mymovies.network.response.PeliculasResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WebService {
    @GET("now_playing")
    suspend fun obtenerCartelera(
        @Query("api_key") apiKey:String
    ): Response<PeliculasResponse>

    @GET("popular")
    suspend fun obtenerPopular(
        @Query("api_key") apiKey: String
    ):Response<PeliculasResponse>
}