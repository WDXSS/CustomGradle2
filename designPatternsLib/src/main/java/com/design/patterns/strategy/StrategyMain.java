package com.design.patterns.strategy;

/**
 * 策略模式
 * Created by zc on 2019/1/24
 */
public class StrategyMain {
    //StrategyMain 充当Context角色

    public static void main(String[] args) {
        StrategyMain strategyMain = new StrategyMain();
        strategyMain.setIStrategy(new BusStrategy());
        strategyMain.calculatePrice(5);
        System.out.println("----------------------");
        strategyMain.setIStrategy(new SubwayStrategy());//SubwayStrategy 和 BusStrategy 可以相互替换
        strategyMain.calculatePrice(6);

    }

    private IStrategy mIStrategy;//选择出行的方式
    //设置策略
    private void setIStrategy(IStrategy strategy){
        this.mIStrategy = strategy;
    }
    //出行的费用
    private void calculatePrice(int km){
        int price = mIStrategy.price(km);
        System.out.println(mIStrategy.way + " 出行需要花费 price = [" + price + "]");
    }
}
