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
 * 使用归并排序的思路来解答，此方法在leetcode上只击败了27%的人
 */
public class MoveZeroes {
    private int[] srcList;

    public MoveZeroes(int[] srcList) {
        this.srcList = srcList;
    }

    public void move() {
        move(srcList, 0, srcList.length - 1);
    }

    private void move(int[] srcList, int left, int right) {
        if(left < right) {
            int mid = left + (right - left) / 2;
            //移动左边，将所有0移到左边数组末尾
            move(srcList, left, mid);
            //移动右边，将所有0移到右边数组末尾
            move(srcList, mid + 1, right);
            //将两个数组合并成一个数组，合并时按照题目要求合并
            merge(srcList, left, mid, right);
        }
    }

    /**
     * 此时左右两个数组已经是排好的数组，数组的零全在最后面
     * @param srcList
     * @param left
     * @param mid
     * @param right
     */
    private void merge(int[] srcList, int left, int mid, int right) {
        int leftFirstZeroId = mid + 1;
        // 找到左边数组第一个零的位置
        for(int i=left;i<=mid;i++) {
            if(srcList[i] == 0) {
                leftFirstZeroId = i;
                break;
            }
        }

        // 将右边非零按照顺序挪到左边零的位置
        int i = leftFirstZeroId, j = mid + 1;
        while(i <= mid && j <= right && srcList[j] != 0) {
            srcList[i] = srcList[j];
            srcList[j] = 0;
            i++;
            j++;
        }
        // j<=right，说明右边没有遍历完全，可能需要将右边剩下的非零移动过去
        // 一种情况，左边零的位置已经全部占满，则 i = mid + 1，如果 i = j，则说明所有零已经全都挪到末尾了
        if(j <= right && i != j) {
            while (j <= right) {
                if(srcList[j] != 0) {
                    srcList[i] = srcList[j];
                    srcList[j] = 0;
                    i++;
                    j++;
                } else {
                    break;
                }
            }
        }
    }
}
