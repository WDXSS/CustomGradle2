package com.design.patterns.strategy;

/**
 * 计算策略
 * Created by zc on 2019/1/24
 */
public abstract class IStrategy {
    String way;
    /**
     * @param km 里程
     * @return 费用
     */
    abstract int price(int km);
}
