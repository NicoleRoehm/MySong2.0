package com.example.mysong

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mysong.data.SongRepository
import com.example.mysong.data.remote.SongApi
import kotlinx.coroutines.launch

class SongViewModel : ViewModel() {

    private val repository = SongRepository(SongApi)

    val songs = repository.songs

    fun search(term: String){
        viewModelScope.launch {
            try {

                repository.search(term)
            }catch (e:Exception){

                Log.e("SongViewModel", "error loading songs: $e")
            }
        }
    }
}