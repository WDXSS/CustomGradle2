package com.design.patterns.observer;

/**
 * 被观察者
 */
public interface Subject {
    void attach(Observer observer);
    void detach(Observer observer);
    void notify(String message);
}
