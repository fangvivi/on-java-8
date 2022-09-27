package com.wayne.concurrent.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * 多个线程在执行过程中，因为争夺资源而造成的的互相等待的现象
 * 原因：
 *  1、系统资源不足
 *  2、加锁的顺序不合适
 *  3、资源分配不当
 * 分析：
 *   1、jps
 *   2、jstack -l
 * @author wayne
 */
@Slf4j
public class DeadLock {
    static Object a = new Object();
    static Object b = new Object();
    public static void main(String[] args) {

        new Thread(()->{
            synchronized (a){
                log.info("Thread:{}，持有锁a，试图获取锁b", Thread.currentThread().getName());
                /*try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
                synchronized (b){
                    log.info("Thread:{}，持有了锁b", Thread.currentThread().getName());
                }
            }
        },"t1").start();


        new Thread(()->{
            synchronized (b){
                log.info("Thread:{}，持有锁b，试图获取锁a", Thread.currentThread().getName());
                /*try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
                synchronized (a){
                    log.info("Thread:{}，持有了锁a", Thread.currentThread().getName());
                }
            }
        },"t2").start();
    }
}


