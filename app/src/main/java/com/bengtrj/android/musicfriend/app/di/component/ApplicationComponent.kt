package com.bengtrj.android.musicfriend.app.di.component

import com.bengtrj.android.musicfriend.app.BaseApp
import com.bengtrj.android.musicfriend.app.di.module.ApplicationModule
import dagger.Component

@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(application: BaseApp)

}