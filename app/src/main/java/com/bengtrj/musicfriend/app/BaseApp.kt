package com.bengtrj.musicfriend.app

import android.app.Application
import com.bengtrj.musicfriend.app.di.component.ApplicationComponent
import com.bengtrj.musicfriend.app.di.component.DaggerApplicationComponent

class BaseApp: Application() {

    lateinit var component: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        instance = this
        setup()

        if (BuildConfig.DEBUG) {
            // Maybe TimberPlant etc.
        }
    }

    fun setup() {
        component = DaggerApplicationComponent.builder().build()
        component.inject(this)
    }

    fun getApplicationComponent(): ApplicationComponent {
        return component
    }

    companion object {
        lateinit var instance: BaseApp private set
    }
}