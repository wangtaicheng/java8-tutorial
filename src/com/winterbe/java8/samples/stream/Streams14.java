package com.winterbe.java8.samples.stream;

import java.util.stream.IntStream;

/**
 * 描述
 *
 * @author 王太成
 * @version 1.0.1
 * @since 2015/11/23
 */
public class Streams14 {
    public static void main(String[] args) {
        IntStream.range(1,10).forEach(i->System.out.println(i));
    }
}
