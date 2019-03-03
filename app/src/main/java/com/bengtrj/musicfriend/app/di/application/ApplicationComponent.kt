package com.bengtrj.musicfriend.app.di.application

import com.bengtrj.musicfriend.app.BaseApp
import dagger.Component

@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(application: BaseApp)

}