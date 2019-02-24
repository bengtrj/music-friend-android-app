package com.bengtrj.android.musicfriend.app.api

import com.bengtrj.android.musicfriend.app.models.AlbumsQueryResult
import com.bengtrj.android.musicfriend.app.util.Constants
import io.reactivex.Observable
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServiceInterface {

    @GET("search?media=music&entity=album&attribute=artistTerm&country=US")
    fun getAlbumListByArtist(@Query("term") artistName: String): Observable<AlbumsQueryResult>

    companion object Factory {

        private const val BASE_URL = "https://itunes.apple.com/"

        fun create(): ApiServiceInterface {
            val retrofit = retrofit2.Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BASE_URL)
                    .build()

            return retrofit.create(ApiServiceInterface::class.java)
        }
    }
}