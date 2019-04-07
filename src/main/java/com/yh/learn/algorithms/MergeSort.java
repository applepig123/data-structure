package com.yh.learn.algorithms;

/**
 * Created by yanghua on 2019/4/6.
 */
public class MergeSort implements Sort {

    private int[] sortList;

    public MergeSort(int[] sortList) {
        this.sortList = sortList;
    }

    @Override
    public int[] sort() {
        int[] temp = new int[sortList.length];
        sort(sortList, 0, sortList.length - 1, temp);
        return temp;
    }

    private void sort(int[] arr, int left, int right, int[] temp) {
        if(left == right) {
            return;
        }

        int mid = (left + right) / 2;
        sort(arr, left, mid, temp); //递归排序左侧的list
        sort(arr, mid + 1, right, temp); //递归排序右侧的list
        merge(arr, left, mid, right, temp); //合并左右两个list
    }

    private void merge(int[] arr, int left, int mid, int right, int[] temp) {

        int i = left;
        int j = mid + 1;
        int k = 0;
        //将左右两个list按照大小排序合并到temp中，两个list是已经有序的了
        //思路是先取左右list的第一个比较，较小的放入temp中，取出的list的index向后移一位，
        //再重复上述操作，直到有一个list的元素全部取出
        while(i <= mid && j <= right) {
            if(arr[i] > arr[j]) {
                temp[k] = arr[j];
                j ++;
            } else {
                temp[k] = arr[i];
                i ++;
            }

            k ++;
        }

        //将两个list中剩下没有取出的元素放到temp中
        if(i <= mid) {
            while (i <= mid) {
                temp[k] = arr[i];
                i ++;
                k ++;
            }
        }
        if(j <= right) {
            while (j <= right) {
                temp[k] = arr[j];
                j ++;
                k ++;
            }
        }

        //将temp中已排序好的list复制到原数组中
        k = 0;
        while (left <= right) {
            arr[left] = temp[k];
            left ++;
            k ++;
        }
    }
}
