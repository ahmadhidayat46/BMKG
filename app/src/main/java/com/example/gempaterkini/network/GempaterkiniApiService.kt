package com.example.gempaterkini.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://data.bmkg.go.id/gempabumi/"
private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface GempaterkiniApiService {
    @GET("https://data.bmkg.go.id/DataMKG/TEWS/gempaterkini.json")
    suspend fun getGempaterkinis(): List<Gempaterkini>
}

object GempaterkiniApi {
    val service: GempaterkiniApiService by lazy {
        retrofit.create(GempaterkiniApiService::class.java)
    }
}

