package com.wayne.concurrent.sync;

import lombok.extern.slf4j.Slf4j;

/**
 * 使用 synchronized 实现线程通讯
 * @author wayne
 */
public class ThreadCommunicateSync {
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
        // 此处存在虚假唤醒的问题，所以需要用循环
        // wait 被唤醒会继续执行，如果不重新判断条件就可能出现问题
        while(val != 0){
            this.wait();
        }
        val++;
        log.info("Thread name:{}, val:{}", Thread.currentThread().getName(), val);
        this.notifyAll();
    }

    public synchronized void decr() throws InterruptedException {
        // 判断
        while(val != 1){
            this.wait();
        }
        // 干活
        val--;
        log.info("Thread name:{}, val:{}", Thread.currentThread().getName(), val);
        // 通知
        this.notifyAll();
    }
}