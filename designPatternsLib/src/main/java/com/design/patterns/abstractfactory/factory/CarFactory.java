package com.design.patterns.abstractfactory.factory;

import com.design.patterns.abstractfactory.product.brake.IBrake;
import com.design.patterns.abstractfactory.product.engine.IEngine;
import com.design.patterns.abstractfactory.product.tire.ITire;

/**
 * car的超级工厂
 * 定义：车的抽象
 * 1.轮胎
 * 2.发动机
 * 3.制动系统
 * Created by zc on 2019/1/24
 */
public abstract class CarFactory {
    public abstract ITire createTire();
    public abstract IEngine createEngine();
    public abstract IBrake createBrake();
}
