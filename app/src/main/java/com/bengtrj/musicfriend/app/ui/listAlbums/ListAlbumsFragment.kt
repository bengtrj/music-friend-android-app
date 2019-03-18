package com.bengtrj.musicfriend.app.ui.listAlbums

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bengtrj.musicfriend.app.R
import com.bengtrj.musicfriend.app.di.listAlbums.DaggerListAlbumsFragmentComponent
import com.bengtrj.musicfriend.app.di.listAlbums.ListAlbumsFragmentModule
import com.bengtrj.musicfriend.app.models.Album
import com.bengtrj.musicfriend.app.models.AlbumsQueryResult
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_list.*
import javax.inject.Inject

class ListAlbumsFragment: androidx.fragment.app.Fragment(), ListAlbumsContract.View, ListAlbumsAdapter.OnItemClickListener {

    @Inject lateinit var presenter: ListAlbumsContract.Presenter

    private lateinit var rootView: View

    fun newInstance(): ListAlbumsFragment {
        return ListAlbumsFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectDependency()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_list, container, false)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.attach(this)
        initView()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.detach()
    }

    override fun showProgress(show: Boolean) {
        if (show) {
            infoProgressBar.visibility = View.VISIBLE
        } else {
            infoProgressBar.visibility = View.GONE
        }
    }

    //TODO actually implement this!
    override fun showErrorMessage(error: String) {
        Log.e("Error", error)
    }

    override fun loadDataSuccess(list: List<Album>) {
        activity?.let {
            val adapter = ListAlbumsAdapter(it, list.toMutableList(), this)
            recyclerView!!.run {
                layoutManager = androidx.recyclerview.widget.LinearLayoutManager(it)
                setAdapter(adapter)
            }
        }
    }

    override fun itemRemoveClick(post: AlbumsQueryResult) {
        Snackbar.make(this.rootView, R.string.not_implemented, Snackbar.LENGTH_SHORT).show()
    }

    override fun itemDetail(postId: String) {
        Snackbar.make(this.rootView, R.string.not_implemented, Snackbar.LENGTH_SHORT).show()
    }

    private fun injectDependency() {
        val listComponent = DaggerListAlbumsFragmentComponent.builder()
                .listAlbumsFragmentModule(ListAlbumsFragmentModule())
                .build()

        listComponent.inject(this)
    }

    private fun initView() {
        presenter.loadData()
    }

    companion object {
        const val TAG: String = "ListAlbumsFragment"
    }
}