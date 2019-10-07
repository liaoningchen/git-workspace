package com.ifp.jvm;

public class Test03 {
    public static void main(String[] args) {
        /**
         * 测试进入老年代的对象
         * 参数：-Xms1024M -Xmx1024M -XX:+UseSerialGC -XX:MaxTenuringThreshold=15 -XX:PrintGCDetails
         *
         * -Xms1024M  初始化堆大小
         * -Xmx1024M  堆最大大小
         *-XX:+UseSerialGC 使用串行垃圾回收
         * -XX:MaxTenuringThreshold=15 新生代对象进入老年代需要垃圾回收的次数
         * -XX:PrintGCDetails打印垃圾回收详细
         */
    }
}
