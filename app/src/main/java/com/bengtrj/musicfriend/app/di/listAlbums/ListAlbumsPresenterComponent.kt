package com.bengtrj.musicfriend.app.di.listAlbums

import com.bengtrj.musicfriend.app.ui.listAlbums.ListAlbumsPresenter
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ListAlbumsPresenterModule::class])
interface ListAlbumsPresenterComponent {

    fun inject(listAlbumsPresenter: ListAlbumsPresenter)

}