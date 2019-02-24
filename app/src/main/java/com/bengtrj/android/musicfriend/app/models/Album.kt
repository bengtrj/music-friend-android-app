package com.bengtrj.android.musicfriend.app.models

import com.google.gson.annotations.SerializedName

//TODO transfer this to txt files for tests
data class Album(@SerializedName("collectionId") val id: Int,
                 @SerializedName("collectionName") val name: String,
                 val artistName: String,
                 @SerializedName("artworkUrl60") val artworkUrl: String,
                 @SerializedName("primaryGenreName") val genre: String,
                 val trackCount: Int)

/*
{
  "wrapperType": "collection",
  "collectionType": "Album",
  "artistId": 466941,
  "collectionId": 405602019,
  "amgArtistId": 5354,
  "artistName": "Joe Satriani",
  "collectionName": "Surfing with the Alien",
  "collectionCensoredName": "Surfing with the Alien",
  "artistViewUrl": "https://itunes.apple.com/us/artist/joe-satriani/466941?uo=4",
  "collectionViewUrl": "https://itunes.apple.com/us/album/surfing-with-the-alien/405602019?uo=4",
  "artworkUrl60": "https://is5-ssl.mzstatic.com/image/thumb/Music128/v4/53/61/03/53610385-378e-96ee-2690-2f50dce27700/source/60x60bb.jpg",
  "artworkUrl100": "https://is5-ssl.mzstatic.com/image/thumb/Music128/v4/53/61/03/53610385-378e-96ee-2690-2f50dce27700/source/100x100bb.jpg",
  "collectionPrice": 8.99,
  "collectionExplicitness": "notExplicit",
  "trackCount": 10,
  "copyright": "℗ 1987, 2007 Sony Music Entertainment",
  "country": "USA",
  "currency": "USD",
  "releaseDate": "2007-08-07T07:00:00Z",
  "primaryGenreName": "Rock"
}
 */