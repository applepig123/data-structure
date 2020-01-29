package com.yh.learn.algorithms.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanghua on 2020/1/29.
 */
public class NQueen {
    private int N;

    private int[] queenList;

    public NQueen(int n) {
        this.N = n;
        this.queenList = new int[n];
    }

    public void doSolve() {
//        for(int i=0;i<this.N;i++) {
            placeNQueen(0);
//        }
    }

    /**
     * 放置第 k 个皇后棋子
     * @param k
     */
    private void placeNQueen(int k) {
        if(k == this.N) {
            //说明已经放好最后一个棋子了，可以打印出来
            for(int i=0;i<this.N;i++) {
                System.out.print(queenList[i]);
                System.out.print(" ");
            }
            System.out.println();
        } else {
            //从0开始放置棋子，与前k个棋子位置作比较来判断该位置能否放置
            for(int i=0;i<this.N;i++) {
                boolean isValid = true;
                for(int j=0;j<k;j++) {
                    int idx = queenList[j];
                    if(idx == i || Math.abs(idx - i) == Math.abs(j - k)) {
                        isValid = false;
                        break;
                    }
                }
                if(isValid) {
                    //如果合适，则记录放置位置，并放置下一颗棋子
                    queenList[k] = i;
                    placeNQueen(k+1);
                }
            }
        }
    }
}
