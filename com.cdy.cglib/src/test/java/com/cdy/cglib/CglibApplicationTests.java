package com.cdy.cglib;

import com.cdy.cglib.com.cdy.cglib.CglibTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.FixedValue;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CglibApplicationTests {

    @Test
    public void contextLoads() {
    }

    /**
     * 对所有拦截的方法，返回相同的值
     */
    @Test
    public void testFixedValue() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(CglibTest.class);
        enhancer.setCallback(new FixedValue() {
            @Override
            public Object loadObject() throws Exception {
                return "hello cglib";
            }
        });
        CglibTest cglibTest = (CglibTest) enhancer.create();
        System.out.println(cglibTest.test1());
        System.out.println(cglibTest.equals(null));
        System.out.println(cglibTest.hashCode());

    }
}
