package com.wayne.design_pattern.observer.section_3;

import com.wayne.design_pattern.observer.IHanFeiZi;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wayne
 */
@Slf4j
public class HanFeiZi implements IHanFeiZi, Observable {
    /**韩非子身边可以有很多人的内鬼*/
    private final List<Observer> observerList = new ArrayList<>();
    @Override
    public void haveBreakfast() {
        log.info("韩非子吃早饭");
        notifyAllObserver("韩非子吃早饭了");
    }

    @Override
    public void haveFun() {
        log.info("韩非子在娱乐");
        notifyAllObserver("韩非子在娱乐");
    }

    @Override
    public void addObserver(Observer observer) {
        this.observerList.add(observer);
    }

    @Override
    public void deleteObserver(Observer observer) {
        this.observerList.remove(observer);
    }

    @Override
    public void notifyAllObserver(String context) {
        for (Observer observer : this.observerList) {
            observer.update(context);
        }
    }
}
