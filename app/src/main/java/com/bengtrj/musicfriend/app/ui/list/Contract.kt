package com.bengtrj.musicfriend.app.ui.list

import com.bengtrj.musicfriend.app.models.Album
import com.bengtrj.musicfriend.app.ui.BaseContract
import com.bengtrj.musicfriend.app.models.AlbumsQueryResult

class Contract {

    interface View: BaseContract.View {
        fun showProgress(show: Boolean)
        fun showErrorMessage(error: String)
        fun loadDataSuccess(list: List<Album>)
    }

    interface Presenter: BaseContract.Presenter<View> {
        fun loadData()
        fun deleteItem(item: AlbumsQueryResult)
    }
}