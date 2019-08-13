package com.design.patterns.decorator;

public class HongQIGongDecorator extends Decorator {

    public HongQIGongDecorator(Component mComponent) {
        super(mComponent);

    }
    private void teachAttackMagic(){
        System.out.println("洪七公教授打狗棒法");
        System.out.println("杨过使用打狗棒法");
    }
    @Override
    void attackMagic() {
        super.attackMagic();
        teachAttackMagic();
    }
}
