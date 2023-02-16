package com.wayne.lambda;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

/**
 * 本质是接口的一个实例
 * Lambda表达式的使用
 * 举例：(o1, o2) -> Integer.compare(o1, o2)
 * 格式：
 *      -> : lambda操作符
 *      (o1, o2) : lambda的参数列表（接口的参数列表）
 *      Integer.compare(o1, o2) : 重写抽象方法的方法体
 *
 * @author wayne
 * @date 2022-12-01 22:14
 */
@Slf4j
public class LambdaTest {

    @Test
    public void test1(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                log.info("这是java8之前的写法");
            }
        }).start();

        log.info("***********************");

        Runnable r = () -> log.info("这是java8的写法");
        Thread t2 = new Thread(r);
        t2.start();

        log.info("***********************");

        new Thread(() -> log.info("这是java8的写法")).start();
    }


    @Test
    public void test2(){
        Comparator<Integer> c1 = new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };
        int result = c1.compare(12, 13);
        log.info("{}", result);

        log.info("***********************");

        Comparator<Integer> c2 = (o1, o2) -> Integer.compare(o1, o2);
        result = c2.compare(12, 13);
        log.info("{}", result);

        log.info("***********************");
        // 方法引用
        Comparator<Integer> c3 = Integer::compare;
        result = c3.compare(12, 13);
        log.info("{}", result);
    }
}
