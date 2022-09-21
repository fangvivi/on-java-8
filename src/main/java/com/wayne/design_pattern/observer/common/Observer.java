package com.wayne.design_pattern.observer.common;

/**
 * 观察者需要实现这个接口
 * @author wayne
 */
public interface Observer {

    /**
     * 观察到被观察者有活动时，采取的行动
     */
    void update();
}
