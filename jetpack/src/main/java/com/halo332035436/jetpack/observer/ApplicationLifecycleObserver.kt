package com.halo332035436.jetpack.observer

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class ApplicationLifecycleObserver :LifecycleObserver {

    val TAG = "Application_Lifecycle";

    @OnLifecycleEvent(value = Lifecycle.Event.ON_START)
    fun start() {
        Log.i(TAG, "start: ")
    }

    @OnLifecycleEvent(value = Lifecycle.Event.ON_STOP)
    fun stop() {
        Log.i(TAG, "stop: ")
    }

}