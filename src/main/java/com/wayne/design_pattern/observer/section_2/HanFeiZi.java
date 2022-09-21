package com.wayne.design_pattern.observer.section_2;

import com.wayne.design_pattern.observer.IHanFeiZi;
import com.wayne.design_pattern.observer.ILiSi;
import lombok.extern.slf4j.Slf4j;

/**
 * 韩非子
 * @author wayne
 */
@Slf4j
public class HanFeiZi implements IHanFeiZi {
    /**韩非子身边只有李斯安排的内鬼*/
    private final ILiSi liSi = new LiSi();
    @Override
    public void haveBreakfast() {
        log.info("韩非子吃早饭了");
        liSi.update("韩非子吃早饭了");
    }

    @Override
    public void haveFun() {
        log.info("韩非子在娱乐");
        liSi.update("韩非子在娱乐");
    }
}
