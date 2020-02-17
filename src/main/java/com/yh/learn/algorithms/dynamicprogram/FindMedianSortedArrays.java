package com.yh.learn.algorithms.dynamicprogram;

public class FindMedianSortedArrays {

    private int[] srcList1;

    private int[] srcList2;

    public FindMedianSortedArrays(int[] srcList1, int[] srcList2) {
        this.srcList1 = srcList1;
        this.srcList2 = srcList2;
    }

    public int findMedian() {

        int len1 = srcList1.length;
        int len2 = srcList2.length;

        boolean isOdd1, isOdd2;
        return 0;
    }

    private void find(int src1, int src2, int start1, int start2, int end1, int end2) {
        int diff1 = end1 - start1;
        int diff2 = end2 - start2;

        int media1, media2;
        boolean isOdd1, isOdd2;
        if(diff1 % 2 == 0) {
            isOdd1 = false;
        } else {
            isOdd1 = true;
        }
        if(diff2 % 2 == 0) {
            isOdd2 = false;
        } else {
            isOdd2 = true;
        }
        media1 = start1 + diff1 / 2;
        media2 = start2 + diff2 / 2;

//        if(isOdd1)
//        return 0;
    }
}
