package com.wayne.design_pattern.observer;

/**
 * @author wayne
 */
public interface ILiSi {
    /**
     * 一旦发现被观察的对象有所动作，观察者也会有一些动作
     */
    void update(String context);
}
