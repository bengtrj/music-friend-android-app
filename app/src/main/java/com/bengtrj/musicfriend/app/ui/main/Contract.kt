package com.bengtrj.musicfriend.app.ui.main

import com.bengtrj.musicfriend.app.ui.base.BaseContract

class Contract {

    interface View: BaseContract.View {
        fun showAboutFragment()
        fun showListFragment()
    }

    interface Presenter: BaseContract.Presenter<Contract.View> {
        fun onDrawerOptionAboutClick()
    }
}