package com.wayne.gc;

import java.lang.ref.SoftReference;

/**
 * 把最大堆内存设置为20m
 * -Xmx20m
 * @author wayne
 * @date 2023-03-02 22:26
 */
public class SoftReferenceDemo {
    public static void main(String[] args) {
        // 创建一个占内存10m的软引用对象
        SoftReference<byte[]> softReference = new SoftReference<>(new byte[1024 * 1024 * 10]);
        System.out.println(softReference.get());
        System.gc();
        System.out.println(softReference.get());
        // 再创建一个10m的对象把堆填满触发GC
        final byte[] bytes = new byte[1024 * 1024 * 10];
        // 看一下软引用对象是否还在
        System.out.println(softReference.get());
    }
}
