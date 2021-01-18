package com.halo332035436.android.api

import com.halo332035436.android.bean.response.APIResponse
import com.halo332035436.android.bean.response.APIResponseObj
import retrofit2.Call

interface APICallback<T> {

    fun onSuccess(data: T);
    fun onError(response: APIResponseObj<T>);
    fun onFailure(call: Call<APIResponse<T>>, t: Throwable);

}