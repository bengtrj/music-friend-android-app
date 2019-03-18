package com.bengtrj.musicfriend.app.di.listAlbums

import com.bengtrj.musicfriend.app.ui.main.MainContract
import com.bengtrj.musicfriend.app.ui.main.MainPresenter
import dagger.Module
import dagger.Provides

@Module
class ListAlbumsActivityModule {

    @Provides
    fun providePresenter(): MainContract.Presenter {
        return MainPresenter()
    }

}