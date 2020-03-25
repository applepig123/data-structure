package com.yh.learn;

public class Test2 {
    public static void main(String[] args) {
//        System.out.println(toHex2CharString(1024l));
//        System.out.println(toHex8CharString(1024l));
        System.out.println(32 - Integer.numberOfLeadingZeros(128));
        System.out.println(Integer.numberOfLeadingZeros(128));

        String test = "91112222";
        int i = Integer.valueOf(test.charAt(0) - '0') * 1;
        System.out.println(i);
    }

    /**
     * Converts long to hex string
     * @param inVal
     * @return
     */
    public static String toHex8CharString(long inVal) {
        String hexData = String.format("%8s", Long.toHexString(inVal)).replace(' ', '0');
        hexData = hexData.substring(hexData.length() - 8);
        return "0x"+hexData;
    }

    /**
     * Converts long to hex string
     * @param inVal
     * @return
     */
    public static String toHex2CharString(long inVal) {
        String hexData = String.format("%2s", Long.toHexString(inVal)).replace(' ', '0');
        hexData = hexData.substring(hexData.length() - 2);
        return "0x"+hexData;
    }
}
