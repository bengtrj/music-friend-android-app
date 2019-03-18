package com.bengtrj.musicfriend.app

import android.app.Application
import android.content.res.Resources
import com.bengtrj.musicfriend.app.di.application.ApplicationComponent
import com.bengtrj.musicfriend.app.di.application.DaggerApplicationComponent

class BaseApp: Application() {

    lateinit var component: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        instance = this
        appResources = instance.getResources()
        setup()

        if (BuildConfig.DEBUG) {
            // Maybe TimberPlant etc.
        }
    }

    fun setup() {
        component = DaggerApplicationComponent.builder().build()
        component.inject(this)
    }

    companion object {
        lateinit var instance: BaseApp private set
        lateinit var appResources: Resources
    }
}