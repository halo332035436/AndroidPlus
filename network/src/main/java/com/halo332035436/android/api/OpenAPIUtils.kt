package com.halo332035436.android.api

import com.blankj.utilcode.util.AppUtils
import com.blankj.utilcode.util.DeviceUtils
import com.blankj.utilcode.util.TimeUtils
import com.google.gson.GsonBuilder
import com.halo332035436.android.Constants
import com.halo332035436.android.bean.*
import java.text.SimpleDateFormat

class OpenAPIUtils {

    companion object{
        /**
         * 获取请求参数
         *
         * @param attrsBean 公共请求参数
         * @param data      业务请求参数
         * @param bean      请求配置参数
         * @return json格式的请求数据
         */
        fun getRequestContent(
            attrsBean: CREAttrs,
            data: OpenAPIRequest,
            bean: CREHttp
        ): String {
            val attrs = OpenAPIAttrs(
                attrsBean.user_Token,
                attrsBean.api_ID,
                attrsBean.api_Version,
                bean.APP_SUB_ID,
                attrsBean.app_Token,
                bean.PARTNER_ID,
                "",
                TimeUtils.millis2String(
                    System.currentTimeMillis(),
                    SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS")
                ),
                Constants.APP_ID,
                AppUtils.getAppVersionName(),
                DeviceUtils.getAndroidID(),
                DeviceUtils.getManufacturer().toString() + " " + DeviceUtils.getModel(),
                "Android " + DeviceUtils.getSDKVersionCode()
            )
            return getRequestContent(attrs, data, bean)
        }

        /**
         * 获取请求参数
         *
         * @param attrs 公共请求参数
         * @param data  业务请求参数
         * @param bean  请求配置参数
         * @return json格式的请求数据
         */
        private fun getRequestContent(
            attrs: OpenAPIAttrs,
            data: OpenAPIRequest,
            bean: CREHttp
        ): String {
            return if (bean.isDes) {
                //业务报文加密
                //业务报文加密处理
                val dataString = DesUtils.DESEncode(
                    GsonBuilder().disableHtmlEscaping().create().toJson(data),
                    bean.DES_KEY
                )
                //进行签名处理
                attrs.Sign=SignUtils.sign(attrs, dataString, bean.APP_KEY)
                getRequestContent(OpenAPIRequestDes(attrs,dataString))
            } else {
                //业务报文不加密
                //进行签名处理
                attrs.Sign=
                    SignUtils.sign(
                        attrs,
                        GsonBuilder().disableHtmlEscaping().create().toJson(data),
                        bean.APP_KEY
                    )
                getRequestContent(OpenApiRequestDefault(attrs,data))
            }
        }


        /**
         * 获取请求参数
         *
         * @param apirequest 请求参数的bean
         * @return json格式的请求数据
         */
        private fun getRequestContent(apiRequest: Any): String {
            return GsonBuilder().disableHtmlEscaping().create().toJson(OpenAPIRequestBean(apiRequest))
        }


    }

}