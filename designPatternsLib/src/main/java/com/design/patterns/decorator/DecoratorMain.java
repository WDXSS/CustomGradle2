package com.design.patterns.decorator;

/**
 * 简单实例：
 * 杨过本身就会全真剑法，
 * 有两位武学前辈洪七公和欧阳锋分别传授杨过打狗棒法和蛤蟆功，
 * 这样杨过除了会全真剑法还会打狗棒法和蛤蟆功。
 *
 * V2
 * 咖啡是一种饮料，咖啡的本质是咖啡豆+水磨出来的。
 * 咖啡店现在要卖各种口味的咖啡，如果不使用装饰模式，
 * 那么在销售系统中，各种不一样的咖啡都要产生一个类，
 * 如果有4中咖啡豆，5种口味，那么将要产生至少20个类（不包括混合口味），非常麻烦。
 * 使用了装饰模式，只需要11个类即可生产任意口味咖啡（包括混合口味）
 */
public class DecoratorMain {
    public static void main(String[] args) {
        Component yangGou = new YangGuo();

        HongQIGongDecorator hongQIGongDecorator = new HongQIGongDecorator(yangGou);

        hongQIGongDecorator.attackMagic();
    }
}
