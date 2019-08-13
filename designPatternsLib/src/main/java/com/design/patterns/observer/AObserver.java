package com.design.patterns.observer;

public class AObserver implements Observer {

    private String name;
    public AObserver(String name){
        this.name = name;
    }
    @Override
    public void update(String message) {
        System.out.println( name + message);
    }
}
