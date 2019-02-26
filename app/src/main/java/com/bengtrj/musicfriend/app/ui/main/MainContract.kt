package com.bengtrj.musicfriend.app.ui.main

import com.bengtrj.musicfriend.app.ui.base.BaseContract

class MainContract {

    interface View: BaseContract.View {
        fun showAboutFragment()
        fun showListFragment()
    }

    interface Presenter: BaseContract.Presenter<MainContract.View> {
        fun onDrawerOptionAboutClick()
    }
}