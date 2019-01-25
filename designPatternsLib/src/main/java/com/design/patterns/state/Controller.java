package com.design.patterns.state;

/**
 * Controller 环境类，持有一个State对象的引用，该实例定义了对象的当前状态 <br>
 * 1.持有IState 的一个具体对象
 * 2.添加设置IState的方法
 * 3.设置当前状态下的行为方法
 * 状态模式：123完成
 * 4.优化可以将开机和关机提成接口
 * Created by zc on 2019/1/25
 */
public class Controller implements IPowerController{
//1
    private IState mIState;

//2
    private void setIState(IState IState) {
        this.mIState = IState;
    }
//3
    public void nextChannel(){
        mIState.nextChannel();
    }
    public void prevChannel(){
        mIState.prevChannel();
    }
    public void turnUp(){
        mIState.turnUp();
    }
    public void turnDown(){
        mIState.turnDown();
    }
//4
    @Override
    public void onPower() {
        System.out.println("点击了开机----");
        setIState(new OnState());
    }

    @Override
    public void offPower() {
        System.out.println("点击了关机-----");
        setIState(new OffState());
    }
}
