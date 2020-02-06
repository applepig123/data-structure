package com.yh.learn.utils;

import java.util.Random;

public class NumberUtil {
    public static int[] randomArray(int min, int max, int length) {
        int[] arr = new int[length];
        for(int i=0;i<length;i++) {
            arr[i] = new Random().nextInt(max) % (max - min + 1) + min;
        }
        return arr;
    }

    public static void printList(int[] arr) {
        for(int i : arr) {
            System.out.println(i);
        }
    }
}
