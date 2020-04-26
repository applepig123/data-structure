package com.yh.test.conversion;

import com.yh.test.Conversion;

public class PllUnlockConversion implements Conversion {
    @Override
    public String convert(String srcStr) {
        String item = srcStr.substring(4);
        return "addressInfo[" + item + "].ptd";
    }
}
