package com.assassin.kotlinstudy;

import android.widget.Button;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

/**
 * Author:      fangfang.fan
 * CreateDate:  2022/04/04 22:17
 * Description: 简述一下这个类要做的事情
 * Version:     1.0
 */
@RunWith(RobolectricTestRunner.class)

public class MainActivityTest {

    @Test
    public void click_Button_shouldChangeText() {
        MainActivity mainActivity = Robolectric.setupActivity(MainActivity.class);
        Button button = mainActivity.findViewById(R.id.tv_tips);
        // 模拟点击！！
        button.performClick();
        Assert.assertEquals("我被改变了！！", button.getText().toString());
    }
}
