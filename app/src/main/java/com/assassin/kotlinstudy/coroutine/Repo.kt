package com.assassin.kotlinstudy.coroutine

/**
 * Author: Shay-Patrick-Cormac
 * Email: fang47881@126.com
 * Ltd: 金螳螂企业（集团）有限公司
 * Date: 2019/5/27 0027 09:38
 * Version: 1.0
 * Description: 类说明
 */
import com.google.gson.annotations.SerializedName
data class Repo(
        val id: Int,
        @SerializedName("name")
        val name: String,
        @SerializedName("full_name")
        val fullName: String,
        @SerializedName("description")
        val description: String?
)
