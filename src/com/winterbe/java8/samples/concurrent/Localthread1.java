package com.winterbe.java8.samples.concurrent;

/**
 * Created by 王太成 on 2016/9/23.
 */
public class Localthread1 {
    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>() {
        protected Integer initialValue() {
            return 0;
        }
    };
    private static ThreadLocal<Integer> threadLocal1 =ThreadLocal.withInitial(()-> 0);
    public static void main(String[] args) {
        try {
            plus();
            plusWithLam();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void plus() throws Exception {
        for (int i = 0; i < 100; i++) {
            new Thread() {
                public void run() {
                    //1
                    int a = threadLocal.get();
                    a++;

                    //2
                    threadLocal.set(a);
                    System.out.println("plus:" + Thread.currentThread().getName() + ": " + threadLocal.get());
                }
            }.start();
        }
    }
    private static void plusWithLam() throws Exception {
        for (int i = 0; i < 100; i++) {
            new Thread( ()-> {
                    //1
                    int a = threadLocal1.get();
                    a++;

                    //2
                threadLocal1.set(a);
                    System.out.println("plus:" + Thread.currentThread().getName() + ": " + threadLocal1.get());
            }).start();
        }
    }
}
