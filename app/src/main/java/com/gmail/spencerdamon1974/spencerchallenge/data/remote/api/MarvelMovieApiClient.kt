package com.gmail.spencerdamon1974.spencerchallenge.data.remote.api


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MarvelMovieApiClient {
    private const val BASE_URL="https://private-b34167-rvmarvel.apiary-mock.com/"
    val retrofitInstance: MarvelMovieApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MarvelMovieApi::class.java)
    }
}