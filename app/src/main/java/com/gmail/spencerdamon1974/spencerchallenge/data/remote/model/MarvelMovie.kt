package com.gmail.spencerdamon1974.spencerchallenge.data.remote.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MarvelMovie(
    val poster: String, //Poster,
    val title: String, //Title,
    val released: String, //Released,
    val genre: String, //Genre
    val rated: String,
    val runtime: String,
    val director: String,
    val writer: String,
    val actors: String,
    val plot: String
) : Parcelable
