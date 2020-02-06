package com.yh.learn.algorithms.dynamicprogram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestIncreaseSubSeq2 {
    private int[] srcList;

    private int[] maxLenList;

    public List<SubSeqInfo> maxLenInfoList;

    public List<Integer> maxId;

    public LongestIncreaseSubSeq2(int[] srcList) {
        this.srcList = srcList;
    }

    public int getLongestCount() {
        return searchLongestIncreaseSubSeq();
    }

    private int searchLongestIncreaseSubSeq() {
        if(srcList == null || srcList.length == 0) {
            return 0;
        }
        if(srcList.length == 1) {
            return 1;
        }

        maxLenInfoList = new ArrayList<>(srcList.length);
        this.maxLenList = new int[srcList.length];
        for(int i=0;i<maxLenList.length;i++) {
            maxLenList[i] = 1;
            SubSeqInfo subSeqInfo = new SubSeqInfo();
            subSeqInfo.init(srcList[i]);
            maxLenInfoList.add(subSeqInfo);
        }

        for(int i=1;i<maxLenList.length;i++) {
            for(int j=0;j<i;j++) {
                if(srcList[i] > srcList[j]) {
                    if(maxLenList[i] <= maxLenList[j]) {
                        maxLenList[i] = maxLenList[j] + 1;

                        maxLenInfoList.get(i).count = maxLenList[j] + 1;
                        maxLenInfoList.get(i).copy(maxLenInfoList.get(j).list, srcList[i]);
                    }
                }
            }
        }
        int max = 0;
        List<Integer> ids = new ArrayList<>();
        for(int i=0;i<maxLenList.length;i++) {
            if(max < maxLenList[i]) {
                max = maxLenList[i];
                ids.clear();
                ids.add(i);
            } else if(max == maxLenList[i]) {
                ids.add(i);
            }
        }
        maxId = ids;
        return max;
    }

    public class SubSeqInfo {
        public int count;
        public List<Integer[]> list = new ArrayList<>();

        public void copy(List<Integer[]> src, int tail) {
            list.clear();
            for(Integer[] ele : src) {
                Integer[] dst = new Integer[ele.length + 1];
                for(int i=0;i<ele.length;i++) {
                    dst[i] = ele[i];
                }
                dst[dst.length - 1] = tail;
                list.add(dst);
            }
        }
        public void init(int tail) {
            count = 1;
            Integer[] initValue = new Integer[1];
            initValue[0] = tail;
            list.add(initValue);
        }
    }
}
