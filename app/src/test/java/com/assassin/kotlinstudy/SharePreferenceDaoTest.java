package com.assassin.kotlinstudy;


import com.assassin.kotlinstudy.util.SharePreferenceDao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

/**
 * Author:      fangfang.fan
 * CreateDate:  2022/04/04 22:34
 * Description: 简述一下这个类要做的事情
 * Version:     1.0
 */
@RunWith(RobolectricTestRunner.class)
@Config(application = RoboApp.class)
public class SharePreferenceDaoTest {

   public static final String TEST_KEY = "instrumentedTest";
   public static final String TEST_STRING = "玉刚说";
   
   private SharePreferenceDao spDao;
   
   @Before
   public void setUp() {
      //这里的Context采用RuntimeEnvironment.application来替代应用的Context
      spDao = new SharePreferenceDao(RuntimeEnvironment.application);
   }
   
   @Test
   public void sharedPreferenceDaoWriteRead(){
      spDao.put(TEST_KEY, TEST_STRING);
      Assert.assertEquals(TEST_STRING, spDao.get(TEST_KEY));
   }
}
