package com.design.patterns.template;

public class ITWorker extends IWork {

    public ITWorker(String name) {
        super(name);
    }

    @Override
    public void workBefore() {
        System.out.println(name +"工作之前先挖坑");
    }

    @Override
    public void work() {
        System.out.println(name + "写程序-测bug-fix bug");
    }
}
