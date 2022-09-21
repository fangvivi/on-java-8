package com.wayne.design_pattern.observer.section_3;

import com.wayne.design_pattern.observer.ILiSi;
import lombok.extern.slf4j.Slf4j;

/**
 * @author wayne
 */
@Slf4j
public class LiSi implements Observer {
    @Override
    public void update(String context) {
        log.info("李斯：观察到韩非子活动，开始向皇上汇报...");
        this.reportToQiShiHuang(context);
    }

    void reportToQiShiHuang(String reportContext){
        log.info("报告皇上，韩非子有活动了！【{}】", reportContext);
    }
}
