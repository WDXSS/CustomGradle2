package com.design.patterns.strategy;

/**
 * Created by zc on 2019/1/24
 */
public class BusStrategy extends IStrategy{
    public BusStrategy() {
        way = "公共汽车";
    }

    /**
     * 公交车里程收费十公里以内1元，大于十公里2元
     * @param km 里程
     * @return
     */
    @Override
    public int price(int km) {
        int price ;
        if(km < 3){
            price = 1;
        }else {
            price = 2;
        }
        return price;
    }
}
