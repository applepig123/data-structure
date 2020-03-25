package com.yh.learn.algorithms.dynamicprogram;

import java.util.Arrays;

/**
 * 寻找一个整型序列的最长上升子序列
 * 动态规划思想：
 * 计算以第i位置的数为结尾的最长上升子序列，当计算所有位置后，取其中最大的就是最长上升子序列
 */
public class LongestIncreaseSubSeq {
    private int[] srcList;

    private int[] maxLenList; // 记录以第i位置数结尾的最长上升子序列长度

    public LongestIncreaseSubSeq(int[] srcList) {
        this.srcList = srcList;
    }

    public int getLongestCount() {
        return searchLongestIncreaseSubSeq();
    }

    private int searchLongestIncreaseSubSeq() {
        // 传入的数组为空或null，则返回0
        if(srcList == null || srcList.length == 0) {
            return 0;
        }
        // 传入的数组长度为1，则返回1,
        if(srcList.length == 1) {
            return 1;
        }

        //初始化，每个位置初始化长度都为1
        this.maxLenList = new int[srcList.length];
        for(int i=0;i<maxLenList.length;i++) {
            maxLenList[i] = 1;
        }

        // 递归式：maxLen(i) = Max(maxLen(i), maxLen(j)) + 1
        // 第i位置数结尾的最长上升子序列长度，假如 a[i] > a[j]，则可以由a[j]推到出 a[i] = a[j] + 1，因为a[i]左边任何“终点”
        // 小于a[i]的子序列，加上a[i]后就能形成一个更长大的上升子序列

        // 因为i=0前面没有子序列，所以从index 1 开始
        for(int i=1;i<maxLenList.length;i++) {
            //遍历 i 前面数的最长上升子序列长度
            for(int j=0;j<i;j++) {
                if(srcList[i] > srcList[j]) {
                    // 只有当第j个数的最长上升子序列长度大于i本身，更新i
                    if(maxLenList[i] <= maxLenList[j]) {
                        maxLenList[i] = maxLenList[j] + 1;
                    }
                }
            }
        }
        return Arrays.stream(maxLenList).max().getAsInt();
    }
}
