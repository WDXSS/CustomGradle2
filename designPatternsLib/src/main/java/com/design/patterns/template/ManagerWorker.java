package com.design.patterns.template;

public class ManagerWorker extends IWork {

    public ManagerWorker(String name) {
        super(name);
    }

    @Override
    public boolean isNeedPrintDate() {
        return true;
    }

    @Override
    public void work() {
        System.out.println(name + "打dota...");
    }
}
