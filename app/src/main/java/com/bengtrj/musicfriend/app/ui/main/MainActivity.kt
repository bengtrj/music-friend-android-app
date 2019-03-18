package com.bengtrj.musicfriend.app.ui.main

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.bengtrj.musicfriend.app.R
import com.bengtrj.musicfriend.app.di.listAlbums.DaggerListAlbumsActivityComponent
import com.bengtrj.musicfriend.app.di.listAlbums.ListAlbumsActivityModule
import com.bengtrj.musicfriend.app.ui.appinfo.AppInfoFragment
import com.bengtrj.musicfriend.app.ui.listAlbums.ListAlbumsFragment
import javax.inject.Inject

class MainActivity: AppCompatActivity(), MainContract.View {

    @Inject lateinit var presenter: MainContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        injectDependency()

        presenter.attach(this)
    }

    override fun showAboutFragment() {
        if (supportFragmentManager.findFragmentByTag(AppInfoFragment.TAG) == null) {
            supportFragmentManager.beginTransaction()
                    .addToBackStack(null)
                    .replace(R.id.frame, AppInfoFragment().newInstance(), AppInfoFragment.TAG)
                    .commit()
        } else {
            //TODO handle this
        }
    }

    override fun showListFragment() {
        supportFragmentManager.beginTransaction()
                .disallowAddToBackStack()
                .replace(R.id.frame, ListAlbumsFragment().newInstance(), ListAlbumsFragment.TAG)
                .commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item!!.itemId) {
            R.id.nav_item_info -> {
                presenter.onDrawerOptionAboutClick()
                return true
            }
            else -> {

            }
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        val fragmentManager = supportFragmentManager
        val fragment = fragmentManager.findFragmentByTag(AppInfoFragment.TAG)

        if (fragment == null) {
            super.onBackPressed()
        } else {
            supportFragmentManager.popBackStack()
        }
    }

    private fun injectDependency() {
        val activityComponent = DaggerListAlbumsActivityComponent.builder()
                .listAlbumsActivityModule(ListAlbumsActivityModule())
                .build()

        activityComponent.inject(this)
    }

}