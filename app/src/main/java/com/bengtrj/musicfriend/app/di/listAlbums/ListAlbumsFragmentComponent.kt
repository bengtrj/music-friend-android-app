package com.bengtrj.musicfriend.app.di.listAlbums

import com.bengtrj.musicfriend.app.ui.listAlbums.ListAlbumsFragment
import dagger.Component

@Component(modules = [ListAlbumsFragmentModule::class])
interface ListAlbumsFragmentComponent {

    fun inject(listAlbumsFragment: ListAlbumsFragment)

}