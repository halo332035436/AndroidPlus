package com.halo332035436.android.bean.request

import com.blankj.utilcode.util.SPUtils

open class BaseRequest {

    var accessToken: String
    var buUserNo: String
    var channelId: String

    init {
        accessToken = SPUtils.getInstance().getString("ACCESS_TOKEN")
        buUserNo = SPUtils.getInstance().getString("BU_USER_NO")
        channelId = "APP"
    }
}