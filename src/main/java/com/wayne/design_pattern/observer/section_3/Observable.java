package com.wayne.design_pattern.observer.section_3;

/**
 * 所有的被观察者都需要实现这个接口
 * @author wayne
 */
public interface Observable {
    /**增加一个观察者*/
    void addObserver(Observer observer);
    /**删除一个观察者*/
    void deleteObserver(Observer observer);
    /**被观察者有什么动静，就通知所有的观察者*/
    void notifyAllObserver(String context);
}
