package com.bengtrj.musicfriend.app.ui.main

import com.bengtrj.musicfriend.app.ui.main.MainContract.View

class MainPresenter: MainContract.Presenter {

    private lateinit var view: View

    override fun attach(view: View) {
        this.view = view
        view.showListFragment()
    }

    override fun onDrawerOptionAboutClick() {
        view.showAboutFragment()
    }
}