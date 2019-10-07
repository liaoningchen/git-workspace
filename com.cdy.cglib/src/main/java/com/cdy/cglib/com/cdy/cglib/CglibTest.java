package com.cdy.cglib.com.cdy.cglib;

import com.cdy.cglib.com.cdy.cglib.service.ClibService;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibTest {

    public void test(){
        System.out.println("cglib  test");
    }

    public String test1(){
        return  "cglib  test1";
    }

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(CglibTest.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("开始。。。。。。。。。。。");

                Object object = methodProxy.invokeSuper(o,objects);

                System.out.println("结束。。。。。。。。。。。。");

                return object;
            }
        });
       /* CglibTest cglibTest = (CglibTest) enhancer.create();
        cglibTest.test();*/

        ClibService clibService = (ClibService) enhancer.create();
        clibService.cglibTest();

    }
}
