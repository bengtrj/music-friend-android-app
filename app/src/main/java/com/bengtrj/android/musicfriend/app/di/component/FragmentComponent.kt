package com.bengtrj.android.musicfriend.app.di.component

import com.bengtrj.android.musicfriend.app.di.module.FragmentModule
import com.bengtrj.android.musicfriend.app.ui.appinfo.AppInfoFragment
import com.bengtrj.android.musicfriend.app.ui.list.ListFragment
import dagger.Component

@Component(modules = [FragmentModule::class])
interface FragmentComponent {

    fun inject(appInfoFragment: AppInfoFragment)

    fun inject(listFragment: ListFragment)

}