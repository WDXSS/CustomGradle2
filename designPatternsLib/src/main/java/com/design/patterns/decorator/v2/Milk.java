package com.design.patterns.decorator.v2;

public class Milk extends Decorator {
    private String name = "加牛奶";
    private Beverage beverage;

    public Milk(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + "\n" + name;

    }

    @Override
    public double getPrice() {
        return beverage.getPrice() + 5 ;
    }
}
