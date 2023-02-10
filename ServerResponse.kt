package com.example.mysong.data.model

data class ServerResponse (
    val resultCount: Int,
    val results: List<Song>
        )