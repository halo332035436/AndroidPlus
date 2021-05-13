package com.halo332035436.jetpack

import android.app.Application
import androidx.lifecycle.ProcessLifecycleOwner
import com.halo332035436.jetpack.observer.ApplicationLifecycleObserver

class APP : Application() {

    override fun onCreate() {
        super.onCreate()
        ProcessLifecycleOwner.get().lifecycle.addObserver(ApplicationLifecycleObserver())
    }

}