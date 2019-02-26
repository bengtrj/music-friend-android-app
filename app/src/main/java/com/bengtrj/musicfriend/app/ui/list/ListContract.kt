package com.bengtrj.musicfriend.app.ui.list

import com.bengtrj.musicfriend.app.models.Album
import com.bengtrj.musicfriend.app.ui.base.BaseContract
import com.bengtrj.musicfriend.app.models.DetailsViewModel
import com.bengtrj.musicfriend.app.models.AlbumsQueryResult

class ListContract {

    interface View: BaseContract.View {
        fun showProgress(show: Boolean)
        fun showErrorMessage(error: String)
        fun loadDataSuccess(list: List<Album>)
        fun loadDataAllSuccess(model: DetailsViewModel)
    }

    interface Presenter: BaseContract.Presenter<View> {
        fun loadData()
        fun deleteItem(item: AlbumsQueryResult)
    }
}