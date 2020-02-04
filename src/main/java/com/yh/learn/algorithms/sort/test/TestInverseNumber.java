package com.yh.learn.algorithms.sort.test;

import com.yh.learn.algorithms.sort.InverseNumber;

import java.util.Random;

public class TestInverseNumber {

    public static void main(String[] args) {
        int[] arr = randomArray(0, 10, 4);
//        int[] arr = {2,6,3,4,5,1};
        printList(arr);
        System.out.println("--------------------");
        InverseNumber inverseNumber = new InverseNumber(arr);
        System.out.println(inverseNumber.getInverseNumCount());
    }

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
