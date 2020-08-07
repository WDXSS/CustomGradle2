package com.design.patterns.proxy.dynamic;

public class Student implements Person {
    @Override
    public String say(String word) {
        System.out.println("student say parameter :"+ word);
        return "这是返回值";
    }

    @Override
    public void run(String path) {
        System.out.println("student run parameter :"+ path);
    }

}
