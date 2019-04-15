package com.winterbe.java8.samples.time;

import java.time.LocalDate;
import java.time.MonthDay;
import java.time.temporal.TemporalAdjusters;

import static java.lang.String.format;

/**
 * @author sd-wangtaicheng@sdcncsi.com.cn
 * @since 2019/1/22
 */
public class LocalDateMain {

    public static void main(String[] args) {
        //today
        LocalDate today = LocalDate.now();
        System.out.println(format("today is %s",today));
        //本月第一天
        LocalDate firstDay = today.with(TemporalAdjusters.firstDayOfMonth());
        System.out.println(firstDay);
        LocalDate firstDay2 = today.withDayOfMonth(1);
        System.out.println(firstDay2);
        //本月最后一天
        LocalDate lastDay = today.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(lastDay);
        //当前日期＋1天
        LocalDate tomorrow = today.plusDays(1);
        System.out.println(tomorrow);
        //判断是否为闰年
        boolean isLeapYear = tomorrow.isLeapYear();
        System.out.println(format("闰年: %s",isLeapYear));

        LocalDate birthday = LocalDate.of(1990, 10, 12);
        MonthDay birthdayMd = MonthDay.of(birthday.getMonth(), birthday.getDayOfMonth());
        MonthDay today1 = MonthDay.from(LocalDate.of(2016, 10, 12));
        System.out.println(today1.equals(birthdayMd));

        //日期比较
        LocalDate specifyDate = LocalDate.of(2015, 10, 20);
        System.out.println(today.isAfter(specifyDate));
    }

}
