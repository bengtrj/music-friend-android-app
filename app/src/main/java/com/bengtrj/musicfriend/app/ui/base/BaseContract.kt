package com.bengtrj.musicfriend.app.ui.base

class BaseContract {

    interface Presenter<in T> {
        fun detach()
        fun attach(view: T)
    }

    interface View
}