package com.bengtrj.android.musicfriend.app.models

import com.google.gson.annotations.SerializedName


//TODO transfer this to txt files for tests
data class AlbumsQueryResult(@SerializedName("resultCount") val count: Int,
                             @SerializedName("results") val albums: List<Album>)

/*
{
  "resultCount": 32,
  "results": [
     (...)
  ]
}
 */