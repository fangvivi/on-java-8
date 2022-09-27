package com.wayne.concurrent.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用 ReentrantLock 实现卖票逻辑
 * @author wayne
 */
public class SaleTicketLock {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(()->{
            for (int i = 0; i < 30; i++) {
                ticket.sale();
            }
        },"t1").start();

        new Thread(()->{
            for (int i = 0; i < 30; i++) {
                ticket.sale();
            }
        },"t2").start();

        new Thread(()->{
            for (int i = 0; i < 30; i++) {
                ticket.sale();
            }
        },"t3").start();
    }
}

@Slf4j
class Ticket{
    private int amount = 30;
    /**创建一个公平的可重入锁*/
    private final ReentrantLock reentrantLock = new ReentrantLock();
    public void sale(){
        reentrantLock.lock();
        try {
            if(amount > 0){
                log.info("线程{}卖出1张票，剩余{}张票", Thread.currentThread().getName(),  --amount);
            }
        } finally {
            reentrantLock.unlock();
        }

    }
}