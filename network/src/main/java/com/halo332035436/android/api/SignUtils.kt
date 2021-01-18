package com.halo332035436.android.api

import com.blankj.utilcode.util.EncryptUtils
import com.halo332035436.android.bean.request.APIRequestAttrs

class SignUtils {

    companion object {
        fun sign(
            api_attrs: APIRequestAttrs,
            request_data: String,
            secretKey: String
        ): String {
            val signCode = "Api_ID" + "=" + api_attrs.Api_ID +
                    "&" +
                    "Api_Version" + "=" + api_attrs.Api_Version +
                    "&" +
                    "App_ID" + "=" + api_attrs.App_ID +
                    "&" +
                    "App_Sub_ID" + "=" + api_attrs.App_Sub_ID +
                    "&" +
                    "App_Token" + "=" + api_attrs.App_Token +
                    "&" +
                    "App_Version" + "=" + api_attrs.App_Version +
                    "&" +
                    "Divice_ID" + "=" + api_attrs.Divice_ID +
                    "&" +
                    "Divice_Version" + "=" + api_attrs.Divice_Version +
                    "&" +
                    "OS_Version" + "=" + api_attrs.OS_Version +
                    "&" +
                    "Partner_ID" + "=" + api_attrs.Partner_ID +
                    "&" +
                    "REQUEST_DATA" + "=" + request_data +
                    "&" +
                    "Time_Stamp" + "=" + api_attrs.Time_Stamp +
                    "&" +
                    "User_Token" + "=" + api_attrs.User_Token
            val data = "$signCode&$secretKey"
            val result = EncryptUtils.encryptMD5ToString(data)
            return result.toUpperCase()
        }
    }

}