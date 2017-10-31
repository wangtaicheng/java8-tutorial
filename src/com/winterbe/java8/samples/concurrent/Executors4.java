package com.winterbe.java8.samples.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 类名     :Executors4
 * 项目名称 :java8-tutorial
 * 创建时间 :2017/5/2
 * 作     者:sd-wangtaicheng@sdcncsi.com.cn
 * 版     本:v1
 */
public class Executors4 {

    public static void main(String[] args) {
//        Executors4.newCachedThreadPoolCase();
        Executors4.newFixedThreadPoolCase();
    }

    public static void newCachedThreadPoolCase() {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            try {
                Thread.sleep(index * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            cachedThreadPool.execute(() -> System.out.println(index));
        }
    }

    public static void newFixedThreadPoolCase() {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        final AtomicInteger thread = new AtomicInteger();
        for (int i = 0; i < 10; i++) {
            final int index = i;

            fixedThreadPool.execute(() -> {
                        try {
                            thread.incrementAndGet();
                            System.out.println(thread.get());
                            Thread.sleep(5);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
            );
        }
        while (thread.get() <10) {
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void newScheduledThreadPoolCase() {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        scheduledThreadPool.schedule(() ->
                        System.out.println("delay 3 seconds")
                , 3, TimeUnit.SECONDS);
        scheduledThreadPool.scheduleAtFixedRate(() ->
                        System.out.println("delay 3 seconds")
                , 1, 3, TimeUnit.SECONDS);
    }

    public static void newSingleThreadExecutorCase() {
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            singleThreadExecutor.execute(() -> {
                        try {
                            System.out.println(index);
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
            );
        }
    }
}
