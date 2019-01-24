package com.design.patterns.factoryMethod;

/**
 * 工厂方法模式<b>
 * 定义一用于创建对象的接口，子类决定实例化那个类</b>
 * 1.反射机制
 * 组成：
 * <p>
 *     1. 抽象产品 （奥迪车）
 *     2. 具体产品  （Q3,Q5,Q7）
 *     3. 抽象工厂方法  （AudiFactory）
 *     4. 工厂方法的具体实现 （AudiCarFactory）
 * </p>
 */
public class FactoryMethodMain {

    public static void main(String[] args) {
        AudiFactory carFactory = new AudiCarFactory();
        AudiCar q3 = carFactory.createAudiCar(AudiQ3.class);
        AudiCar q5 = carFactory.createAudiCar(AudiQ5.class);
        AudiCar q7 = carFactory.createAudiCar(AudiQ7.class);
        q3.dive();
        q5.dive();
        q7.dive();
    }
}
