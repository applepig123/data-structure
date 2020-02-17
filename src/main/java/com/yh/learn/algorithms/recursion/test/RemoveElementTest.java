package com.yh.learn.algorithms.recursion.test;

import com.yh.learn.algorithms.recursion.MoveZeroes;
import com.yh.learn.algorithms.recursion.RemoveElement;
import com.yh.learn.utils.NumberUtil;

public class RemoveElementTest {

    public static void main(String[] args) {
        //        int[] array = NumberUtil.randomArray(0, 100, 50);
        int[] array = new int[] {1,2,3,4,5,6,7,8,3,9,19,11};
        NumberUtil.printList(array);
        System.out.println("---------------");
        RemoveElement removeElement = new RemoveElement(array);
        int length = removeElement.remove(3);
        System.out.println(length);
        System.out.println("---------------");
        NumberUtil.printList(array);
    }
}
