package com.wayne.concurrent.producer_consumer;

import lombok.extern.slf4j.Slf4j;

/**
 * 多个生产者消费者
 * @author wayne
 */
public class ProducerConsumerC {
    public static void main(String[] args) {
        NumberFactoryC numberFactory = new NumberFactoryC();
        for (int i = 0; i < 20; i++) {
            new Thread(new Producer(numberFactory)).start();
            new Thread(new Consumer(numberFactory)).start();
        }
    }
}

class Producer implements Runnable{
    private NumberFactoryC numberFactory;
    public Producer(NumberFactoryC numberFactory){
        this.numberFactory = numberFactory;
    }
    @Override
    public void run() {
        numberFactory.create();
    }
}

class Consumer implements Runnable{
    private NumberFactoryC numberFactory;
    public Consumer(NumberFactoryC numberFactory){
        this.numberFactory = numberFactory;
    }
    @Override
    public void run() {
        numberFactory.consume();
    }
}

@Slf4j
class NumberFactoryC {
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
        log.info("{} created i:{}", Thread.currentThread().getName(), ++i);
        created = true;
        // 通知消费者消费数据
        notifyAll();
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
        log.info("{} consumed i:{}", Thread.currentThread().getName(), i);
        created = false;
        // 通知生产者生产数据
        notifyAll();
    }
}
