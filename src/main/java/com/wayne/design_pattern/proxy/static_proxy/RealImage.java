package com.wayne.design_pattern.proxy.static_proxy;

import lombok.extern.slf4j.Slf4j;

/**
 * 被代理的的对象
 * @author wayne
 */
@Slf4j
public class RealImage implements Image{
    private final String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFile(fileName);
    }

    @Override
    public void display() {
        log.info("{}", this.fileName);
    }

    private void loadFile(String fileName){
        log.info("{}正在加载。。。", fileName);
    }
}
