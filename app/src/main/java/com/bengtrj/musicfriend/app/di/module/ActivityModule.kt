package com.bengtrj.musicfriend.app.di.module

import android.app.Activity
import com.bengtrj.musicfriend.app.ui.main.Contract
import com.bengtrj.musicfriend.app.ui.main.MainPresenter
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private var activity: Activity) {

    @Provides
    fun provideActivity(): Activity {
        return activity
    }

    @Provides
    fun providePresenter(): Contract.Presenter {
        return MainPresenter()
    }

}