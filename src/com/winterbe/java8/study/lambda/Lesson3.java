package com.winterbe.java8.study.lambda;

/**
 * 类名     :Lesson3
 * 项目名称 :java8-tutorial
 * 创建时间 :2017/6/16
 * 作     者:sd-wangtaicheng@sdcncsi.com.cn
 * 版     本:v1
 */
public class Lesson3 {

    public static void main(String[] args) {
        Runnable r1 = ()-> System.out.println("r1");
        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("r2");
            }
        };

        process(r1);
        process(r2);
        process(()-> System.out.println("r3"));

    }
    public static void process(Runnable r){
        r.run();
    }
}
