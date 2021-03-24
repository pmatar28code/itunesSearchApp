package com.devslopes.itunessearch


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ItunesEbookServer(
    @Json(name = "resultCount")
    val resultCount: Int,
    @Json(name = "results")
    val results: List<Result>
) {
    @JsonClass(generateAdapter = true)
    data class Result(
        @Json(name = "artistId")
        val artistId: Int?,
        @Json(name = "artistIds")
        val artistIds: List<Int>?,
        @Json(name = "artistName")
        val artistName: String?,
        @Json(name = "artistViewUrl")
        val artistViewUrl: String?,
        @Json(name = "artworkUrl100")
        val artworkUrl100: String?,
        @Json(name = "artworkUrl60")
        val artworkUrl60: String?,
        @Json(name = "averageUserRating")
        val averageUserRating: Double?,
        @Json(name = "currency")
        val currency: String?,
        @Json(name = "description")
        val description: String?,
        @Json(name = "fileSizeBytes")
        val fileSizeBytes: Int?,
        @Json(name = "formattedPrice")
        val formattedPrice: String?,
        @Json(name = "genreIds")
        val genreIds: List<String>?,
        @Json(name = "genres")
        val genres: List<String>?,
        @Json(name = "kind")
        val kind: String?,
        @Json(name = "price")
        val price: Double?,
        @Json(name = "releaseDate")
        val releaseDate: String?,
        @Json(name = "trackCensoredName")
        val trackCensoredName: String?,
        @Json(name = "trackId")
        val trackId: Int?,
        @Json(name = "trackName")
        val trackName: String?,
        @Json(name = "trackViewUrl")
        val trackViewUrl: String?,
        @Json(name = "userRatingCount")
        val userRatingCount: Int?
    )
}