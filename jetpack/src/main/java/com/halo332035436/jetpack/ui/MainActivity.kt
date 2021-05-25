package com.halo332035436.jetpack.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.halo332035436.jetpack.R
import com.halo332035436.jetpack.model.NameViewModel
import com.halo332035436.jetpack.observer.MainObserver
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity";
    private val observer = MainObserver()
    private val liveData = MutableLiveData<String>()
    private val model : NameViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lifecycle.addObserver(observer)

        liveData.observe(this,
            Observer<String> {
                Log.i("liveData.observe", "onChanged: $it");
            })
        Log.i(TAG, "onCreate: ")
        liveData.value = "onCreate"

        // Other code to setup the activity...

        // Create the observer which updates the UI.
        val nameObserver = Observer<String> { newName ->
            // Update the UI, in this case, a TextView.
            nameTextView.text = newName
        }

        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        model.currentName.observe(this, nameObserver)

        button.setOnClickListener {
            val anotherName = "John Doe"
            model.currentName.setValue(anotherName)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "onStart: ")
        liveData.value = "onStart"
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "onResume: ")
        liveData.value = "onResume"
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "onPause: ")
        liveData.value = "onPause"
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, "onStop: ")
        liveData.value = "onStop"
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "onDestroy: ")
        liveData.value = "onDestroy"
    }
}
