package com.design.patterns.state;

/**
 * 开机状态
 * Created by zc on 2019/1/25
 */
public class OnState implements IState {

    public OnState() {
        System.out.println("开机了-----");
    }

    @Override
    public void nextChannel() {
        System.out.println("下一频道");
    }

    @Override
    public void prevChannel() {
        System.out.println("上一频道");
    }

    @Override
    public void turnUp() {
        System.out.println("提高音量");
    }

    @Override
    public void turnDown() {
        System.out.println("降低音量");
    }
}
