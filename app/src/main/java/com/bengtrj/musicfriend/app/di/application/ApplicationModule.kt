package com.bengtrj.musicfriend.app.di.application

import android.app.Application
import com.bengtrj.musicfriend.app.BaseApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val baseApp: BaseApp) {

    @Provides
    @Singleton
    @ApplicationScope
    fun provideApplication(): Application {
        return baseApp
    }
}