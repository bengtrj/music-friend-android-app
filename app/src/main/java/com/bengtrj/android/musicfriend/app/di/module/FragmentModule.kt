package com.bengtrj.android.musicfriend.app.di.module

import com.bengtrj.android.musicfriend.app.api.ApiServiceInterface
import com.bengtrj.android.musicfriend.app.ui.list.ListContract
import com.bengtrj.android.musicfriend.app.ui.list.ListPresenter
import dagger.Module
import dagger.Provides

@Module
class FragmentModule {

    @Provides
    fun provideListPresenter(): ListContract.Presenter {
        return ListPresenter()
    }

    @Provides
    fun provideApiService(): ApiServiceInterface {
        return ApiServiceInterface.create()
    }
}