package com.yh.learn.algorithms;

/**
 * Created by yanghua on 2019/4/7.
 */
public class QuickSort implements Sort {

    private int[] sortList;

    public QuickSort(int[] sortList) {
        this.sortList = sortList;
    }

    @Override
    public int[] sort() {
        sort(sortList, 0, sortList.length - 1);
        return sortList;
    }

    private void sort(int[] arr, int low, int high) {
        //递归结束条件，high <= low
        if(low < high) {
            //获取基准归位后的索引，使用该索引将数组分割为左右两部分
            int pivot = doPivot(arr, low, high);
            //对基准左侧数据进行排序，使用递归
            sort(arr, low, pivot - 1);
            //对基准由侧数据进行排序，使用递归
            sort(arr, pivot + 1, high);
        }
    }

    /**
     * 执行基准归位操作，返回基准归位后的索引
     * 使用该索引将数组分割为左右两部分
     * @param arr
     * @param low
     * @param high
     * @return
     */
    private int doPivot(int[] arr, int low, int high) {
        int pivot = arr[low]; //以数组首位为基准
        while(low < high) {
            //high索引，当队尾的元素大于等于基准数据时,向前挪动high指针
            while (high > low && arr[high] > pivot) {
               high --;
            }
            //如果队尾元素小于pivot,需要将其赋值给low
            arr[low] = arr[high];

            //low索引，当队首元素小于等于基准数据时,向前挪动low指针
            while (low < high && arr[low] < pivot) {
                low ++;
            }
            //当队首元素大于pivot时,需要将其赋值给high
            arr[high] = arr[low];
        }
        // 跳出循环时low和high相等,此时的low或high就是pivot的正确索引位置
        // 由原理部分可以很清楚的知道low位置的值并不是pivot,所以需要将pivot赋值给arr[low]
        arr[low] = pivot;
        return low;
    }

}
