package com.gmail.spencerdamon1974.spencerchallenge.data.remote.model

import com.google.gson.annotations.SerializedName

data class Released(
    @SerializedName("released")
    val movieReleased: String
)
