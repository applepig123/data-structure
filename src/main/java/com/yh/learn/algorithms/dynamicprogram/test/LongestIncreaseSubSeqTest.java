package com.yh.learn.algorithms.dynamicprogram.test;

import com.yh.learn.algorithms.dynamicprogram.LongestIncreaseSubSeq2;
import com.yh.learn.utils.NumberUtil;

import java.util.List;

public class LongestIncreaseSubSeqTest {

    public static void main(String[] args) {
//        int[] array = NumberUtil.randomArray(0, 100, 50);
        int[] array = new int[] {1,2,3,4,5,6,1,2,3,4,5,6};
        NumberUtil.printList(array);
        System.out.println("---------------");
        LongestIncreaseSubSeq2 longestIncreaseSubSeq = new LongestIncreaseSubSeq2(array);
        int longestCount = longestIncreaseSubSeq.getLongestCount();
        System.out.println("count: " + longestCount);
        System.out.println("---------------");
        List<LongestIncreaseSubSeq2.SubSeqInfo> maxLenInfoList = longestIncreaseSubSeq.maxLenInfoList;
        List<Integer> maxId = longestIncreaseSubSeq.maxId;
        for(int id : maxId) {
            LongestIncreaseSubSeq2.SubSeqInfo subSeqInfo = maxLenInfoList.get(id);
            List<Integer[]> list = subSeqInfo.list;
            for(Integer[] ele : list) {
                for(int e : ele) {
                    System.out.println(e);
                }
                System.out.println("=======================");
            }
        }

    }
}
