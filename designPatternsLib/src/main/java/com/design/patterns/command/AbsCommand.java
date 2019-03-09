package com.design.patterns.command;

/**
 * 抽象命令：
 * 1.声明执行接口
 * 2.持有执行者的引用（或者再子类持有）
 */
public abstract class AbsCommand {
    //1.
    abstract public void executeCommand();
    //2.
//    public Chef mChef;
    //添加的库存，不是命令模式里必须的
    abstract public boolean isSurplus();
}
