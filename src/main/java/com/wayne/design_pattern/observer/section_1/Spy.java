package com.wayne.design_pattern.observer.section_1;

/**
 * 李斯安插在韩非子身边的内鬼
 * @author wayne
 */
public class Spy extends Thread{
    private final HanFeiZi hanFeiZi;
    private final LiSi liSi;

    public Spy(HanFeiZi hanFeiZi, LiSi liSi) {
        this.hanFeiZi = hanFeiZi;
        this.liSi = liSi;
    }

    @Override
    public void run() {
        while (true){
            if(hanFeiZi.isHavingBreakfast()){
                this.liSi.update("韩非子在吃早饭");
                // 重置状态继续监控
                this.hanFeiZi.setHavingBreakfast(false);
            } else if(hanFeiZi.isHavingFun()){
                this.liSi.update("韩非子在娱乐");
                // 重置状态继续监控
                this.hanFeiZi.setHavingFun(false);
            }
        }
    }
}
