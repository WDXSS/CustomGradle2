package com.design.patterns.command;

/**
 * 烤羊肉串
 */
public class BakeMuttonCommand extends AbsCommand {

    private Chef mChef;

    public BakeMuttonCommand(Chef chef) {
        this.mChef = chef;
    }

    @Override
    public void executeCommand() {
        mChef.bakeMutton();
    }

    @Override
    public boolean isSurplus() {
        return mChef.hasMutton();
    }
}
