package com.assassin.kotlinstudy.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Author:      Shay-Patrick-Cormac
 * Email:       android_shay@outlook.com
 * CreateDate:  2020/12/31 10:17
 * Version:     1.0
 * Description: 测试1。4。21版本的parcel plugin
 */
@Parcelize
data class TestParcelPlugin(val name:String):Parcelable
