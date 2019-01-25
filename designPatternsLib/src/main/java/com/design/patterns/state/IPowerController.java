package com.design.patterns.state;

/**
 * 标记：开机、关机
 * Created by zc on 2019/1/25
 */
public interface IPowerController {
    void onPower();
    void offPower();
}
