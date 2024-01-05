package com.wayne.concurrent.juc;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;

/**
 * @author wayne
 */
@Slf4j
public class CountDownLatchDemo {
    public static void main(String[] args) {
        CountDownLatch count = new CountDownLatch(6);
        for (int i = 1; i <= 6; i++) {
            final int name = i;
            new Thread(()->{
                log.info("第几个{}同学出门了", name);
                count.countDown();
            },String.valueOf(i)).start();
        }

        try {
            count.await();
            log.info("班长锁门了");
        } catch (InterruptedException e) {
            log.error("{}", e.getMessage(), e);
        }
    }
}
