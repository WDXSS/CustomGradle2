package com.design.patterns.decorator.v2;

public class Coffee1 implements Beverage {

    private String description = "第一种咖啡豆";
    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public double getPrice() {
        return 10;
    }
}
