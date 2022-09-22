package com.wayne.concurrentcy.sync;

import lombok.extern.slf4j.Slf4j;

/**
 * 使用 synchronized 实现买票逻辑
 * @author wayne
 */
@Slf4j
public class SaleTicketSynchronized {
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
    public synchronized void sale(){
        if(amount > 0){
            log.info("线程{}卖出1张票，剩余{}张票", Thread.currentThread().getName(),  --amount);
        }
    }
}
