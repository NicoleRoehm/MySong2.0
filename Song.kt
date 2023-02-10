package com.example.mysong.data.model

import com.squareup.moshi.Json

data class Song (
    @Json(name = "trackId")
    val id: Int,
    @Json(name = "trackName")
    val title: String,
    @Json(name = "artistName")
    val artist: String
        )
