package com.yh.learn.algorithms.dynamicprogram;

public class LongestPalindromeSubstring {

    private String srcStr;

    private boolean[][] dp;

    public LongestPalindromeSubstring(String srcStr) {
        this.srcStr = srcStr;
    }

    public String getPalindromeSubStr() {
        if(srcStr == null || srcStr.length() == 0) {
            return "";
        }
        if(srcStr.length() == 1) {
            return srcStr;
        }

        int len = srcStr.length();
        dp = new boolean[len][len];

        int left = 0, right = 0;
        for(int i=len-2;i>=0;i--) {
            dp[i][i] = true;
            for(int j=i+1;j<len;j++) {
                if(srcStr.charAt(i) == srcStr.charAt(j) && dp[i+1][j-1]) {
                    dp[i][j] = true;
                    if(right - left < j - i) {
                        left = i;
                        right = j;
                    }
                }
            }
        }
        return srcStr.substring(left, right + 1);
    }
}
