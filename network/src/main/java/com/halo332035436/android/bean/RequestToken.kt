package com.halo332035436.android.bean

class RequestToken(
    val App_key: String,
    accessToken: String,
    channelId: String,
    buUserNo: String
) : OpenAPIRequest(accessToken, channelId, buUserNo)