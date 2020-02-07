package com.yh.learn.algorithms.dynamicprogram;

/**
 * 给出两个数组（字符串），求出最长公共子序列的长度
 * 动态规划思想：
 * 计算s1的左边i个字符形成的子串，与s2左边的j个字符形成的子串的最长公共子序列的长度，当遍历两个字符串后，即可以得到最长公共子序列的长度
 */
public class LongestCommonSubSeq {
    private int[] srcList1;

    private int[] srcList2;

    private int[][] maxLenList;

    public LongestCommonSubSeq(int[] srcList1, int[] srcList2) {
        this.srcList1 = srcList1;
        this.srcList2 = srcList2;
    }

    public int getLongestCount() {
        // 当一个数组长度是0，则直接返回0
        if(srcList1 == null || srcList2 == null || srcList1.length == 0 || srcList2.length == 0) {
            return 0;
        }
        // 此处的状态，是某个元素左边的元素，所以为了遍历整个数组，需要把遍历的终点设置成数组的 len + 1
        int len1 = srcList1.length + 1, len2 = srcList2.length + 1;
        maxLenList = new int[len1][len2];

        // 初始化边界条件，其中一个数组取0时，该最长公共子序列的长度为0
        for(int i=0;i<len1;i++) {
            maxLenList[i][0] = 0;
        }
        for(int i=0;i<len2;i++) {
            maxLenList[0][i] = 0;
        }

        // 递归式：
        // 当 s1[i - 1] =  s2[j - 1], maxLen(i, j) = maxLen(i - 1, j - 1) + 1
        // 当 s1[i - 1] != s2[j - 1], maxLen(i, j) = Max(maxLen(i, j - 1). maxLen(i - 1, j))
        for(int i=1;i<len1;i++) {
            for(int j=1;j<len2;j++) {
                if(srcList1[i - 1] == srcList2[j - 1]) {
                    maxLenList[i][j] = maxLenList[i - 1][j - 1] + 1;
                } else {
                    if(maxLenList[i][j - 1] < maxLenList[i - 1][j]) {
                        maxLenList[i][j] = maxLenList[i - 1][j];
                    } else {
                        maxLenList[i][j] = maxLenList[i][j - 1];
                    }
                }
            }
        }
        return maxLenList[len1 -1][len2 - 1];
    }
}
