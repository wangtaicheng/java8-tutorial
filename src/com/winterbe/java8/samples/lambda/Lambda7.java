package com.winterbe.java8.samples.lambda;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.Predicate;

/**
 * 类名     :Lambda7
 * 项目名称 :java8-tutorial
 * 创建时间 :2016/12/30
 * 作     者:sd-wangtaicheng@sdcncsi.com.cn
 * 版     本:v1
 */
public class Lambda7 {

    public static void main(String[] args) {
        threadTest();
        listTest();
    }

    private static void threadTest() {
        //Before Java 8:
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Before Java8 ");
            }
        }).start();
        //Java 8 way:
        new Thread(() -> System.out.println("In Java8!")).start();
    }

    private static void listTest() {
        List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");

        System.out.println("Languages which starts with J :");
        filter(languages, (str) -> str.startsWith("J"));

        System.out.println("Languages which ends with a ");
        filter(languages, (str) -> str.endsWith("a"));

        System.out.println("Print all languages :");
        filter(languages, (str) -> true);

        System.out.println("Print no language : ");
        filter(languages, (str) -> false);

        System.out.println("Print language whose length greater than 4:");
        filter(languages, (str) -> str.length() > 4);

        Predicate<String> startsWithJ = (n) -> n.startsWith("J");
        Predicate<String> fourLetterLong = (n) -> n.length() == 4;

        languages.stream()
                .filter(startsWithJ.and(fourLetterLong))
                .forEach((n) -> System.out.println("\nName, which starts with  'J' and four letter long is : " + n));
        System.out.println();
        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
        costBeforeTax.stream().map((cost) -> cost + .12 * cost)
                .forEach(System.out::println);

        double total = 0;
        for (Integer cost : costBeforeTax) {
            double price = cost + .12 * cost;
            total = total + price;

        }
        System.out.println("Total : " + total);

        double bill = costBeforeTax.stream().map((cost) -> cost + .12 * cost)
                .reduce((sum, cost) -> sum + cost)
                .get();
        System.out.println("Total : " + bill);
        //Get count, min, max, sum, and average for numbers
        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
        IntSummaryStatistics stats = primes.stream().mapToInt((x) -> x)
                .summaryStatistics();
        System.out.println("Highest prime number in List : " + stats.getMax());
        System.out.println("Lowest prime number in List : " + stats.getMin());
        System.out.println("Sum of all prime numbers : " + stats.getSum());
        System.out.println("Average of all prime numbers : " + stats.getAverage());


    }

    //Even better
    public static void filter(List<String> names, Predicate<String> condition) {
        names.stream().filter((name) -> (condition.test(name)))
                .forEach((name) -> {
                    System.out.println(name + " ");
                });
    }
}
