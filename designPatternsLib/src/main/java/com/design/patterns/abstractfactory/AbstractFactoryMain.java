package com.design.patterns.abstractfactory;

import com.design.patterns.abstractfactory.factory.AudiFactory;
import com.design.patterns.abstractfactory.factory.CarFactory;
import com.design.patterns.abstractfactory.factory.SuvFactory;

/**
 * 抽象工厂
 * 定义：
 * 抽象工厂模式（Abstract CarFactory Pattern）是围绕一个超级工厂创建其他工厂。该超级工厂又称为其他工厂的工厂。
 * 这种类型的设计模式属于创建型模式，它提供了一种创建对象的最佳方式。
 *
 * 在抽象工厂模式中，接口是负责创建一个相关对象的工厂，不需要显式指定它们的类。每个生成的工厂都能按照工厂模式提供对象。
 *
 * 战：    SUV: 普通制动，国产发动机，越野轮胎
 *      奥迪A8：高级制动，进口发动机，普通轮胎
 * Created by zc on 2019/1/24
 */
public class AbstractFactoryMain {

    public static void main(String[] args) {
        CarFactory suv = new SuvFactory();
        suv.createBrake();
        suv.createEngine();
        suv.createTire();

        System.out.println("------------------------");

        CarFactory audi = new AudiFactory();
        audi.createBrake();
        audi.createEngine();
        audi.createTire();
    }
}
