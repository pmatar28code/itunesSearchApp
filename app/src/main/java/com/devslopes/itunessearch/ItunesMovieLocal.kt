package com.devslopes.itunessearch

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

data class ItunesMovieLocal(
        val resultCount: Int,
        val results: List<Result>
) {
        data class Result(
                // @Json(name = "artistId")
                // val artistId: Int,
                val artistName: String,
                // @Json(name = "artistViewUrl")
                //  val artistViewUrl: String,
                val artworkUrl100: String,
                val artworkUrl30: String,
                val artworkUrl60: String,
                //@Json(name = "collectionArtistId")
                // val collectionArtistId: Int,
                // @Json(name = "collectionArtistViewUrl")
                // val collectionArtistViewUrl: String,
                // @Json(name = "collectionCensoredName")
                // val collectionCensoredName: String,
                val collectionExplicitness: String,
                val collectionHdPrice: Double,
                //  @Json(name = "collectionId")
                //val collectionId: Int,
                //@Json(name = "collectionName")
                // val collectionName: String,
                val collectionPrice: Double,
                //@Json(name = "collectionViewUrl")
                //val collectionViewUrl: String,
                val contentAdvisoryRating: String,
                val country: String,
                val currency: String,
                //@Json(name = "discCount")
                // val discCount: Int,
                //@Json(name = "discNumber")
                //val discNumber: Int,
                // @Json(name = "hasITunesExtras")
                // val hasITunesExtras: Boolean,
                val kind: String,
                val longDescription: String,
                val previewUrl: String,
                val primaryGenreName: String,
                val releaseDate: String,
                val trackCensoredName: String,
                // @Json(name = "trackCount")
                // val trackCount: Int,
                val trackExplicitness: String,
                val trackHdPrice: Double,
                // @Json(name = "trackHdRentalPrice")
                // val trackHdRentalPrice: Double,
                val trackId: Int,
                val trackName: String,
                //  @Json(name = "trackNumber")
                // val trackNumber: Int,
                val trackPrice: Double,
                // @Json(name = "trackRentalPrice")
                // val trackRentalPrice: Double,
                val trackTimeMillis: Int,
                val trackViewUrl: String,
                val wrapperType: String
        )
}
/*
data class ItunesMovieLocal(
        val resultCount: Int,
        val results: List<Result>
) {
    data class Result(
            val artistId: Int,
            val artistName: String,
            val artistViewUrl: String,
            val artworkUrl100: String,
            val artworkUrl30: String,
            val artworkUrl60: String,
            val collectionArtistId: Int,
            val collectionArtistViewUrl: String,
            val collectionCensoredName: String,
            val collectionExplicitness: String,
            val collectionHdPrice: Double,
            val collectionId: Int,
            var collectionName: String,
            val collectionPrice: Double,
            val collectionViewUrl: String,
            val contentAdvisoryRating: String,
            val country: String,
            val currency: String,
            val discCount: Int,
            val discNumber: Int,
            val hasITunesExtras: Boolean,
            val kind: String,
            val longDescription: String,
            val previewUrl: String,
            val primaryGenreName: String,
            val releaseDate: String,
            val trackCensoredName: String,
            val trackCount: Int,
            val trackExplicitness: String,
            val trackHdPrice: Double,
            val trackHdRentalPrice: Double,
            val trackId: Int,
            var trackName: String,
            val trackNumber: Int,
            val trackPrice: Double,
            val trackRentalPrice: Double,
            val trackTimeMillis: Int,
            val trackViewUrl: String,
            val wrapperType: String
    )
}

 */