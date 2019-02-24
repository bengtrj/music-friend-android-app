package com.bengtrj.android.musicfriend.app.di.component

import com.bengtrj.android.musicfriend.app.di.module.ActivityModule
import com.bengtrj.android.musicfriend.app.ui.main.MainActivity
import dagger.Component

@Component(modules = [ActivityModule::class])
interface ActivityComponent {

    fun inject(mainActivity: MainActivity)

}