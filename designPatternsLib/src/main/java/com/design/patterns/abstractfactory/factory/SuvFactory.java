package com.design.patterns.abstractfactory.factory;

import com.design.patterns.abstractfactory.product.brake.IBrake;
import com.design.patterns.abstractfactory.product.brake.NormalBrake;
import com.design.patterns.abstractfactory.product.engine.DomesticEngine;
import com.design.patterns.abstractfactory.product.engine.IEngine;
import com.design.patterns.abstractfactory.product.tire.ITire;
import com.design.patterns.abstractfactory.product.tire.SuvTire;

/**
 * 国产SUV
 * Created by zc on 2019/1/24
 */
public class SuvFactory extends CarFactory {
    public SuvFactory() {
        System.out.println("SUV 的配置");
    }

    @Override
    public ITire createTire() {
        return new SuvTire();
    }

    @Override
    public IEngine createEngine() {
        return new DomesticEngine();
    }

    @Override
    public IBrake createBrake() {
        return new NormalBrake();
    }
}
