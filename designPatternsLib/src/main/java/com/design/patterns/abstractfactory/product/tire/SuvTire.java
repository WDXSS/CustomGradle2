package com.design.patterns.abstractfactory.product.tire;

/**
 * suv的轮胎
 * Created by zc on 2019/1/24
 */
public class SuvTire implements ITire{
    public SuvTire() {
        System.out.println("越野轮胎");
    }
}
