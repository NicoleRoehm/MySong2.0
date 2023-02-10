package com.example.mysong.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mysong.data.model.Song
import com.example.mysong.data.remote.SongApi

class SongRepository (private val api: SongApi) {

    private val _songs = MutableLiveData<List<Song>>()
    val songs: LiveData<List<Song>>
    get() = _songs

    suspend fun search(term:String){
        _songs.value = api.retrofitService.getSongs(term, "music").results

        }
}
