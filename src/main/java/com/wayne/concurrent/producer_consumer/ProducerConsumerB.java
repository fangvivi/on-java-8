package com.wayne.concurrent.producer_consumer;

import lombok.extern.slf4j.Slf4j;

/**
 * @author wayne
 */
public class ProducerConsumerB {
    public static void main(String[] args) {
        NumberFactoryB numberFactory = new NumberFactoryB();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                numberFactory.create();
            }
        }, "producer").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                numberFactory.consume();
            }
        }, "consumer").start();
    }
}

@Slf4j
class NumberFactoryB {
    private int i = 0;
    /**
     * true：产品已生产完，待消费的状态
     * false：产品被消费完，需要补充
     */
    private boolean created = false;

    public synchronized void create() {
        // 待消费的状态不需要生产，所以生产者需要阻塞
        while (created) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        log.info("created i:{}", ++i);
        created = true;
        // 通知消费者消费数据
        notify();
    }

    public synchronized void consume() {
        // created:false，表示产品需要补充，所以消费者需要阻塞，等待生产者通知
        while (!created) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        log.info("consumed i:{}", i);
        created = false;
        // 通知生产者生产数据
        notify();
    }
}
