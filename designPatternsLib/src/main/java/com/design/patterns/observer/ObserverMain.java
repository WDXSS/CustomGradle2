package com.design.patterns.observer;

public class ObserverMain {

    public static void main(String[] args) {
        AObserver aObserver = new AObserver("观察员：小明--");
        AObserver aObserver2 = new AObserver("观察员：小红--");
        AObserver aObserver3 = new AObserver("观察员：小蓝");

        ConcreteSubject subject = new ConcreteSubject();
        subject.attach(aObserver);
        subject.attach(aObserver2);
        subject.attach(aObserver3);

        subject.notify("刘望舒的专栏更新了");
    }
}
