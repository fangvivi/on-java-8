package com.wayne.design_pattern.observer.common;

import java.util.Vector;

/**
 * 被观察者需要继承这个抽象类
 * @author wayne
 */
public abstract class Subject {
    private Vector<Observer> observers = new Vector<>();
    public void addObserver(Observer observer){
        this.observers.add(observer);
    }
    public void deleteObserver(Observer observer){
        this.observers.remove(observer);
    }
    void notifyObserver(){
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
