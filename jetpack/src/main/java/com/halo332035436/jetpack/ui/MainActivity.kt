package com.halo332035436.jetpack.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.halo332035436.jetpack.R
import com.halo332035436.jetpack.observer.MainObserver

class MainActivity : AppCompatActivity() {

    val TAG = "Lifecycle_Test";
    val observer = MainObserver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lifecycle.addObserver(observer)
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "onResume: ")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "onPause: ")
    }
}
