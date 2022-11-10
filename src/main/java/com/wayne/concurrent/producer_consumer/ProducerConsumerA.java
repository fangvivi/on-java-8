package com.wayne.concurrent.producer_consumer;

import lombok.extern.slf4j.Slf4j;

/**
 * 最简陋的生产者-消费者示例，生产者和消费者之间没有通信，工作能力不平衡
 * 如果消费者比生产者先启动，就会出现问题
 * @author wayne
 */
@Slf4j
public class ProducerConsumerA {

    public static void main(String[] args) {
        NumberFactoryA numberFactory = new NumberFactoryA();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                numberFactory.create();
            }
        },"producer").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                numberFactory.consume();
            }
        },"consumer").start();
    }
}

@Slf4j
class NumberFactoryA {
    private int i = 0;
    private final Object lock = new Object();

    public void create(){
        synchronized (lock){
            log.info("created i:{}",++i);
        }
    }

    public void consume(){
        synchronized (lock){
            log.info("consumed i:{}",i);
        }
    }

}
