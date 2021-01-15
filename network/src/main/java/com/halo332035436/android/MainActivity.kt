package com.halo332035436.android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.halo332035436.android.api.OpenAPIUtils
import com.halo332035436.android.api.PCCService
import com.halo332035436.android.api.converter.PCCConverterFactory
import com.halo332035436.android.bean.CREAttrs
import com.halo332035436.android.bean.CREHttp
import com.halo332035436.android.bean.RequestToken
import com.halo332035436.android.bean.ResponseToken
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val data = RequestToken(Constants.APP_SECRET)

        val attrsBean = CREAttrs(
            Constants.API_ID_FOR_TOKEN,
            "1.0",
            Constants.APP_TOKEN,
            ""
        )
        val httpBean = CREHttp(
            Constants.APP_SECRET,
            Constants.APP_SUB_ID,
            Constants.PARTNER_ID
        )
        val json: String = OpenAPIUtils.getRequestContent(attrsBean, data, httpBean)
//
//
//
//
//        CREHttpUtils.postJson(cacheKey, BuildConfig.BASE_URL, json, tag, callback)


        btn_get_token.setOnClickListener {
            val retrofit = Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(PCCConverterFactory.create())
                .build()

            val service = retrofit.create(PCCService::class.java)

            val call: Call<ResponseToken> = service.getToken(RequestToken(Constants.APP_SECRET))

            call.enqueue(object : Callback<ResponseToken>{

                override fun onFailure(call: Call<ResponseToken>, t: Throwable) {

                }

                override fun onResponse(
                    call: Call<ResponseToken>,
                    response: Response<ResponseToken>
                ) {
                    response.body()
                }

            })
        }
    }

}