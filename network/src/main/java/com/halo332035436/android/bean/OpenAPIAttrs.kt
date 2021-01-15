package com.halo332035436.android.bean

data class OpenAPIAttrs(

    /**
     * 调用方移动用户的身份令牌（API 开放平台提供）
     */
    val User_Token: String,

    /**
     * 被调用的 API 编码（API 开放平台提供）
     */
    val Api_ID: String,

    /**
     * 被调用的 API 版本号（API 开放平台提供）
     */
    val Api_Version: String,

    /**
     * 分配给调用方的移动应用编码（API 开放平台提供）
     */
    val App_Sub_ID: String,

    /**
     * 调用方移动应用授权令牌（API 开放平台提供）
     */
    val App_Token: String,

    /**
     * 分配给调用方的组织编码（API 开放平台提供）
     */
    val Partner_ID: String,

    /**
     * 请求报文的签名字符串
     */
    var Sign: String,

    /**
     * 调用方时间戳，格式为 yyyy-mm-dd HH:mm:ss:SSS，时区为 GMT+8
     */
    val Time_Stamp: String,

    /**
     * 调用方移动应用编码
     */
    val App_ID: String,

    /**
     * 调用方移动应用版本
     */
    val App_Version: String,

    /**
     * 调用方移动设备编号
     */
    val Divice_ID: String,

    /**
     * 调用方移动设备品牌与型号，示例：iPhone 7 Plus
     */
    val Divice_Version: String,

    /**
     * 调用方移动设备操作系统名称与版本，示例：IOS 10.3.2
     */
    val OS_Version: String
)

