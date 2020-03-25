package com.yh.learn.algorithms.dynamicprogram;

/**
 * LeetCode提交结果：
 * 执行用时 : 8 ms, 在所有 Java 提交中击败了 82.34% 的用户
 * 内存消耗 : 36.3 MB, 在所有 Java 提交中击败了 89.88% 的用户
 *
 * 动态规划的思路：问题分解为求以第i个字符结尾的无重复最长子串的长度，可以由第i-1的字符来求，设一个数组maxLen，index表示第i个字符，maxLen[i]表示第i个字符结尾的无重复最长子串的起始index。
 * 状态是字符的索引index
 * 状态转移方程：
 *      当 maxLen[i-1]==i-1 时
 *          当 str[i]==str[i-1]时，maxLen[i]=i
 *          当 str[i]!=str[i-1]时，maxLen[i]=i-1
 *      当 maxLen[i-1]!=i-1 时
 *          遍历从 maxLen[i-1]到i-1的字符，从后往前遍历，如果找到第一个重复字符，则maxLen[i]=第一个重复字符index + 1；没有找到则maxLen[i]=max[i-1]。
 */
public class LongestNonRepetitiveSubString {

    private String srcStr;

    private int[] maxLen;

    public LongestNonRepetitiveSubString(String srcStr) {
        this.srcStr = srcStr;
    }

    public String getNonRepetitiveSubString() {

        if(srcStr == null || srcStr.length() == 0) {
            return "";
        }
        if(srcStr.length() == 1) {
            return srcStr;
        }
        int len = srcStr.length();
        maxLen = new int[len];

        for(int i=0;i<len;i++) {
            maxLen[i] = i;
        }

        for(int i=1;i<len;i++) {
            if(maxLen[i-1] == i - 1) {
                // maxLen[i-1] == i - 1时，说明以第i-1的字符结尾的最长无重复子串长度等于1，即自身
                if(srcStr.charAt(i) == srcStr.charAt(i-1)) {
                    maxLen[i] = i;
                } else {
                    maxLen[i] = i - 1;
                }
            } else {
                // 说明第i-1个字符结尾的最长无重复子串长度大于1，需要从后往前遍历 maxLen[i-1]到i-1的字符，判断是否与第i个字符重复
                int j = i - 1;
                boolean isFind = false;
                while(j >= maxLen[i-1]) {
                    if(srcStr.charAt(j) == srcStr.charAt(i)) {
                        isFind = true;
                        break;
                    }
                    j --;
                }
                if(isFind) {
                    maxLen[i] = j + 1;
                } else {
                    maxLen[i] = maxLen[i - 1];
                }
            }
        }
        int max = 0, index = 0;
        for(int i=0;i<len;i++) {
            if(max < i - maxLen[i] + 1) {
                max = i - maxLen[i] + 1;
                index = i;
            }
        }
        return srcStr.substring(maxLen[index], index + 1);
    }
}