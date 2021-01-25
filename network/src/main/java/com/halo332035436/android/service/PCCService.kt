package com.halo332035436.android.service

import com.halo332035436.android.bean.*
import com.halo332035436.android.bean.request.APIRequest
import com.halo332035436.android.bean.response.APIResponse
import com.halo332035436.android.bean.response.BaseResponse
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

    @POST(".")
    fun login(
        @Query("model") model: String,
        @Body request: APIRequest<RequestLogin>
    ): Call<APIResponse<BaseResponse<ResponseLogin>>>

    @POST(".")
    fun homeList(
        @Query("model") model: String,
        @Body request: APIRequest<RequestHomeList>
    ): Call<APIResponse<BaseResponse<String>>>

}