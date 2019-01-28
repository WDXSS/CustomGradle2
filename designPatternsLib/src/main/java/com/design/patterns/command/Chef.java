package com.design.patterns.command;

/**
 * Receiver 类
 * 大厨
 * Created by zc on 2019/1/28
 */
public class Chef {
    private int mMuttonSurplus = 2;//库存

    public void bakeMutton(){
        System.out.println("烤羊肉一串");
    }
    public void bakeChickenWing(){
        System.out.println("烤鸡翅！！！");
    }

    public boolean hasMutton() {
        boolean has = mMuttonSurplus > 0;
        mMuttonSurplus--;
        return has;
    }
}
