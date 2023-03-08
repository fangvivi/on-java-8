package com.wayne.concurrent.pool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 自定义线程池
 * @author wayne
 * @date 2022-10-27 21:42
 */
@Slf4j
public class CustomThreadPoolDemo {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
                2,
                5,
                5L, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(1),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );

        try {
            for (int i = 0; i < 30; i++) {
                threadPool.execute(()->{
                    log.info("【{}】", Thread.currentThread().getName());
                });
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }


    }
}
