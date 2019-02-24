package com.bengtrj.android.musicfriend.app.di.module

import android.app.Application
import com.bengtrj.android.musicfriend.app.BaseApp
import com.bengtrj.android.musicfriend.app.di.scope.ApplicationScope
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