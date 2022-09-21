package com.wayne.design_pattern.observer.section_1;

import com.wayne.design_pattern.observer.IHanFeiZi;
import lombok.extern.slf4j.Slf4j;

/**
 * 韩非子
 * @author wayne
 */
@Slf4j
public class HanFeiZi implements IHanFeiZi {

    /**韩非子是否在吃早饭*/
    private boolean isHavingBreakfast = false;
    /**韩非子是否在娱乐*/
    private boolean isHavingFun = false;

    @Override
    public void haveBreakfast() {
        this.isHavingBreakfast = true;
        log.info("韩非子吃早饭");
    }

    @Override
    public void haveFun() {
        this.isHavingFun = true;
        log.info("韩非子在娱乐");
    }

    public boolean isHavingBreakfast(){
        return this.isHavingBreakfast;
    }

    public boolean isHavingFun(){
        return this.isHavingFun;
    }

    public void setHavingBreakfast(boolean havingBreakfast) {
        isHavingBreakfast = havingBreakfast;
    }

    public void setHavingFun(boolean havingFun) {
        isHavingFun = havingFun;
    }
}
