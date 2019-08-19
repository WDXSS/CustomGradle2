package com.design.patterns.template;

import java.util.Date;

/**
 * 抽象类 一般提供3种方法 抽象方法，具体方法，钩子方法
 * 抽象方法 子类实现
 * 具体方法 父类实现子类公共的实现
 * 钩子方法
 * 1.它有一个空实现的方法，子类可以视情况来决定是否要覆盖它
 * 2.返回类型通常是bool类型的，一般用于对某个条件进行判断
 */
public abstract class IWork {
    public String name;

    public IWork(String name) {
        this.name = name;
    }

    //该方法为final，防止算法框架被覆写
    public final void workOneDay() {
        enterCompany();
        computerOn();
        workBefore();
        work();
        computerOff();
        exitCompany();
    }

    private void enterCompany(){
        System.out.println(this.name + "进入公司");
    }
    private void computerOn(){
        System.out.println(this.name + "打开电脑");
    }
    public abstract void work();

    private void computerOff(){
        System.out.println(this.name + "关闭电脑");
    }

    private void exitCompany(){
        if(isNeedPrintDate()){
            System.out.println(new Date().toLocaleString()+"-->");
        }
        System.out.println(this.name + "离开公司");
    }



    //钩子方法
    public boolean isNeedPrintDate() {
        //打印时间
        return false;
    }

    public void workBefore(){
        //开始工作之前
    }
}
