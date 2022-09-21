package com.wayne.design_pattern.observer.section_1;

/**
 * 旁观者眼中观察者模式的过程
 * @author wayne
 */
public class Client {
    public static void main(String[] args) throws InterruptedException {
        HanFeiZi hanFeiZi = new HanFeiZi();
        LiSi liSi = new LiSi();
        Spy breakfastSpy = new Spy(hanFeiZi, liSi);
        breakfastSpy.start();

        Spy haveFunSpy = new Spy(hanFeiZi, liSi);
        haveFunSpy.start();

        Thread.sleep(1000);
        hanFeiZi.haveBreakfast();

        Thread.sleep(1000);
        hanFeiZi.haveFun();


    }
}
