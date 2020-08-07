package com.design.patterns.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocation implements InvocationHandler {
    private Object obj;

    public MyInvocation(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("invoke begin");

        System.out.println("proxy = "+ proxy.getClass().getName() + "--->" + proxy.getClass().getName());
        System.out.println("obj = " + obj.getClass().getName() + "--->" + obj.getClass().getName());
        method.invoke(obj, args);
        //测试invoke() 的返回值 test the value of invoke();
        //总结：invoke 返回
        return "test the value of invoke()  ";
//      return method.invoke(obj, args);
    }
}
