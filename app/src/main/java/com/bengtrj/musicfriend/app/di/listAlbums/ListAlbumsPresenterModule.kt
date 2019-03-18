package com.bengtrj.musicfriend.app.di.listAlbums

import android.content.res.Resources
import com.bengtrj.musicfriend.app.BaseApp
import com.bengtrj.musicfriend.app.api.ApiServiceInterface
import com.bengtrj.musicfriend.app.util.rx.DefaultSchedulerProvider
import com.bengtrj.musicfriend.app.util.rx.SchedulerProvider
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Module
class ListAlbumsPresenterModule {

    @Provides
    @Singleton
    fun provideSubscriptions(): CompositeDisposable {
        return CompositeDisposable()
    }

    @Provides
    @Singleton
    fun provideApiService(): ApiServiceInterface {
        return ApiServiceInterface.create()
    }

    @Provides
    @Singleton
    fun provideSchedulerProvider(): SchedulerProvider {
        return DefaultSchedulerProvider()
    }

    @Provides
    @Singleton
    fun provideResources(): Resources {
        return BaseApp.appResources
    }

}