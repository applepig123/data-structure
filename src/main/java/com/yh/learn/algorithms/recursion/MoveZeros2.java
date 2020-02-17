package com.yh.learn.algorithms.recursion;

/**
 * leetcode例题：
 * 给定一个数组，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。<br/>
 * 示例:<br/>
 * <br/>
 * 输入: [0,1,0,3,12]<br/>
 * 输出: [1,3,12,0,0]<br/>
 * 说明:<br/>
 * <br/>
 * 必须在原数组上操作，不能拷贝额外的数组。<br/>
 * 尽量减少操作次数。<br/>
 *
 * 定义了两个数组的索引，一遍循环将所有零往后移动
 */
public class MoveZeros2 {

    private int[] srcList;

    public MoveZeros2(int[] srcList) {
        this.srcList = srcList;
    }

    public void move() {
        int i=0, j=0, len = srcList.length;
        while (j < len) {
            if(srcList[j] != 0) {
                // 当数组元素非零时，将该元素放到第一个零的位置
                // 如果i===j时，则此操作相当于位置不变
                srcList[i++] = srcList[j];
            }
            j++;
        }
        while (i < len) {
            srcList[i++] = 0;
        }
    }
}
