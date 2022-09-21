package com.wayne.design_pattern.observer.common;

import lombok.extern.slf4j.Slf4j;

/**
 * @author wayne
 */
@Slf4j
public class ConcreteObserver implements Observer{
    @Override
    public void update() {
        log.info("观察者观察到活动，进行处理");
    }
}
