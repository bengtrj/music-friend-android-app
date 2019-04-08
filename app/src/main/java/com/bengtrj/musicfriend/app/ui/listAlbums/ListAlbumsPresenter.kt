package com.bengtrj.musicfriend.app.ui.listAlbums

import android.content.res.Resources
import androidx.annotation.VisibleForTesting
import com.bengtrj.musicfriend.app.R
import com.bengtrj.musicfriend.app.api.ApiServiceInterface
import com.bengtrj.musicfriend.app.di.listAlbums.DaggerListAlbumsPresenterComponent
import com.bengtrj.musicfriend.app.di.listAlbums.ListAlbumsPresenterComponent
import com.bengtrj.musicfriend.app.di.listAlbums.ListAlbumsPresenterModule
import com.bengtrj.musicfriend.app.models.AlbumsQueryResult
import com.bengtrj.musicfriend.app.util.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

class ListAlbumsPresenter : ListAlbumsContract.Presenter {

    @Inject
    @set:VisibleForTesting
    lateinit var resources: Resources

    @Inject
    @set:VisibleForTesting
    lateinit var subscriptions: CompositeDisposable

    @Inject
    @set:VisibleForTesting
    lateinit var apiService: ApiServiceInterface

    @Inject
    @set:VisibleForTesting
    lateinit var schedulerProvider: SchedulerProvider

    private lateinit var view: ListAlbumsContract.View

    constructor(listAlbumsPresenterComponent: ListAlbumsPresenterComponent) {
        listAlbumsPresenterComponent.inject(this)
    }

    constructor() : this(
            DaggerListAlbumsPresenterComponent.builder()
                    .listAlbumsPresenterModule(ListAlbumsPresenterModule()).build()
    )

    override fun detach() {
        subscriptions.clear()
    }

    override fun attach(view: ListAlbumsContract.View) {
        this.view = view
    }

    override fun loadData() {
        val subscribe = apiService.getAlbumListByArtist("satriani")
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .subscribeBy(
                        onNext = { result: AlbumsQueryResult? ->
                            view.loadDataSuccess(result!!.albums)
                        },
                        onComplete = {
                            view.showProgress(false)
                        },
                        onError = { _ ->
                            view.showErrorMessage(resources.getString(R.string.album_load_error))
                        }
                )

        subscriptions.add(subscribe)
    }

    override fun deleteItem(item: AlbumsQueryResult) {
        //apiService.deleteUser(item.id)
    }

}
