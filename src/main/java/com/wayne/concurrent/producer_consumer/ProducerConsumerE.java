package com.wayne.concurrent.producer_consumer;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author wayne
 */
public class ProducerConsumerE {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();
        for (int i = 0; i < 50; i++) {
            new Thread(new ProducerE(queue)).start();
            new Thread(new ConsumerE(queue)).start();
        }
    }
}

@Slf4j
class ProducerE implements Runnable{
    private BlockingQueue<Integer> queue;
    public ProducerE(BlockingQueue<Integer> queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        final int val = new Random().nextInt(30);
        log.info("生产者生产了{}",val);
        queue.offer(val);
    }
}

@Slf4j
class ConsumerE implements Runnable{
    private BlockingQueue<Integer> queue;
    public ConsumerE(BlockingQueue<Integer> queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        Integer val = queue.poll();
        log.info("消费者消费了{}",val);
    }
}
