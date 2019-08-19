package com.design.patterns.template;

public class HRWorker extends IWork{
    public HRWorker(String name) {
        super(name);
    }

    @Override
    public void work() {
        System.out.println(name + "看简历-打电话-接电话");
    }
}
