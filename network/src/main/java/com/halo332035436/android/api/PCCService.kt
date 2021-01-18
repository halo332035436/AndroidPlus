package com.halo332035436.android.api

import com.halo332035436.android.bean.RequestToken
import com.halo332035436.android.bean.ResponseToken
import com.halo332035436.android.bean.request.APIRequest
import com.halo332035436.android.bean.response.APIResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Query

interface PCCService {

    @POST(".")
    fun getToken(
        @Query("model") model: String,
        @Body request: APIRequest<RequestToken>
    ): Call<APIResponse<ResponseToken>>

}