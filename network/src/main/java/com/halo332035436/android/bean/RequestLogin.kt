package com.halo332035436.android.bean

import com.halo332035436.android.bean.request.BaseRequest

data class RequestLogin(
    val clientId: String,
    val deviceId: String,
    val mobile: String,
    val password: String
) : BaseRequest()