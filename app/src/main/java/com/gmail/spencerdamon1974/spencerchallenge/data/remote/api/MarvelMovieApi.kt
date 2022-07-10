package com.gmail.spencerdamon1974.spencerchallenge.data.remote.api

import com.gmail.spencerdamon1974.spencerchallenge.data.remote.model.MarvelResponse
import retrofit2.http.GET

interface MarvelMovieApi {
    @GET("saga")
    suspend fun getAllMarvelMovies(): MarvelResponse
}