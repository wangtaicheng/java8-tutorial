/*
 * Copyright (c) 2019, SDCNCSI. All rights reserved.
 */

package com.winterbe.java8.samples.concurrent;

import java.util.concurrent.Semaphore;

/**
 * @author sd-wangtaicheng@sdcncsi.com.cn
 */
public class SemaphoreThreadDemo {
    public static Semaphore semaphore = new Semaphore(5);

    static class ThreadDemo extends Thread {
        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println(Thread.currentThread().getId() + "号线程在"+System.currentTimeMillis()+"获取资源");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                semaphore.release();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 30; i++) {
            new ThreadDemo().start();
        }
    }

}
