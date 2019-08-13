package com.design.patterns.decorator;

public class OuYangFengDecorator extends Decorator {
    //持有抽象组件
    public OuYangFengDecorator(Component mComponent) {
        super(mComponent);

    }
    private void teachAttackMagic(){
        System.out.println("欧阳锋教授蛤蟆功");
        System.out.println("杨过使用蛤蟆功");
    }

    @Override
    void attackMagic() {
        super.attackMagic();
        teachAttackMagic();
    }
}
