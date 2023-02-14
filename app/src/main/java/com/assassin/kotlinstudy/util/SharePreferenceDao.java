package com.assassin.kotlinstudy.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Author:      fangfang.fan
 * CreateDate:  2022/04/04 21:32
 * Description: 用来Android测试
 * Version:     1.0
 */
public class SharePreferenceDao {

    private SharedPreferences sp;

    public SharePreferenceDao(SharedPreferences sp) {
        this.sp = sp;
    }

    public SharePreferenceDao(Context context) {
        this(context.getSharedPreferences("shay_test_unit", Context.MODE_PRIVATE));
    }


    public void put(String key, String value) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public String get(String key) {
        return sp.getString(key, "没有得到预期的值");
    }
}
