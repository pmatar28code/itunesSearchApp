package com.devslopes.itunessearch

import com.devslopes.itunessearch.repositories.ItunesMovieService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object ItunesMovieClient {
    const val baseUrl = "https://itunes.apple.com"
    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()
    private val client = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()
    val ItunesMovieServiceT = client.create(ItunesMovieService::class.java)
}