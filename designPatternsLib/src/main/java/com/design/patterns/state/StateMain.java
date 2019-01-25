package com.design.patterns.state;

/**
 * 状态模式<br>
 * 定义：当一个对象的内在状态改变时允许改变其行为，这对象看起来像是改变了其类 </b>
 * 组成：1.Controller 环境类，持有一个State对象的引用，该实例定义了对象的当前状态</b>
 *       2.State   抽象状态，定义一个或一组接口，表示该状态下的行为
 *       3.ConcreteState 具体实现类
 *
 * Created by zc on 2019/1/24
 */
public class StateMain {

    public static void main(String[] args) {
        Controller controller = new Controller();
        //设置状态为开机
        controller.onPower();
        controller.nextChannel();
        controller.prevChannel();
        controller.turnDown();
        controller.turnUp();
        //设置为关机
        controller.offPower();
        controller.nextChannel();
        controller.prevChannel();
        controller.turnDown();
        controller.turnUp();
    }
}
