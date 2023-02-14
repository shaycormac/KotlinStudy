package com.assassin.kotlinstudy.util;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Author:      fangfang.fan
 * CreateDate:  2022/04/04 21:02
 * Description: 简述一下这个类要做的事情
 * Version:     1.0
 */
public class ExitCountDownTimeHelperTest {
    
    private ExitCountDownTimeHelper helper;
    
    private ExitCountDownTimeHelper.OnCountDownListener listener;

    @Before
    public void setUp() throws Exception {
        helper =ExitCountDownTimeHelper.get();
        helper.init(listener);
        
    }

    @After
    public void tearDown() throws Exception {
        helper= null;
        listener=null;
    }

    @Test
    public void start() {
        helper.start(ExitCountDownTimeHelper.STATE_SECOND_TWELVE);
        //assert
        
    }
}