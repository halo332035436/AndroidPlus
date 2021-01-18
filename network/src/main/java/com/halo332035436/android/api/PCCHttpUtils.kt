package com.halo332035436.android.api

import com.halo332035436.android.Constants
import com.halo332035436.android.bean.request.APIRequest
import com.halo332035436.android.bean.response.APIResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PCCHttpUtils() {

    companion object {
        fun <K> post( call: Call<APIResponse<K>>, callback: APICallback<K>) {
            call.enqueue(object : Callback<APIResponse<K>> {
                override fun onFailure(call: Call<APIResponse<K>>, t: Throwable) {
                    callback.onFailure(call, t)
                }

                override fun onResponse(
                    call: Call<APIResponse<K>>,
                    response: Response<APIResponse<K>>
                ) {
                    val body = response.body()?.RESPONSE
                    if (body?.RETURN_CODE.equals("S0A00000")) {
                        body?.RETURN_DATA?.let { callback.onSuccess(it) }
                    } else {
                        body?.let { callback.onError(it) }
                    }
                }
            })
        }
    }
}

