package com.halo332035436.android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.blankj.utilcode.util.SPUtils
import com.halo332035436.android.api.APICallback
import com.halo332035436.android.api.PCCHttpUtils
import com.halo332035436.android.api.PCCService
import com.halo332035436.android.api.RetrofitHolder
import com.halo332035436.android.bean.RequestToken
import com.halo332035436.android.bean.ResponseToken
import com.halo332035436.android.bean.request.APIRequest
import com.halo332035436.android.bean.response.APIResponse
import com.halo332035436.android.bean.response.APIResponseObj
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val data = RequestToken(Constants.APP_SECRET)
        btn_get_token.setOnClickListener {
            val request = APIRequest(data, Constants.API_ID_FOR_TOKEN)
            val call = RetrofitHolder.getService(PCCService::class.java)
                .getToken("app", request)
            PCCHttpUtils.post(call, object : APICallback<ResponseToken> {
                override fun onSuccess(data: ResponseToken) {
                    SPUtils.getInstance().put("USER_TOKEN",data.User_Access_Token)
                }

                override fun onError(response: APIResponseObj<ResponseToken>) {
                    println(response.RETURN_DESC)
                }

                override fun onFailure(call: Call<APIResponse<ResponseToken>>, t: Throwable) {
                    println(t)
                }
            })
        }
    }

}