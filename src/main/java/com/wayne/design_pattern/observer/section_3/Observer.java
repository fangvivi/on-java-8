package com.wayne.design_pattern.observer.section_3;

/**
 * 所有的观察者都需要实现这个接口
 * @author wayne
 */
public interface Observer {
    /**
     * 一旦发现被观察的对象有所动作，观察者也会有一些动作
     */
    void update(String context);
}
