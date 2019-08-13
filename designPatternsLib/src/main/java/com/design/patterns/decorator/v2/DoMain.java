package com.design.patterns.decorator.v2;

public class DoMain {
    public static void main(String[] args) {
        Beverage beverage = new Coffee1();

//        beverage = new Milk(beverage);
//        System.out.println(beverage.getDescription());
//        System.out.println(beverage.getPrice());

        //和上面相同
        Beverage milk  = new Milk(beverage);
        System.out.println(milk.getDescription());
        System.out.println(milk.getPrice());
    }
}
