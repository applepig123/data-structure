package com.yh.learn.algorithms.sort;

/**
 * 普通插入排序
 * Created by yanghua on 2019/4/6.
 */
public class InsertionSort implements Sort{

    private int[] sortList;

    public InsertionSort(int[] sortList) {
        this.sortList = sortList;
    }

    @Override
    public int[] sort() {
        int preIndex = 0, current = 0;
        for(int i=1;i<sortList.length;i++) {
            preIndex = i - 1;
            current = sortList[i];
            //前面已排序的数据进行后移
            while (preIndex >= 0 && current < sortList[preIndex]) {
                sortList[preIndex + 1] = sortList[preIndex];
                preIndex --;
            }
            sortList[i] = current;
        }

        return sortList;
    }
}
