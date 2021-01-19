package com.halo332035436.android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.blankj.utilcode.util.DeviceUtils
import com.blankj.utilcode.util.SPUtils
import com.halo332035436.android.api.APICallback
import com.halo332035436.android.api.PCCHttpUtils
import com.halo332035436.android.api.RetrofitHolder
import com.halo332035436.android.bean.*
import com.halo332035436.android.bean.request.APIRequest
import com.halo332035436.android.bean.response.APIResponse
import com.halo332035436.android.bean.response.APIResponseObj
import com.halo332035436.android.bean.response.BaseResponse
import com.halo332035436.android.service.PCCService
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val data = RequestToken(Constants.APP_SECRET)
        btn_get_token.setOnClickListener {
            val request = APIRequest(data, Constants.API_ID_FOR_TOKEN, "1.0")
            val call = RetrofitHolder.getService(PCCService::class.java)
                .getToken("app", request)
            PCCHttpUtils.post(call, object : APICallback<ResponseToken> {
                override fun onSuccess(data: ResponseToken) {
                    tv_content.text = "get token success"
                    SPUtils.getInstance().put("APP_TOKEN", data.User_Access_Token)
                }

                override fun onError(response: APIResponseObj<ResponseToken>) {
                    tv_content.text = response.RETURN_DESC
                }

                override fun onFailure(call: Call<APIResponse<ResponseToken>>, t: Throwable) {
                    tv_content.text = t.localizedMessage
                }
            })
        }

        btn_login.setOnClickListener {
            val data = RequestLogin(
                "a135dcfdae7166b630fb3e4c3bf9faee",
                DeviceUtils.getAndroidID(),
                "18600026653",
                "Y1YsmCb+BrY="
            )
            val request = APIRequest(data, Constants.API_USER_LOGIN)
            val call = RetrofitHolder.getService(PCCService::class.java)
                .login("app", request)
            PCCHttpUtils.post(call, object : APICallback<BaseResponse<ResponseLogin>> {
                override fun onSuccess(data: BaseResponse<ResponseLogin>) {
                    tv_content.text = "login success"
                    SPUtils.getInstance().put("USER_TOKEN", data.obj.accessToken)
                    SPUtils.getInstance().put("BU_USER_NO", data.obj.buUserNo)
                }

                override fun onError(response: APIResponseObj<BaseResponse<ResponseLogin>>) {
                    tv_content.text = response.RETURN_DESC
                }

                override fun onFailure(
                    call: Call<APIResponse<BaseResponse<ResponseLogin>>>,
                    t: Throwable
                ) {
                    tv_content.text = t.localizedMessage
                }

            })
        }

        btn_request_home.setOnClickListener {
            val data = RequestHomeList(
                "440303",
                "深圳市",
                "22.543039",
                "114.110652"
            )
            val request = APIRequest(data, Constants.API_HOME_LIST)
            val call = RetrofitHolder.getService(PCCService::class.java)
                .homeList("app", request)
            PCCHttpUtils.post(call, object : APICallback<BaseResponse<String>> {
                override fun onSuccess(data: BaseResponse<String>) {
                    tv_content.text = data.obj
                }

                override fun onError(response: APIResponseObj<BaseResponse<String>>) {
                    tv_content.text = response.RETURN_DESC
                }

                override fun onFailure(
                    call: Call<APIResponse<BaseResponse<String>>>,
                    t: Throwable
                ) {
                    tv_content.text = t.localizedMessage
                }

            })
        }
    }

}