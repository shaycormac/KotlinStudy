package com.assassin.kotlinstudy.threadpool;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Author: Shay-Patrick-Cormac
 * Email: fang47881@126.com
 * Ltd: 金螳螂企业（集团）有限公司
 * Date: 2019-12-19 16:12
 * Version: 1.0
 * Description: 类说明
 */
public enum Locker {

    INSTANCE;

    private static final ReadWriteLock lock = new ReentrantReadWriteLock();

    public Lock writeLock() {
        return lock.writeLock();
    }

}

