package com.ifp.jvm;

import java.util.HashMap;
import java.util.Map;

public class Test04 {
    public static void main(String[] args) {
        /**
         * 参数：-Xms1024M -Xmx1024M -XX:+UseSerialGC -XX:PretenureSizeThreshold=1000 -XX:-UseTLAB  -XX:+PrintGCDetails
         * -XX:PretenureSizeThreshold  配置对象大小超过指定大小后，直接进入老年代
         * -XX:-UseTLAB 禁用TLAB
         *
         */

        Map map = new HashMap();
        for (int i= 0;i<5;i++) {
            //一次分配1m内存
            map.put(i,new byte[1024]);
        }
    }
}
