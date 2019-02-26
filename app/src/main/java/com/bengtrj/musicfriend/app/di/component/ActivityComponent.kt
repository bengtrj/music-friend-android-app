package com.bengtrj.musicfriend.app.di.component

import com.bengtrj.musicfriend.app.di.module.ActivityModule
import com.bengtrj.musicfriend.app.ui.main.MainActivity
import dagger.Component

@Component(modules = [ActivityModule::class])
interface ActivityComponent {

    fun inject(mainActivity: MainActivity)

}