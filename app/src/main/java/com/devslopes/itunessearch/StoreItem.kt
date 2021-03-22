package com.devslopes.itunessearch

data class StoreItem(
    var wrapperType: String, //track
    var kind : String, //song
    var artistId:Int, //487143
    var collectionId:Int,//1065973975
    var trackId:Int,//1065973977
    var artistNmae:String, //Pink Floyd
    var collectionName:String, //Wish You Were Here
    var trackName:String,//Shine On You Crazy Diamond, Pts 1 - 5
    var collectionCensoredName:String, // Wish You Were here
    var trackCensoredName:String, //Shine On You Crazy Diamond, Pts. 1-5
    var artistViewUrl:String,//https://music.apple.com/us/artist/pink-floyd/487143?uo=4"
    var collectionViewUrl:String,//https://music.apple.com/us/album/shine-on-you-crazy-diamond-pts-1-5/1065973975?i=1065973977&uo=4"
    var trackViewUrl:String,//https://music.apple.com/us/album/shine-on-you-crazy-diamond-pts-1-5/1065973975?i=1065973977&uo=4",
    var previewUrl:String,//https://audio-ssl.itunes.apple.com/itunes-assets/AudioPreview71/v4/29/ac/6e/29ac6efd-23a7-ffa2-1981-464b441e9d8d/mzaf_4396837489193908363.plus.aac.p.m4a",
    var artworkUrl30:String,//https://is2-ssl.mzstatic.com/image/thumb/Music69/v4/65/70/93/65709306-3521-fdbe-9f90-5ade54eec9c8/source/30x30bb.jpg",
    var artworkUrl60:String,//https://is2-ssl.mzstatic.com/image/thumb/Music69/v4/65/70/93/65709306-3521-fdbe-9f90-5ade54eec9c8/source/60x60bb.jpg"
    var artworkUrl100:String,//https://is2-ssl.mzstatic.com/image/thumb/Music69/v4/65/70/93/65709306-3521-fdbe-9f90-5ade54eec9c8/source/100x100bb.jpg",
    var collectionPrice:Double, //12.99
    var trackPrice:Double,//-1.00
    var releaseDate:String, //1975-09-12T07:00:00Z",
    var collectionExplicitness:String,//notExplicit
    var trackExplicitness:String, //notExplicit"
    var discCount:Int, //1
    var discNumber:Int, //1,
    var trackCount:Int,//5,
    var trackNumber:Int, //1
    var trackTimeMillis:Long,//811077,
    var country :String, //USA
    var currency:String, //USD
    var primaryGenreName :String, //Rock"
    var isStreamable : Boolean //true}
)
