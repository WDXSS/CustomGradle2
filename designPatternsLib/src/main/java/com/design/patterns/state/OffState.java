package com.design.patterns.state;

/**
 * 关机状态：关机后切换频道，调整音量无反应
 * Created by zc on 2019/1/25
 */
public class OffState implements IState {

    public OffState() {
        System.out.println("关机了-----");
    }

    @Override
    public void nextChannel() {

    }

    @Override
    public void prevChannel() {

    }

    @Override
    public void turnUp() {

    }

    @Override
    public void turnDown() {

    }
}
