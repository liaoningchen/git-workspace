package com.ifp.jvm;

public class Test02 {
    static int count = 0;
    public static void test(){
        try {
            count ++;
            test();
        }catch (Throwable e){
            System.out.println(count);
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {
        test();
    }
}
