package com.wayne.concurrent.juc;

import lombok.extern.slf4j.Slf4j;

/**
 * @author wayne
 */
@Slf4j
public class JoinDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            log.info("t1线程运行");
        },"t1");

        Thread t2 = new Thread(()->{
            log.info("t2线程运行");
        },"t2");
        t1.start();
        t2.start();
        // 使用 join 通知其他线程
        t1.join();
        t2.join();
        // main 线程会等t1、t2线程执行完才会继续执行
        log.info("main线程执行完成");
    }
}
