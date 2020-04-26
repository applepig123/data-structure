package com.yh.test.conversion;

import com.yh.test.Conversion;

public class PllFllConversion implements Conversion {
    @Override
    public String convert(String srcStr) {
        if(srcStr == null || srcStr.isEmpty()) {
            return null;
        }
        String item = srcStr.substring(13);
        String suffix = srcStr.substring(0, 12);
        if(suffix.contains("FREQ")) {
            return "digCaps[" + item + "].ptd_PLL_FREQ";
        } else {
            return "digCaps[" + item + "].ptd_PLL_LOCK";
        }
    }
}
