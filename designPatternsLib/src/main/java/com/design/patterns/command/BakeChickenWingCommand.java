package com.design.patterns.command;

/**
 * 烤鸡翅
 */
public class BakeChickenWingCommand extends AbsCommand {

    private Chef mChef;
    public BakeChickenWingCommand(Chef chef) {
        this.mChef = chef;
    }

    @Override
    public void executeCommand() {
        mChef.bakeChickenWing();
    }

    @Override
    public boolean isSurplus() {
        return true;
    }
}
