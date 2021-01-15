package com.halo332035436.android.bean

data class ResponseToken(
    val Token_Type: String,
    val Token_Scope: String,
    val User_Refresh_key: String,
    val Token_Expires: String,
    val User_Access_Token: String
)