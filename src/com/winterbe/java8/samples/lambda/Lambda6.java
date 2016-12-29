package com.winterbe.java8.samples.lambda;

import java.util.stream.Stream;

/**
 * Created by 王太成 on 2016/9/22.
 */
public class Lambda6 {
    public static void main(String[] args) {
        Stream.iterate(1, item -> item + 1).limit(10).forEach(System.out::println);
    }
}
