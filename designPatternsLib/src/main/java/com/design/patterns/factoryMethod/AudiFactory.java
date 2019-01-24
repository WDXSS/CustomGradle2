package com.design.patterns.factoryMethod;

/**
 * Created by zc on 2019/1/24
 */
 abstract class AudiFactory  {
    /**
     *
     * @param clz 汽车的具体对象
     * @return  具体车型
     */
   protected abstract <T extends AudiCar>T createAudiCar(Class<T> clz);
}
