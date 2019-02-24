package com.bengtrj.android.musicfriend.app.ui.list

import com.bengtrj.android.musicfriend.app.api.ApiServiceInterface
import com.bengtrj.android.musicfriend.app.models.Album
import com.bengtrj.android.musicfriend.app.models.AlbumsQueryResult
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class ListPresenter: ListContract.Presenter {

    private val subscriptions = CompositeDisposable()
    private val api: ApiServiceInterface = ApiServiceInterface.create()
    private lateinit var view: ListContract.View

    override fun subscribe() {

    }

    override fun unsubscribe() {
        subscriptions.clear()
    }

    override fun attach(view: ListContract.View) {
        this.view = view
    }

    override fun loadData() {
        val subscribe = api.getAlbumListByArtist("satriani").subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ result: AlbumsQueryResult ? ->
                    //TODO handle empty / null list
                    view.showProgress(false)
                    view.loadDataSuccess(result!!.albums)
                }, { error ->
                    view.showProgress(false)
                    view.showErrorMessage(error.localizedMessage)
                })

        subscriptions.add(subscribe)
    }

    override fun deleteItem(item: AlbumsQueryResult) {
        //api.deleteUser(item.id)
    }
}