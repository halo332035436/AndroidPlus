package com.halo332035436.android.bean.request

import com.blankj.utilcode.util.AppUtils
import com.blankj.utilcode.util.DeviceUtils
import com.blankj.utilcode.util.SPUtils
import com.blankj.utilcode.util.TimeUtils
import com.google.gson.GsonBuilder
import com.halo332035436.android.Constants
import com.halo332035436.android.api.SignUtils
import java.text.SimpleDateFormat

class APIRequest<T>(obj: T, apiID: String, vararg apiVersion: String = arrayOf("1.0.0")) {
    var REQUEST: APIRequestObj<T>

    init {
        var attrs = APIRequestAttrs(
            apiID,
            apiVersion[0],
            Constants.APP_ID,
            Constants.APP_SUB_ID,
            SPUtils.getInstance().getString("APP_TOKEN"),
            AppUtils.getAppVersionName(),
            DeviceUtils.getAndroidID(),
            DeviceUtils.getManufacturer().toString() + " " + DeviceUtils.getModel(),
            "Android " + DeviceUtils.getSDKVersionCode(),
            Constants.PARTNER_ID,
            "",
            TimeUtils.millis2String(
                System.currentTimeMillis(),
                SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS")
            ),
            Constants.USER_TOKEN
        )
        //进行签名处理
        attrs.Sign = SignUtils.sign(
            attrs,
            GsonBuilder().disableHtmlEscaping().create().toJson(obj),
            Constants.APP_SECRET
        )
        REQUEST = APIRequestObj(attrs, obj)
    }
}