package com.yh.learn;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test3 {
    public static void main(String[] args) {
//        String str = Stream.of("1", "2", "3", "4").collect(Collectors.joining(","));
        String str = "GPIO_BBA_6,GPIO_BBA_7,GPIO_069,GPIO_BBA_2,GPIO_BBA_3,UART4_RTS_N,GPIO_039,GPIO_038,GPIO_048,GPIO_068,GPIO_052,LTE_GPS_TIM_IND,RF0_MCSYNC,RF0_WDOG_INT,RF0_RESET_N,UART6_RXD,UART6_TXD,UART6_CTS_N,UART6_RTS_N,GPIO_230,GPIO_229";
        String[] strArr = str.split(",");
        System.out.println(strArr.length);
    }
}
