package com.bengtrj.android.musicfriend.app.ui.list

import com.bengtrj.android.musicfriend.app.models.Album
import com.bengtrj.android.musicfriend.app.ui.base.BaseContract
import com.bengtrj.android.musicfriend.app.models.DetailsViewModel
import com.bengtrj.android.musicfriend.app.models.AlbumsQueryResult

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