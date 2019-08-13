package com.design.patterns.decorator.v2;

public class Coffee2 implements Beverage {

    private String description = "第二种咖啡豆";
    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public double getPrice() {
        return 8;
    }
}
