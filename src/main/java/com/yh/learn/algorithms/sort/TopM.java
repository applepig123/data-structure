package com.yh.learn.algorithms.sort;

import com.yh.learn.algorithms.sort.MergeSort;
import com.yh.learn.algorithms.sort.Sort;

import java.util.Arrays;

/**
 * 一个具有N长度的数组，输出其中前 M 个大的数，按照从小到大排序
 * 思路：使用快速排序的思路，找到一个基准，使得它右边的数全都比他大，当这个基准右侧正好有 M 个数时，则
 * 找出了前 M 个大的数，再对这个子数组进行排序即可。
 */
public class TopM {
    private int[] srcList;

    private int topNum;

    private int index;

    public TopM(int[] srcList, int topNum) {
        this.srcList = srcList;
        this.topNum = topNum;
    }

    public int[] get() {
        binarySearch(this.srcList, 0, this.srcList.length - 1);
        int[] sortList = Arrays.copyOfRange(this.srcList, this.index, this.srcList.length);
        Sort sort = new MergeSort(sortList);
        return sort.sort();
    }

    private void binarySearch(int[] array, int low, int high) {
        if(low < high) {
            int pivot = searchPivot(array, low, high);
            // 数组中基准点右侧数的数量，包含基准点
            int count = array.length - pivot;
            if(count > this.topNum + 1) {
                // 当count > M + 1，则在右侧继续寻找基准点
                binarySearch(array, pivot + 1, high);
            } else if(count < this.topNum) {
                // 当count < M，则在左侧继续寻找基准点
                binarySearch(array, low, pivot - 1);
            } else {
                if(count > this.topNum) {
                    // 当正好 count == M + 1 时，基准点右侧数的数量（不包含基准点）正好等于 M，则将指针向右移动一位
                    pivot ++;
                }
                this.index = pivot;
            }
        } else {
            this.index = low;
        }
    }

    private int searchPivot(int[] array, int low, int high) {
        int pivot = array[low]; // 以最左侧为基准
        while(low < high) {
            // high索引，当队尾的元素大于等于基准数据时,向前挪动high指针
            while(high > low && pivot <= array[high]) {
                high --;
            }
            // 如果队尾元素小于pivot,需要将其赋值给low
            array[low] = array[high];

            //low索引，当队首元素小于等于基准数据时,向前挪动low指针
            while(low < high && pivot > array[low]) {
                low ++;
            }
            //当队首元素大于pivot时,需要将其赋值给high
            array[high] = array[low];
        }
        // 跳出循环时low和high相等,此时的low或high就是pivot的正确索引位置
        // 由原理部分可以很清楚的知道low位置的值并不是pivot,所以需要将pivot赋值给arr[low]
        array[low] = pivot;
        return low;
    }
}
