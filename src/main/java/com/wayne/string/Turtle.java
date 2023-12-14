package com.wayne.string;

import java.util.Formatter;

/**
 * @author wayne
 */
public class Turtle {
    private final String name;
    private final Formatter f;

    public Turtle(String name, Formatter f) {
        this.name = name;
        this.f = f;
    }
    void move(int x, int y){
        f.format("%s的小乌龟目前的坐标（%d,%d）%n", this.name, x, y);
    }

    public static void main(String[] args) {
        Formatter formatter = new Formatter(System.out);
        Turtle t1 = new Turtle("张三", formatter);
        Turtle t2 = new Turtle("李四", formatter);
        t1.move(2,1);
        t2.move(4,2);
    }

}
