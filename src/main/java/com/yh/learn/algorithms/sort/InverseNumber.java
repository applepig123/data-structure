package com.yh.learn.algorithms.sort;

/**
 * 求数组排列的逆序数
 * 思路：类似归并排序的分治思路
 * 1) 将数组分成两半，分别求出左半边的逆序数和右半边的逆序数
 * 2) 再算有多少逆序数是由左半边取一个数和右半边取一个数构成(要求O(n)实现)，此处即合并两个数组前，先计算第二种逆序数，再合并两个数组
 */
public class InverseNumber {

    private int[] srcList;

    public InverseNumber(int[] srcList) {
        this.srcList = srcList;
    }

    public int getInverseNumCount() {
        int[] tmp = new int[this.srcList.length];
        return inverse(this.srcList, 0, this.srcList.length - 1, tmp);
    }

    /**
     * 本算法所有计算逆序数其实都是在归并的时候计算的
     * 递归的结束条件是当 left == right 时，由于计算的数组中只有一个数，不存在逆序数，所以返回 0
     * 在接下的归并操作时，针对两个数组(里面只有一个数)，先计算逆序数，再合并。
     * @param array
     * @param left
     * @param right
     * @param tmp
     * @return
     */
    private int inverse(int[] array, int left, int right, int[] tmp) {
        if(left < right) {
            int mid = left + (right - left) / 2;
            // 计算左边的逆序数
            int count = inverse(array, left, mid, tmp);
            // 计算右边的逆序数
            count += inverse(array, mid + 1, right, tmp);
            // 计算第二种逆序数
            count += merge(array, left, mid, right, tmp);
            return count;
        } else {
            return  0;
        }
    }

    /**
     * 在做归并的时候计算逆序数
     * 针对两个数组，认为这两个数组已经是排序好的了(本算法中是按照从大到小排序)，左边数组 L[]，右边数组 R[]，左边数组的下标是小于右边数组的
     * 从左边开始，如果 L[0] > R[0]，则认为 R[0]~R[n] 都是 L[0] 的逆序数，则向前移动left指针；否则不够陈任何逆序数，直接向前移动right指针
     * @param array
     * @param left
     * @param mid
     * @param right
     * @param tmp
     * @return
     */
    private int merge(int[] array, int left, int mid, int right, int[] tmp) {
        int i = left;
        int j = mid + 1;
        int k = 0;
        int count = 0;
        while (i <= mid && j <= right) {
            if(array[i] > array[j]) {
                //此时构成逆序数，计算后移动指针i
                count += right - j + 1;
                tmp[k] = array[i];
                i ++;
            } else {
                //此时不构成逆序数，直接移动指针j
                tmp[k] = array[j];
                j ++;
            }
            k ++;
        }

        while (i <= mid) {
            tmp[k] = array[i];
            i ++;
            k ++;
            count += right - j + 1;
        }
        while (j <= right) {
            tmp[k] = array[j];
            j ++;
            k ++;
        }

        //将temp中已排序好的list复制到原数组中
        //目的是保留顺序，使得归并时两边数组是有序的
        k = 0;
        while (left <= right) {
            array[left] = tmp[k];
            left ++;
            k ++;
        }
        return count;
    }
}
