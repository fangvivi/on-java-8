package com.wayne.string;

/**
 * @author wayne
 */
public class SimpleFormat {
    public static void main(String[] args) {
        int x = 5;
        double y = 5.32323;
        // 之前的方式
        System.out.println("Row 1 [" + x + " " + y +"]");
        // 新的写法
        System.out.printf("Row 1 [%d %f]%n", x, y);
        // 这种也可以
        System.out.format("Row 1 [%d %f]%n", x, y);

        System.out.printf("%h%n",'A');
    }
}
