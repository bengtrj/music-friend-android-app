package com.bengtrj.musicfriend.app.di.listAlbums

import com.bengtrj.musicfriend.app.ui.list.Contract
import com.bengtrj.musicfriend.app.ui.list.Presenter
import dagger.Module
import dagger.Provides

@Module
class FragmentModule {

    @Provides
    fun provideListPresenter(): Contract.Presenter {
        return Presenter()
    }

}