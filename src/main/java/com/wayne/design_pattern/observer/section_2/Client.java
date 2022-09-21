package com.wayne.design_pattern.observer.section_2;

/**
 * 旁观者眼中观察者模式的过程
 * @author wayne
 */
public class Client {
    public static void main(String[] args) {
        HanFeiZi hanFeiZi = new HanFeiZi();
        hanFeiZi.haveBreakfast();
        hanFeiZi.haveFun();
    }
}
