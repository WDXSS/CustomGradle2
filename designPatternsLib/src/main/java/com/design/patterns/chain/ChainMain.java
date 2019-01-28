package com.design.patterns.chain;

/**
 * 责任链模式（Chain of Responsibility Pattern）
 * 定义：
 * 组成：
 * Handler：抽象处理对象 abs抽象类
 *          1.声明请求方法
 *          2.处理接口
 *          3.持有下一个节点的引用
 *          4.设置下一个节点的方法
 * ConcreteHandler 具体实现
 * 战：请求涨工资，500元组长可以做主，1000元主管做主，3000元 经理，4000元Boss做主,4000以上没人处理
 * 1.抽象领导 AbsLeader 对象
 */
public class ChainMain {
    public static void main(String[] args) {
        Director director = new Director("组长");
        Supervisor supervisor = new Supervisor("主管");
        Manager manager = new Manager("经理");
        Boss boss = new Boss("Boss");

        director.setAbsLeader(supervisor);
        supervisor.setAbsLeader(manager);
        manager.setAbsLeader(boss);

        Request request = new Request();
        request.upSalary = 500;
        request.reqName = "五";

        Request request2 = new Request();
        request2.upSalary = 2500;
        request2.reqName = "二千五";

        Request request3 = new Request();
        request3.upSalary = 4500;
        request3.reqName = "4千";

        director.requestHandle(request);
        director.requestHandle(request2);
        director.requestHandle(request3);


    }
}
