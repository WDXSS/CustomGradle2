package com.design.patterns.template;

/**
 *
 * 模板方法模式
 * http://liuwangshu.cn/designpatterns/9-templatemethod%20.html
 * https://blog.csdn.net/lmj623565791/article/details/26276093
 *
 * 简单看下定义，模版方法定义了一个算法的步骤，并且允许子类为一个或多个步骤提供实现。
 * 定义还算清晰，下面来个例子展示下本公司的上班情况（纯属娱乐，如有雷同，请对号入座）。
 * 简单描述一下：本公司有程序猿、测试、HR、项目经理等人，下面使用模版方法模式，
 * 记录下所有人员的上班情况：
 *
 * 抽象类包含了三种类型的方法，分别是抽象方法、具体方法和钩子方法。
 * 抽象方法是交由子类去实现，
 * 具体方法则在父类实现了子类公共的方法实现，
 * 钩子方法则分为两类，
 * 第一类是15行，它有一个空实现的方法，子类可以视情况来决定是否要覆盖它；
 * 第二类则是第9行，这类钩子方法的返回类型通常是bool类型的，一般用于对某个条件进行判断，
 * 如果条件满足则执行某一步骤，否则将不执行
 */
public class TemplateMain {
    public static void main(String[] args) {
        ITWorker itWorker = new ITWorker("攻城狮");
        itWorker.workOneDay();

        HRWorker hrWorker = new HRWorker("hr ");
        hrWorker.workOneDay();

        ManagerWorker managerWorker = new ManagerWorker("项目经理 ");
        managerWorker.workOneDay();
    }
}
