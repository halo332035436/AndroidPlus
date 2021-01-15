package com.halo332035436.android.api

import com.halo332035436.android.bean.OpenAPIResponse
import com.halo332035436.android.bean.ResponseToken
import retrofit2.Call

interface APICallback<T> {

    fun onSuccess(data: T);
    fun onError(response: OpenAPIResponse);
    fun onFailure(call: Call<ResponseToken>, t: Throwable);

}