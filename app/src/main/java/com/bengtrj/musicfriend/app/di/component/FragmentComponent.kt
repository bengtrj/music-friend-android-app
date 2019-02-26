package com.bengtrj.musicfriend.app.di.component

import com.bengtrj.musicfriend.app.di.module.FragmentModule
import com.bengtrj.musicfriend.app.ui.appinfo.AppInfoFragment
import com.bengtrj.musicfriend.app.ui.list.ListFragment
import dagger.Component

@Component(modules = [FragmentModule::class])
interface FragmentComponent {

    fun inject(appInfoFragment: AppInfoFragment)

    fun inject(listFragment: ListFragment)

}