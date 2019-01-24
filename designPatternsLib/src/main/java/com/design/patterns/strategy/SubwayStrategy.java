package com.design.patterns.strategy;

/**
 * Created by zc on 2019/1/24
 */
public class SubwayStrategy extends IStrategy {
    public SubwayStrategy() {
        way = "地铁";
    }

    /**
     * 地铁里程收费5公里以内3元，大于5公里5元
     * @param km 里程
     * @return
     */
    @Override
    public int price(int km) {
        int price ;
        if(km < 5){
            price = 3;
        }else{
            price = 5;
        }
        return price;
    }
}
