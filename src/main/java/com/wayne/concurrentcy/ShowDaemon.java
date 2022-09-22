package com.wayne.concurrentcy;

import lombok.extern.slf4j.Slf4j;

/**
 * @author wayne
 */
@Slf4j
public class ShowDaemon {
    public static void main(String[] args) {
      Thread t = new Thread(()->{
          log.info("thread name:{}", Thread.currentThread().getName());
          while (true){

          }
      },"t1");
      // 如果t不是守护线程，主线程运行结束之后这个程序也不会结束
      t.setDaemon(true);
      t.start();

      log.info("{} over", Thread.currentThread().getName());
    }
}
