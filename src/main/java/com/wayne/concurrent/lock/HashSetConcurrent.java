package com.wayne.concurrent.lock;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Set 多线程安全问题
 * @author wayne
 */
public class HashSetConcurrent {
    public static void main(String[] args) {
        Set<String> hashSet = new HashSet<>();
        for (int i = 0; i < 30; i++) {
            // HashSet在多线程环境下,被修改时访问会出现 ConcurrentModificationException
            new Thread(()->{
                hashSet.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(hashSet);
            },String.valueOf(i)).start();
        }
    }

    /**
     * 使用 CopyOnWriteArraySet
     */
    public static void resolve(){
        Set<String> set = new CopyOnWriteArraySet<>();
        for (int i = 0; i < 30; i++) {
            new Thread(()->{
                set.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(set);
            },String.valueOf(i)).start();
        }
    }
}
