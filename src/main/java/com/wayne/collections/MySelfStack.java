package com.wayne.collections;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Java 6 添加了 ArrayDeque ，其中包含直接实现堆栈功能，非线程安全
 * 作为栈使用的时候比 Stack 快，作为队列使用的时候比 LinkedList 快
 * 使用 ArrayDeque 创造一个stack
 * @author wayne
 */
public class MySelfStack<E> {
    private final Deque<E> storage = new ArrayDeque<>();

    /**
     * 元素入栈
     * @param e 需要入栈的元素
     */
    public void push(E e){
        storage.push(e);
    }

    /**
     * 返回并删除栈顶元素
     * @return 栈顶元素
     */
    public E pop(){
        return storage.pop();
    }

    /**
     * 返回栈顶元素，但不删除
     * @return 栈顶元素
     */
    public E peek(){
        return storage.peek();
    }

    /**
     * 判断栈是否为空
     * @return true - 如果栈为空
     */
    public boolean isEmpty(){
        return storage.isEmpty();
    }

    @Override
    public String toString(){
        return storage.toString();
    }
}
