package com.halo332035436.android.bean.response

data class APIResponseObj<T>(
    val RETURN_DATA: T,
    val RETURN_CODE: String,
    val RETURN_DESC: String,
    val RETURN_STAMP: String
)