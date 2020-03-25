package com.yh.learn;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test3 {
    public static void main(String[] args) {
        String str = Stream.of("1", "2", "3", "4").collect(Collectors.joining(","));
        System.out.println(str);
    }
}
