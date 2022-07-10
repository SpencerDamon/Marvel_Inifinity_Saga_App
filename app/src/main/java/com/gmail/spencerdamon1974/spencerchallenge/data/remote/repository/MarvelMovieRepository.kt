package com.gmail.spencerdamon1974.spencerchallenge.data.remote.repository

import com.gmail.spencerdamon1974.spencerchallenge.data.remote.api.MarvelMovieApiClient
import com.gmail.spencerdamon1974.spencerchallenge.data.remote.model.MarvelResponse

class MarvelMovieRepository {
    private val apiService = MarvelMovieApiClient.retrofitInstance
    suspend fun getMarvelMovies(): MarvelResponse = apiService.getAllMarvelMovies()
}