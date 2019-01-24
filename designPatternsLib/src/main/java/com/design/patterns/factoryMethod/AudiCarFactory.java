package com.design.patterns.factoryMethod;

/**
 * 生成奥迪车的具体工厂
 * Created by zc on 2019/1/24
 */
public class AudiCarFactory extends AudiFactory {
    @Override
    protected <T extends AudiCar> T createAudiCar(Class<T> clz) {
        AudiCar car= null;
        try {
            car = (AudiCar) Class.forName(clz.getName()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T) car;
    }

//    @Override
//    protected AudiCar createAudiCar(Class clz) {
//        AudiCar car= null;
//        try {
//            car = (AudiCar) Class.forName(clz.getName()).newInstance();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return car;
//    }
}
