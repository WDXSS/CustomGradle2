package com.design.patterns.command;

import java.util.ArrayList;
import java.util.List;

/**
 * invoker 类
 * 1.命令的集合
 * 2.添加命令
 * 3.取消命令
 * 4.请求命令
 */
public class Waiter {
    //1
    private List<AbsCommand> mCommandList = new ArrayList<>();
    //2
    public void addCommand(AbsCommand command){
        if (command.isSurplus()) {
            mCommandList.add(command);
        }
    }
    //3
    public void cancelOrder(AbsCommand command){
        mCommandList.remove(command);
    }
    //4
    public void notifyCommand(){
        for (AbsCommand absCommand : mCommandList) {
            absCommand.executeCommand();
        }
    }
}
