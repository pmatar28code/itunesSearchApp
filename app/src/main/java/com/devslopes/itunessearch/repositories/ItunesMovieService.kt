package com.devslopes.itunessearch.repositories
import com.devslopes.itunessearch.ItunesMovieServer
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ItunesMovieService {
    @GET("/search?")
    fun getMovie(@Query("media") media:String, @Query("term")
    term:String): Call<ItunesMovieServer>
}