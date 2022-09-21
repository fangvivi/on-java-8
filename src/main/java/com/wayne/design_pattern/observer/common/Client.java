package com.wayne.design_pattern.observer.common;

/**
 * @author wayne
 */
public class Client {
    public static void main(String[] args) {
        ConcreteObserver observer = new ConcreteObserver();
        ConcreteSubject subject = new ConcreteSubject();
        subject.addObserver(observer);
        subject.doSomethings();
    }
}
