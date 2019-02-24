package com.bengtrj.android.musicfriend.app.di.module

import android.app.Activity
import com.bengtrj.android.musicfriend.app.ui.main.MainContract
import com.bengtrj.android.musicfriend.app.ui.main.MainPresenter
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private var activity: Activity) {

    @Provides
    fun provideActivity(): Activity {
        return activity
    }

    @Provides
    fun providePresenter(): MainContract.Presenter {
        return MainPresenter()
    }

}