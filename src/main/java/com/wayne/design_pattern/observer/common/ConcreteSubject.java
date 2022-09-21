package com.wayne.design_pattern.observer.common;

import lombok.extern.slf4j.Slf4j;

/**
 * 具体的被观察者
 * @author wayne
 */
@Slf4j
public class ConcreteSubject extends Subject{

    public void doSomethings(){
        log.info("被观察者做了一些事");
        super.notifyObserver();
    }
}
