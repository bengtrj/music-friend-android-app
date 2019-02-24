package com.bengtrj.android.musicfriend.app.ui.appinfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bengtrj.android.musicfriend.app.R

class AppInfoFragment: androidx.fragment.app.Fragment() {

    fun newInstance(): AppInfoFragment {
        return AppInfoFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_app_info, container, false)
    }

    companion object {
        const val TAG: String = "AppInfoFragment"
    }
}