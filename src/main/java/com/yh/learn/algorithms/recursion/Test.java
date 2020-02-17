package com.yh.learn.algorithms.recursion;

import com.yh.learn.utils.NumberUtil;

/**
 * Created by yanghua on 2020/1/29.
 */
public class Test {
    public static void main(String[] args) {
//        NQueen nQueen = new NQueen(4);
////        nQueen.doSolve();

        //        int[] array = NumberUtil.randomArray(0, 100, 50);
        int[] array = new int[] {1,2,3,0,0,6,1,2,3,0,0,6};
        NumberUtil.printList(array);
        System.out.println("---------------");
        MoveZeroes moveZeroes = new MoveZeroes(array);
        moveZeroes.move();
        NumberUtil.printList(array);
    }
}
