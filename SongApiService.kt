package com.example.mysong.data.remote

import com.example.mysong.data.model.ServerResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


//bei Kopie: Base Url anpassen

const val BASE_URL = "https://itunes.apple.com/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface SongApiService {

    // endpunkt anpassen und funktionen anpassen


    @GET("search")
    suspend fun getSongs(@Query("term") term: String, @Query("media") media:String): ServerResponse
}

object SongApi {
    val retrofitService: SongApiService by lazy { retrofit.create(SongApiService::class.java) }
}