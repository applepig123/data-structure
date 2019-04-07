package com.yh.learn.algorithms;

/**
 * 希尔排序(属于插入排序的一种，改良版插入排序)
 * Created by yanghua on 2019/4/6.
 */
public class ShellSort implements Sort {

    private int[] sortList;

    public ShellSort(int[] sortList) {
        this.sortList = sortList;
    }

    @Override
    public int[] sort() {
        int length = sortList.length;
        //将数据以增量来分成几个list分别排序，直到增量变为1，则最后一次再做一次整体排序
        for(int increment=(int)Math.floor(length / 3);increment>0;increment=(int)Math.floor(increment / 2)) {
            for(int i=increment;i<length;i++) {
                int j = i;
                int current = sortList[j];
                //前面已排序的数据进行后移
                while (j - increment >= 0 && current < sortList[j - increment]) {
                    sortList[j] = sortList[j - increment];
                    j = j - increment;
                }
                sortList[j] = current;
            }
        }

        return sortList;
    }
}
