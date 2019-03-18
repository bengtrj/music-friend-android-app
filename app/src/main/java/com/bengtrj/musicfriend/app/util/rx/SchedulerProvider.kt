package com.bengtrj.musicfriend.app.util.rx

import io.reactivex.Scheduler

interface SchedulerProvider {

    fun ui(): Scheduler
    fun io(): Scheduler

}