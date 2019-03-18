package com.bengtrj.musicfriend.app.di.listAlbums

import com.bengtrj.musicfriend.app.ui.main.MainActivity
import dagger.Component

@Component(modules = [ListAlbumsActivityModule::class])
interface ListAlbumsActivityComponent {

    fun inject(mainActivity: MainActivity)

}