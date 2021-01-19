package com.halo332035436.android.api

import com.halo332035436.android.Constants
import com.halo332035436.android.converter.PCCConverterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHolder {

    val retrofit = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(PCCConverterFactory.create())
        .build()

    fun <T> getService(clazz: Class<T>): T {
        return retrofit.create(clazz)
    }

}