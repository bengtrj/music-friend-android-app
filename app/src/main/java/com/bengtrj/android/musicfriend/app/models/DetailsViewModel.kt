package com.bengtrj.android.musicfriend.app.models

import com.google.gson.Gson

data class DetailsViewModel(val posts: List<AlbumsQueryResult>, val users: List<User>, val albums: List<Album>) {
    fun asJson(): String {
        return Gson().toJson(this)
    }
}