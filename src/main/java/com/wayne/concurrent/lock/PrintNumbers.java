package com.wayne.concurrent.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用三个线程按照顺序分别打印1~5、1~10、1~15
 * @author wayne
 */
public class PrintNumbers {
    public static void main(String[] args) {
        ShareResources shareResources = new ShareResources();
        for (int i = 1; i <= 10; i++) {
            int num = i;
            new Thread(()->{
                shareResources.print5(num);
            },"AA").start();

            new Thread(()->{
                shareResources.print10(num);
            },"BB").start();

            new Thread(()->{
                shareResources.print15(num);
            },"CC").start();

        }
    }
}

@Slf4j
class ShareResources{
    /**
     * 1:AA 2:BB 3:CC
     */
    private int flag = 1;

    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();

    public void print5(int loop){
        lock.lock();
        try {
            while (flag != 1){
                c1.await();
            }
            for (int i = 1; i <= 5; i++) {
                log.info("Thread name:{}, num:{}, loop:{}",Thread.currentThread().getName(), i, loop);
            }
            flag = 2;
            c2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print10(int loop){
        lock.lock();
        try {
            while (flag != 2){
                c1.await();
            }
            for (int i = 1; i <= 10; i++) {
                log.info("Thread name:{}, num:{}, loop:{}",Thread.currentThread().getName(), i, loop);
            }
            flag = 3;
            c3.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print15(int loop){
        lock.lock();
        try {
            while (flag != 3){
                c1.await();
            }
            for (int i = 1; i <= 15; i++) {
                log.info("Thread name:{}, num:{}, loop:{}",Thread.currentThread().getName(), i, loop);
            }
            flag = 1;
            c1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
