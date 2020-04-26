package com.yh.test;

import com.yh.test.conversion.HiSDConversion;
import com.yh.test.conversion.PllFllConversion;
import com.yh.test.conversion.PllUnlockConversion;
import com.yh.test.conversion.SVDFConversion;

public class Test {
    public static void main(String[] args) {
        String dst = "C:/文件/HiSilicon/testtable/dst.txt", src = "C:/文件/HiSilicon/testtable/src.txt";
        Conversion conversion = new SVDFConversion();
        TestTableNameReplace testTableNameReplace = new TestTableNameReplace(src, dst, conversion);
        testTableNameReplace.transfer();
    }
}
