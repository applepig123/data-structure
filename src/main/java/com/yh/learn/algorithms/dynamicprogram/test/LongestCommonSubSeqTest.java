package com.yh.learn.algorithms.dynamicprogram.test;

import com.yh.learn.algorithms.dynamicprogram.LongestCommonSubSeq;
import com.yh.learn.utils.NumberUtil;

public class LongestCommonSubSeqTest {

    public static void main(String[] args) {
        int[] arr1 = NumberUtil.randomArray(0, 10, 5);
        int[] arr2 = NumberUtil.randomArray(0, 10, 5);
        System.out.println("arr1: ");
        NumberUtil.printList(arr1);
        System.out.println("================");
        System.out.println("arr2: ");
        NumberUtil.printList(arr2);
        LongestCommonSubSeq longestCommonSubSeq = new LongestCommonSubSeq(arr1, arr2);
        int count = longestCommonSubSeq.getLongestCount();
        System.out.println("----------------");
        System.out.println(count);
    }
}
