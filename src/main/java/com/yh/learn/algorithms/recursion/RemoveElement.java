package com.yh.learn.algorithms.recursion;

public class RemoveElement {

    private int[] srcList;

    public RemoveElement(int[] srcList) {
        this.srcList = srcList;
    }

    public int remove(int removeValue) {
        int i=0, j=0, len = srcList.length;
        while (j < len) {
            if(srcList[j] != removeValue) {
                srcList[i++] = srcList[j];
            }
            j++;
        }
        int k = i;
        while (k < len) {
            srcList[k++] = removeValue;
        }
        return i--;
    }
}
