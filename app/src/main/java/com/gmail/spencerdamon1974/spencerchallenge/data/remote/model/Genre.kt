package com.gmail.spencerdamon1974.spencerchallenge.data.remote.model

import com.google.gson.annotations.SerializedName

data class Genre(
    @SerializedName("genre")
    val movieGenre: String
)
