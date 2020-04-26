package com.yh.test.conversion;

import com.yh.test.Conversion;

public class HiSDConversion implements Conversion {
    @Override
    public String convert(String srcStr) {
        String item = srcStr.substring(4, srcStr.lastIndexOf("_"));
        item = item.substring(0, item.lastIndexOf("_"));
        return "clockPinDescriptors[" + item + "].ptd";
    }
}
