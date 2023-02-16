package com.wayne.lambda;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * 本质是函数式接口的一个实例
 * Lambda表达式的使用
 * 举例：(o1, o2) -> Integer.compare(o1, o2)
 * 格式：
 *      -> : lambda操作符
 *      (o1, o2) : lambda的参数列表（接口的参数列表）
 *      Integer.compare(o1, o2) : 重写抽象方法的方法体
 * 总结：
 *      1、参数类型可以省略，如果只有一个参数，参数小括号可以省略
 *      2、如果lambda体只有一条语句，大括号可以省略，有返回值 return关键字可以省略
 * @author wayne
 * @date 2022-12-01 22:14
 */
@Slf4j
public class LambdaSyntax {

    /**
     * 语法格式一，没有参数，没有返回值
     */
    @Test
    public void test1(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                log.info("这是java8之前的写法");
            }
        }).start();

        Runnable r = () -> log.info("这是java8的写法");
        Thread t2 = new Thread(r);
        t2.start();
    }

    /**
     * 语法格式二，有参数，没有返回值
     */
    @Test
    public void test2(){
        Consumer<String> c1 = new Consumer<String>() {
            @Override
            public void accept(String s) {
                log.info("{}",s);
            }
        };
        c1.accept("消费者");

        Consumer<String> c2 = (String s) -> log.info("{}",s);
        c2.accept("消费者");


    }

    /**
     * 语法格式三，参数的数据类型可以省略，由“类型维护”推断
     */
    @Test
    public void test3(){
        Consumer<String> c1 = new Consumer<String>() {
            @Override
            public void accept(String s) {
                log.info("{}",s);
            }
        };
        c1.accept("消费者");

        Consumer<String> c2 = (s) -> log.info("{}", s);
        c2.accept("消费者");
    }

    /**
     *  语法格式四，如果只有一个参数，小括号可以省略
     */
    @Test
    public void test4(){
        Consumer<String> c2 = (s) -> log.info("{}", s);
        c2.accept("消费者");

        Consumer<String> c3 = s -> log.info("{}", s);
        c3.accept("消费者");
    }



    /**
     * 语法格式五，有两个或以上参数，执行多条语句，有返回值
     */
    @Test
    public void test5(){
        Comparator<Integer> c1 = new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                log.info("o1【{}】", o1);
                log.info("o2【{}】", o2);
                return o1.compareTo(o2);
            }
        };
        int result = c1.compare(12, 13);
        log.info("{}", result);


        Comparator<Integer> c2 = (o1, o2) -> {
            log.info("o1【{}】", o1);
            log.info("o2【{}】", o2);
            return o1.compareTo(o2);};

        result = c2.compare(12, 13);
        log.info("{}", result);
    }

    /**
     * 语法格式六，如果lambda体只有一条语句且有返回值，括号 和 return可以省略
     */
    @Test
    public void test6(){
        Comparator<Integer> c1 = new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };
        int result = c1.compare(12, 13);
        log.info("{}", result);

        Comparator<Integer> c2 = (o1, o2) -> o1.compareTo(o2);
        result = c2.compare(12, 13);
        log.info("{}", result);
    }
}
