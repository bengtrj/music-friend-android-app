package com.bengtrj.musicfriend.app.di.component

import com.bengtrj.musicfriend.app.BaseApp
import com.bengtrj.musicfriend.app.di.module.ApplicationModule
import dagger.Component

@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(application: BaseApp)

}