package com.wayne.concurrentcy.sync;

import lombok.extern.slf4j.Slf4j;

/**
 * 线程通讯
 * @author wayne
 */
public class ThreadCommunicate {
    public static void main(String[] args) {
        Share share = new Share();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    share.incr();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t1").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    share.decr();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t2").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    share.incr();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t3").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    share.decr();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t4").start();
    }
}
@Slf4j
class Share {
    private int val = 0;
    public synchronized void incr() throws InterruptedException {
        while(val != 0){
            this.wait();
        }
        val++;
        log.info("Thread name:{}, val:{}", Thread.currentThread().getName(), val);
        this.notifyAll();
    }

    public synchronized void decr() throws InterruptedException {
        while(val != 1){
            this.wait();
        }
        val--;
        log.info("Thread name:{}, val:{}", Thread.currentThread().getName(), val);
        this.notifyAll();
    }
}