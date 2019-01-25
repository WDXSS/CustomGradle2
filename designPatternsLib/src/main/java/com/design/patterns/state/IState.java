package com.design.patterns.state;

/**
 * 定义行为
 * 1.下一个频道
 * 2.上一个频道
 * 3.提高音量
 * 4.降低音量
 * Created by zc on 2019/1/25
 */
public interface IState {

    void nextChannel();
    void prevChannel();
    void turnUp();
    void turnDown();
}
