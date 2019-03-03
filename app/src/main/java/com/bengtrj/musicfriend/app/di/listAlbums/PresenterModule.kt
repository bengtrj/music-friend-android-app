package com.bengtrj.musicfriend.app.di.listAlbums

import com.bengtrj.musicfriend.app.api.ApiServiceInterface
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class PresenterModule {

    @Provides
    fun provideSubscriptions(): CompositeDisposable {
        return CompositeDisposable()
    }

    @Provides
    fun provideApiService(): ApiServiceInterface {
        return ApiServiceInterface.create()
    }

}