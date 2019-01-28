package com.design.patterns.command;

/**
 * 命令模式</b>
 * Created by zc on 2019/1/28
 */
public class CommandMain {

    public static void main(String[] args) {
        Chef chef = new Chef();
        AbsCommand bakeMutton1 = new BakeMuttonCommand(chef);
        AbsCommand bakeMutton2 = new BakeMuttonCommand(chef);
        AbsCommand bakeMutton3 = new BakeMuttonCommand(chef);
        AbsCommand bakeMutton4 = new BakeMuttonCommand(chef);

        AbsCommand chicken1 = new BakeChickenWingCommand(chef);
        AbsCommand chicken2 = new BakeChickenWingCommand(chef);
        AbsCommand chicken3 = new BakeChickenWingCommand(chef);
        AbsCommand chicken4 = new BakeChickenWingCommand(chef);

        Waiter waiter = new Waiter();
        waiter.addCommand(bakeMutton1);
        waiter.addCommand(bakeMutton2);
        waiter.addCommand(bakeMutton3);
        waiter.addCommand(bakeMutton4);


        waiter.addCommand(chicken1);
        waiter.addCommand(chicken2);
        waiter.addCommand(chicken3);
        waiter.addCommand(chicken4);

        waiter.notifyCommand();
    }
}
