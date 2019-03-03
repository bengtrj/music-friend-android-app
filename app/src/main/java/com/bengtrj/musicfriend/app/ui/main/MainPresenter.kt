package com.bengtrj.musicfriend.app.ui.main

import com.bengtrj.musicfriend.app.ui.main.Contract.View
import io.reactivex.disposables.CompositeDisposable

class MainPresenter: Contract.Presenter {

    private lateinit var view: View

    override fun detach() {
    }

    override fun attach(view: View) {
        this.view = view
        view.showListFragment()
    }

    override fun onDrawerOptionAboutClick() {
        view.showAboutFragment()
    }
}