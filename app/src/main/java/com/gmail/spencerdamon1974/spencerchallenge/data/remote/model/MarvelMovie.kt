package com.gmail.spencerdamon1974.spencerchallenge.data.remote.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MarvelMovie(
    val poster: String,
    val title: String,
    val released: String,
    val genre: String,
    val rated: String,
    val runtime: String,
    val director: String,
    val writer: String,
    val actors: String,
    val plot: String
) : Parcelable
