package com.wayne.gc;

import java.lang.ref.WeakReference;

/**
 *
 * @author wayne
 * @date 2023-03-02 22:26
 */
public class WeakReferenceDemo {
    public static void main(String[] args) {
        // 弱引用对象不管内存是否充足，下次垃圾回收的时候都会被回收
        WeakReference<byte[]> weakReference = new WeakReference<>(new byte[1]);
        System.out.println(weakReference.get());
        System.gc();
        System.out.println(weakReference.get());
    }
}
