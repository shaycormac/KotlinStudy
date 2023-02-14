package com.assassin.kotlinstudy.util;

import com.assassin.kotlinstudy.app.KotlinApp;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Author:      fangfang.fan
 * CreateDate:  2022/04/04 21:46
 * Description: 测试SharePer
 * Version:     1.0
 */
public class SharePreferenceDaoTest {

    private SharePreferenceDao spDao;


    public static final String TEST_KEY = "instrumentedTest";
    public static final String TEST_STRING = "大花卉";

    @Before
    public void setUp() throws Exception {
        spDao = new SharePreferenceDao(KotlinApp.Companion.getApp());
    }

    @Test
    public void put() {

        spDao.put(TEST_KEY, TEST_STRING);
        //验证
        Assert.assertEquals(TEST_STRING, spDao.get(TEST_KEY));
    }
}