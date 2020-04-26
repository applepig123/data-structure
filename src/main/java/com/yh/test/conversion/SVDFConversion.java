package com.yh.test.conversion;

import com.yh.test.Conversion;

public class SVDFConversion implements Conversion {
    @Override
    public String convert(String srcStr) {
        String item = srcStr.substring(4);
        if(item.contains("FFC")) {
            return "ffc[" + item + "].ptd";
        } else {
            return "ffc[LOCK_" + item + "].ptd";
        }
    }
}
