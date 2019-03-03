package com.bengtrj.musicfriend.app.di.listAlbums

import com.bengtrj.musicfriend.app.ui.list.Presenter
import dagger.Component

@Component(modules = [PresenterModule::class])
interface PresenterComponent {

    fun inject(presenter: Presenter)

}