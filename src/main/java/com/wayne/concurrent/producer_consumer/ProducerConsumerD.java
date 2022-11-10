package com.wayne.concurrent.producer_consumer;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;

/**
 * @author wayne
 */
public class ProducerConsumerD {
    public static void main(String[] args) {
        Queue<Product> queue = new ArrayDeque<>();
        for (int i = 0; i < 100; i++) {
            new Thread(new ProducerD(10,queue)).start();
            new Thread(new ConsumerD(10,queue)).start();
        }
    }
}
@Slf4j
class ProducerD implements Runnable{
    private final Queue<Product> queue;
    private final int maxCapacity;
    public ProducerD(int maxCapacity, Queue<Product> queue){
        this.queue = queue;
        this.maxCapacity = maxCapacity;
    }
    @Override
    public void run() {
        synchronized (queue){
            while (queue.size()==maxCapacity){
                try {
                    log.info("队列已满，生产者{}进入等待状态", Thread.currentThread().getName());
                    queue.wait();
                    log.info("生产者{}退出等待状态", Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            int name = new Random().nextInt(101);
            queue.offer(new Product("艺术品-"+name));
            queue.notifyAll();
            log.info("生产者{}生产了{}", Thread.currentThread().getName(), "艺术品"+name);
        }
    }
}

@Slf4j
class ConsumerD implements Runnable{
    private final Queue<Product> queue;
    private final int maxCapacity;
    public ConsumerD(int maxCapacity, Queue<Product> queue){
        this.queue = queue;
        this.maxCapacity = maxCapacity;
    }
    @Override
    public void run() {
        synchronized (queue){
            while (queue.isEmpty()){
                try {
                    log.info("队列已空，消费者{}进入等待状态", Thread.currentThread().getName());
                    queue.wait();
                    log.info("消费者{}退出等待状态", Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            queue.notifyAll();
            final Product poll = queue.poll();
            log.info("消费者{}消费了{}", Thread.currentThread().getName(), poll);
        }
    }
}


class Product {
    private final String name;
    Product(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                '}';
    }
}
