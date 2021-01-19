package com.halo332035436.android.bean.response


data class BaseResponse<T>(
    val msg: String,
    val obj: T,
    val resCode: String
)