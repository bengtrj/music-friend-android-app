package com.bengtrj.musicfriend.app.ui

class BaseContract {

    interface Presenter<in T> {
        fun detach() {

        }
        fun attach(view: T)
    }

    interface View
}