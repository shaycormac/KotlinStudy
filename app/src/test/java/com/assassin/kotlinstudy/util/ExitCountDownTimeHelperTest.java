package com.assassin.kotlinstudy.util;

import android.os.Handler;
import android.os.Looper;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.when;

/**
 * Author:      fangfang.fan
 * CreateDate:  2022/04/04 21:02
 * Description: 简述一下这个类要做的事情
 * Version:     1.0
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({ExitCountDownTimeHelper.OnCountDownListener.class})
public class ExitCountDownTimeHelperTest {
    
    private ExitCountDownTimeHelper helper;
    
    private ExitCountDownTimeHelper.OnCountDownListener listener;
    
    private Handler mHandler;

    @Before
    public void setUp() throws Exception {
        // 解决了 looper的getMainLooper被调用
        PowerMockito.mockStatic(Looper.class);
        Looper mockMainThreadLooper = mock(Looper.class);
        when(Looper.getMainLooper()).thenReturn(mockMainThreadLooper);
        // 再解决handler被构造
        mHandler = mock(Handler.class);
      //  when(mHandler.sendMessage());
        
        
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