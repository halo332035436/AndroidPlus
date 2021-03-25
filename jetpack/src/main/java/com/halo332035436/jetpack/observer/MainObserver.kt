package com.halo332035436.jetpack.observer

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

open class MainObserver : LifecycleObserver {

    val TAG = "Lifecycle_Test";

    @OnLifecycleEvent(value = Lifecycle.Event.ON_RESUME)
    fun connect() {
        Log.i(TAG, "connect: ")
    }

    @OnLifecycleEvent(value = Lifecycle.Event.ON_PAUSE)
    fun disConnect() {
        Log.i(TAG, "disConnect: ")
    }
}