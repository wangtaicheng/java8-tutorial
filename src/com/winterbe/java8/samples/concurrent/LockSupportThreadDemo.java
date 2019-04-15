/*
 * Copyright (c) 2019, SDCNCSI. All rights reserved.
 */

package com.winterbe.java8.samples.concurrent;

import java.util.concurrent.locks.LockSupport;

public class LockSupportThreadDemo {
    public static Thread thread;
    static class WaitThreadDemo extends Thread {
        @Override
        public void run() {
            System.out.println("WaitThread wait,time=" + System.currentTimeMillis());
            thread = Thread.currentThread();
            LockSupport.park();
            System.out.println("WaitThread end,time=" + System.currentTimeMillis());
        }
    }
    static class NotifyThreadDemo extends Thread {
        @Override
        public void run() {
            System.out.println("NotifyThread notify,time=" + System.currentTimeMillis());
            LockSupport.unpark(thread);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("NotifyThread end,time=" + System.currentTimeMillis());
        }
    }
    public static void main(String[] args) {
        WaitThreadDemo waitThreadDemo = new WaitThreadDemo();
        NotifyThreadDemo notifyThreadDemo = new NotifyThreadDemo();
        waitThreadDemo.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        notifyThreadDemo.start();
    }
}
