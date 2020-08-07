package com.design.patterns.proxy.dynamic;

import java.lang.reflect.Proxy;

/**
 * 动态代理
 * 实现：
 * 1. 创建DynamicHandler 实现 InvocationHandler 接口
 *
 * https://blog.csdn.net/wangqyoho/article/details/77584832
 * Created by zc on 2018/10/11
 */
public class DynamicProxyMain {
//https://blog.csdn.net/wsw_123/article/details/81221446
//InvocationHandler


    public static void main(String[] args) {
        Student student = new Student();
        MyInvocation invocation = new MyInvocation(student);

        Person proxy = (Person) Proxy.newProxyInstance(
                //classLoader 的调用者
                MyInvocation.class.getClassLoader(),
                new Class[]{Person.class},
                invocation);
        //通过代理类对象调用代理类方法，实际上会转到invoke方法调用
        String b = proxy.say("i a student");
        System.out.println("proxy say = " + b);
        proxy.run("五环");
    }
}
