package com.wayne.concurrent.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用 lock 实现线程间通讯
 * @author wayne
 */
public class ThreadCommunicateLock {
    public static void main(String[] args) {
        Share share = new Share();
        // 第三步：创建多个线程，调用共享资源的操作方法
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                share.incr();
            }
        },"aa").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                share.decr();
            }
        },"bb").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                share.incr();
            }
        },"cc").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                share.decr();
            }
        },"dd").start();
    }
}

/**
 * 第一步：定义多线程共享的资源
 */
@Slf4j
class Share {
    private int num = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    /**第二步，操作方法*/
    public void incr(){
        // 加锁
        lock.lock();
        try {
            // 判断
            while (num != 0){
                condition.await();
            }
            // 干活
            num++;
            log.info("Thread name:{}, num:{}", Thread.currentThread().getName(), num);
            // 通知
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 解锁
            lock.unlock();
        }
    }

    public void decr(){
        lock.lock();
        try {
            while (num != 1){
                condition.await();
            }
            num--;
            log.info("Thread name:{}, num:{}", Thread.currentThread().getName(), num);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
