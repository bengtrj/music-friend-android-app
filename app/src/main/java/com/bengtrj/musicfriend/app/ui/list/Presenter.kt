package com.bengtrj.musicfriend.app.ui.list

import com.bengtrj.musicfriend.app.api.ApiServiceInterface
import com.bengtrj.musicfriend.app.di.listAlbums.DaggerPresenterComponent
import com.bengtrj.musicfriend.app.di.listAlbums.PresenterModule
import com.bengtrj.musicfriend.app.models.AlbumsQueryResult
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class Presenter : Contract.Presenter {

    @Inject
    lateinit var subscriptions: CompositeDisposable

    @Inject
    lateinit var apiService: ApiServiceInterface

    private lateinit var view: Contract.View

    init {
        injectDependency()
    }

    override fun detach() {
        subscriptions.clear()
    }

    override fun attach(view: Contract.View) {
        this.view = view
    }

    override fun loadData() {
        val subscribe = apiService.getAlbumListByArtist("satriani")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ result: AlbumsQueryResult? ->
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
        //apiService.deleteUser(item.id)
    }

    private fun injectDependency() {
        val presenterComponent = DaggerPresenterComponent.builder()
                .presenterModule(PresenterModule()).build()
        presenterComponent.inject(this)
    }

}
