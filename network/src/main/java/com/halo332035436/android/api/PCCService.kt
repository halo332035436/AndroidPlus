package com.halo332035436.android.api

import com.halo332035436.android.bean.RequestToken
import com.halo332035436.android.bean.ResponseToken
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface PCCService {

    @POST("")
    fun getToken(@Body request: RequestToken): Call<ResponseToken>

}