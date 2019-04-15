package com.winterbe.java8.samples.time;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/**
 * @author sd-wangtaicheng@sdcncsi.com.cn
 * @since 2019/1/22
 */
public class LocalTimeMain {
    public static void main(String[] args) {
        //获取当前的时间
        LocalTime nowTime = LocalTime.now();
        System.out.println(nowTime);
        //如果不想显示毫秒
        LocalTime nowTime2 = LocalTime.now().withNano(0);
        System.out.println(nowTime2);
        //指定时间
        LocalTime time = LocalTime.of(14, 10, 21);
        LocalTime time2 = LocalTime.parse("12:00:01");
        System.out.println(time);
        System.out.println(time2);
        //当前时间增加2小时
        LocalTime nowTimePlus2Hour = nowTime.plusHours(2);
        System.out.println(nowTimePlus2Hour);
        //或者
        LocalTime nowTimePlus2Hour2 = nowTime.plus(2, ChronoUnit.HOURS);
        System.out.println(nowTimePlus2Hour2);
    }
}
