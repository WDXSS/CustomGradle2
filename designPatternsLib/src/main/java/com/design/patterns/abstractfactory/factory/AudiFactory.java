package com.design.patterns.abstractfactory.factory;

import com.design.patterns.abstractfactory.product.brake.IBrake;
import com.design.patterns.abstractfactory.product.brake.SeniorBrake;
import com.design.patterns.abstractfactory.product.engine.IEngine;
import com.design.patterns.abstractfactory.product.engine.ImportEngine;
import com.design.patterns.abstractfactory.product.tire.ITire;
import com.design.patterns.abstractfactory.product.tire.NormalTire;

/**
 * 奥迪A8
 * Created by zc on 2019/1/24
 */
public class AudiFactory extends CarFactory {
    public AudiFactory() {
        System.out.println("奥迪A8的配置");
    }

    @Override
    public ITire createTire() {
        return new NormalTire();
    }

    @Override
    public IEngine createEngine() {
        return new ImportEngine();
    }

    @Override
    public IBrake createBrake() {
        return new SeniorBrake();
    }
}
