package com.bengtrj.musicfriend.app.ui.list

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.bengtrj.musicfriend.app.api.ApiServiceInterface

class ListWorker(context: Context, params: WorkerParameters) : Worker(context, params) {

    private val api: ApiServiceInterface = ApiServiceInterface.create()

    override fun doWork(): Result {
        return try {
            api.getAlbumListByArtist("satriani")
            Result.success()
        } catch (ex: Throwable) {
            Result.failure()
        }
    }
}