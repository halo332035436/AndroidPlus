package com.halo332035436.android.bean

data class CREHttp(
    val isDes: Boolean,
    val isZip: Boolean,
    val APP_SUB_ID: String,
    val PARTNER_ID: String,
    val APP_KEY: String,
    val DES_KEY: String
) {
    constructor(
        APP_KEY: String, APP_SUB_ID: String, PARTNER_ID: String
    ) : this(false, false, APP_SUB_ID, PARTNER_ID, APP_KEY, "")
}