package com.design.patterns.chain;

/**
 * 组长
 */
public class Director extends AbsLeader {

    public Director(String leaderName) {
        super(leaderName);
    }

    @Override
    public void handle(Request request) {
        System.out.println(leaderName + "同意" + request.reqName + "涨薪 " + request.upSalary + "元");
    }

    @Override
    public boolean isSuitable(Request request) {
        return request.upSalary < 500;
    }
}
