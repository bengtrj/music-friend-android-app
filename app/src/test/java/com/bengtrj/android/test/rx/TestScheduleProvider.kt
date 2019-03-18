package com.bengtrj.android.test.rx

import com.bengtrj.musicfriend.app.util.rx.SchedulerProvider
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers

class TestSchedulerProvider(private val ui: Scheduler = Schedulers.trampoline(),
                            private val io: Scheduler = Schedulers.trampoline()) : SchedulerProvider {

    override fun ui(): Scheduler {
        return ui
    }

    override fun io(): Scheduler {
        return io
    }

}