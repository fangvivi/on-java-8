package com.wayne.concurrent.lock;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * list 多线程安全问题
 * @author wayne
 */
public class ListConcurrent {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            // ArrayList在多线程环境下,被修改时访问会出现 ConcurrentModificationException
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            },String.valueOf(i)).start();
        }
    }

    /**
     * 方法一：使用Vector，Vector是线程安全的集合
     */
    public static void resolveA(){
        List<String> vector = new Vector<>();
        for (int i = 0; i < 30; i++) {
            // Arraylist在多线程环境下,被修改时访问会出现并发修改异常
            new Thread(()->{
                vector.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(vector);
            },String.valueOf(i)).start();
        }
    }

    /**
     * 方法二：使用 Collections.synchronizedList()方法
     */
    public static void resolveB(){
        List<String> list = Collections.synchronizedList(new ArrayList<>());
        for (int i = 0; i < 30; i++) {
            // Arraylist在多线程环境下,被修改时访问会出现并发修改异常
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            },String.valueOf(i)).start();
        }
    }

    /**
     * 方法三：使用 CopyOnWriteArrayList
     */
    public static void resolveC(){
        List<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 30; i++) {
            // Arraylist在多线程环境下,被修改时访问会出现并发修改异常
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            },String.valueOf(i)).start();
        }

    }
}
