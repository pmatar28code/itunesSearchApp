package com.devslopes.itunessearch.repositories

import android.content.Context
import android.widget.Toast
import com.devslopes.itunessearch.ItunesMovieClient
import com.devslopes.itunessearch.ItunesMovieLocal
import com.devslopes.itunessearch.ItunesMovieServer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object ItunesRepository {
    var trackNameLocal = ""
    var movieObj:ItunesMovieLocal.Result ?=null
    var movies: MutableList<ItunesMovieLocal.Result> ?= null
    var moviesTitles: MutableList<String> ?= null
    var moviesServer: List<ItunesMovieServer.Result>?=null
    var moviesServerMutable = mutableListOf<ItunesMovieServer.Result>()
    var movieObjServer:ItunesMovieServer.Result?=null
    var moviesServerString = mutableListOf<String>()

    fun callGetMovie( context:Context,media:String,term:String) {
        ItunesMovieClient.ItunesMovieServiceT.getMovie(media,term).
        enqueue(object : Callback<ItunesMovieServer> {
            override fun onFailure(call: Call<ItunesMovieServer>, t: Throwable) {
                Toast.makeText(context,"onFailure $t",Toast.LENGTH_LONG).show()

            }
            override fun onResponse(call: Call<ItunesMovieServer>, response: Response<ItunesMovieServer>) {
                if (response.isSuccessful) {
                   //use object
                    //Toast.makeText(context,"onResponse ${response.body()?.results?.get(0)?.trackName.toString()}",Toast.LENGTH_LONG).show()
                    moviesServer = response.body()?.results

                    for(item in moviesServer!!){
                        moviesServerString.add(item.trackName!!)
                    }


                    if(moviesServer !=null) {
                        for (item in moviesServer!!) {
                            movieObjServer = item//response.body()?.toItunesMovieLocal()
                            moviesServerMutable?.add(item!!)
                        }
                    }
                    for(item in response.body()!!.results){
                      //  var trackName = item.trackName
                        moviesTitles?.add(item.trackName!!)
                    }
                   // movieObj = response.body()?.toItunesMovieLocal()

                    //trackNameLocal =  response.body()?.results?.get(0)?.trackName.toString()
                    //Toast.makeText(context,"onResponse var ${trackNameLocal}",Toast.LENGTH_LONG).show()

                }
            }
        })
    }

    private fun ItunesMovieServer.toItunesMovieLocal(): ItunesMovieLocal.Result {
        return ItunesMovieLocal.Result(
            artistName = results[0]?.artistName?:"",
            artworkUrl100 = results[0]?.artworkUrl100?:"",
            artworkUrl30 = results[0]?.artworkUrl30?:"",
            artworkUrl60 = results[0]?.artworkUrl60?:"",
            collectionExplicitness = results[0]?.collectionExplicitness?:"",
            collectionHdPrice = results[0]?.collectionHdPrice ?: 0.00,
            collectionPrice = results[0]?.collectionPrice ?: 0.00,
            contentAdvisoryRating = results[0]?.contentAdvisoryRating?:"",
            country= results[0]?.country?:"",
            currency= results[0]?.currency?:"",
            kind = results[0]?.kind?:"",
            longDescription = results[0]?.longDescription?:"",
            previewUrl= results[0]?.previewUrl ?: "",
            primaryGenreName = results[0]?.primaryGenreName?:"",
           releaseDate= results[0]?.releaseDate?:"",
            trackCensoredName = results[0]?.trackCensoredName?:"",
             trackExplicitness = results[0]?.trackExplicitness?:"",
         trackHdPrice = results[0]?.trackHdPrice ?: 0.00,

         trackId = results[0]?.trackId?:0,
         trackName = results[0]?.trackName?:"",

         trackPrice = results[0]?.trackPrice ?: 0.00,

         trackTimeMillis = results[0]?.trackTimeMillis ?: 0,
         trackViewUrl = results[0]?.trackViewUrl?:"",
         wrapperType = results[0]?.wrapperType?:""
        )
    }

}