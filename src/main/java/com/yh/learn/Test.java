package com.yh.learn;

import com.yh.learn.algorithms.sort.QuickSort;
import com.yh.learn.algorithms.sort.Sort;

import java.util.Random;

/**
 * Created by yanghua on 2019/4/6.
 */
public class Test {
    public static void main(String[] args) {
        int[] arr = randomArray(0, 100, 10);
        printList(arr);

        Sort sort = new QuickSort(arr);
        printList(sort.sort());
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
