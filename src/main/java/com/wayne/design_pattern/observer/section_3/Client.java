package com.wayne.design_pattern.observer.section_3;

/**
 * 旁观者眼中观察者模式的过程
 * @author wayne
 */
public class Client {
    public static void main(String[] args) {
        HanFeiZi hanFeiZi = new HanFeiZi();
        LiSi liSi = new LiSi();
        ZhangSi zhangSi = new ZhangSi();
        // 李斯开始观察韩非子
        hanFeiZi.addObserver(liSi);
        // 张斯开始观察韩非子
        hanFeiZi.addObserver(zhangSi);
        // 韩非子开始活动
        hanFeiZi.haveBreakfast();
        hanFeiZi.haveFun();
    }
}
