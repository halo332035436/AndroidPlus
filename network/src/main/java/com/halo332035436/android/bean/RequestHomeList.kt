package com.halo332035436.android.bean

import com.halo332035436.android.bean.request.BaseRequest

data class RequestHomeList(
    val cityCode: String,
    val cityName: String,
    val lat: String,
    val lng: String
) : BaseRequest()