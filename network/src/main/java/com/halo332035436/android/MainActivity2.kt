package com.halo332035436.android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.blankj.utilcode.util.GsonUtils
import com.halo332035436.android.bean.RequestToken
import com.halo332035436.android.bean.request.APIRequest
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import okhttp3.RequestBody.Companion.toRequestBody
import okio.IOException

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val client = OkHttpClient.Builder()
            .build()

        btn_get_token.setOnClickListener {
            val data = RequestToken(Constants.APP_SECRET)
            val request = APIRequest(data, Constants.API_ID_FOR_TOKEN, "1.0")
            val body = GsonUtils.toJson(request).toRequestBody()

            val okHttpRequest: Request = Request.Builder()
                .url(Constants.BASE_URL + "?model=app")
                .header("Content-Type", "application/json")
                .post(body)
                .build()

            client.newCall(okHttpRequest)
                .enqueue(object : Callback {
                    override fun onFailure(call: Call, e: IOException) {
                        tv_content.text = e.localizedMessage
                    }

                    override fun onResponse(call: Call, response: Response) {
                        tv_content.text = response.body?.source()?.readUtf8()
                    }
                })
        }
    }
}