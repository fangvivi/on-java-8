package com.wayne.design_pattern.observer.section_3;

import lombok.extern.slf4j.Slf4j;

/**
 * @author wayne
 */
@Slf4j
public class ZhangSi implements Observer{
    @Override
    public void update(String context) {
        log.info("张斯：观察到韩非子【{}】，忍不住大笑...", context);
        laugh();
    }

    public void laugh(){
        log.info("张斯：哈哈哈哈哈！！！");
    }
}
