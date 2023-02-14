package com.assassin.kotlinstudy.util;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import androidx.annotation.NonNull;

/**
 * Author:      fangfang.fan
 * CreateDate:  2022/03/22 18:09
 * Version:     1.0
 * Description: 退出小憩模式的提醒倒计时，暂时设置从12秒开始倒计时
 */
public class ExitCountDownTimeHelper {
    private static final String TAG = ExitCountDownTimeHelper.class.getSimpleName();
    private static final int MESSAGE_COUNT_DOWN = 9999;
    //未计时
    public static final int STATE_IDLE = -1;
    //12秒
    public static final int STATE_SECOND_TWELVE = 0;

    private Handler mHandler;
    private long mCountDownTime = 0;
    private int mCurStatus = STATE_IDLE;
    private OnCountDownListener mOnEventListener;
    @SuppressLint("StaticFieldLeak")
    private static ExitCountDownTimeHelper mInstance;

    public long getTakeNapTime() {
        return mCountDownTime;
    }

    private ExitCountDownTimeHelper() {

    }

    public static ExitCountDownTimeHelper get() {
        if (mInstance == null) {
            synchronized (ExitCountDownTimeHelper.class) {
                if (mInstance == null) {
                    mInstance = new ExitCountDownTimeHelper();
                }
            }
        }
        return mInstance;
    }

    public void init(OnCountDownListener listener) {

        mOnEventListener = listener;
        initHandler();
       // updateClockDesc();
    }

    /**
     * 初始化handler
     */
    @SuppressLint("HandlerLeak")
    private void initHandler() {
        mHandler = new Handler(Looper.getMainLooper()) {
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                if (msg.what == MESSAGE_COUNT_DOWN) {
                    if (mCountDownTime > 0) {
                        updateClockDesc();
                        mCountDownTime -= 1000;
                        if (mHandler != null) {
                            mHandler.sendEmptyMessageDelayed(MESSAGE_COUNT_DOWN, 1000);
                        }
                    } else {
                        mCurStatus = STATE_IDLE;
                      //  updateClockDesc();
                        // 退出小憩模式
                        if (mOnEventListener != null) {
                            mOnEventListener.onClockEnd();
                        }
                    }
                }
            }
        };
    }

    /**
     * 开始倒计时
     */
    public void start(int status) {
        Log.i(TAG, "start - curState: " + status);
        stop();
        switch (status) {
            case STATE_IDLE:
                mCountDownTime = 0;
                mCurStatus = STATE_IDLE;
                break;
            case STATE_SECOND_TWELVE:
                mCountDownTime = 12 * 1000;
                mCurStatus = STATE_SECOND_TWELVE;
                break;
            default:
                break;
        }
        if (mCountDownTime > 0) {
            // 开始计时
            if (mHandler != null) {
                Message message = mHandler.obtainMessage(MESSAGE_COUNT_DOWN);
                mHandler.sendMessage(message);
            }
        } /*else {
            updateClockDesc();
        }*/
    }

    /**
     * 结束倒计时
     */
    private void stop() {
        Log.i(TAG, "stop - handle: " + mHandler);
        mCountDownTime = 0;
        if (mHandler != null) {
            mHandler.removeCallbacksAndMessages(null);
        }

/*
        if (mOnEventListener != null) {
            mOnEventListener.leftSecond("0");
        }*/
    }

    /**
     * 更新倒计时
     */
    private void updateClockDesc() {

        String leftSecond = String.valueOf(mCountDownTime /1000);
        if (mCurStatus == STATE_IDLE) {
            // 闹钟-未计时
            stop();

        }
        if (mOnEventListener != null) {
            mOnEventListener.leftSecond(leftSecond);
        }
    }

    /**
     * 释放重置
     */
    public void releaseCountDownTime() {
        Log.i(TAG, "unInit");
        stop();
        mOnEventListener = null;
        mCurStatus = STATE_IDLE;
    }

    public interface OnCountDownListener {
        void onClockEnd();

        void leftSecond(String leftSecond);
    }
}
