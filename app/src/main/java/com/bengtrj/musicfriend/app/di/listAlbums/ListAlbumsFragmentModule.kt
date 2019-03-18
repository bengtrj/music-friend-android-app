package com.bengtrj.musicfriend.app.di.listAlbums

import com.bengtrj.musicfriend.app.ui.listAlbums.ListAlbumsContract
import com.bengtrj.musicfriend.app.ui.listAlbums.ListAlbumsPresenter
import dagger.Module
import dagger.Provides

@Module
class ListAlbumsFragmentModule {

    @Provides
    fun provideListPresenter(): ListAlbumsContract.Presenter {
        return ListAlbumsPresenter()
    }

}