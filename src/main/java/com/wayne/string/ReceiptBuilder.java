package com.wayne.string;

import java.util.Formatter;

/**
 * @author wayne
 */
public class ReceiptBuilder {
    private double total = 0;
    private Formatter f = new Formatter(new StringBuilder());

    public ReceiptBuilder(){
        f.format("%-15s %5s %10s%n", "Item","Qty","Price");
        f.format("%-15s %5s %10s%n","----","---","-----");
    }
    public void add(String name, int quantity, double price){
        f.format("%-15.6s %5d %10.2f%n",name, quantity, price);
        total += quantity * price;
    }

    public String build(){
        f.format("%-15s %5s %10.2f%n","Tax", "", total*0.06);
        f.format("%-15s %5s %10s%n","","","-----");
        f.format("%-15s %5s %10.2f%n","Total", "", total*1.06);
        return f.toString();
    }

    public static void main(String[] args) {
        ReceiptBuilder receiptBuilder = new ReceiptBuilder();
        receiptBuilder.add("张三",5,4.0);
        receiptBuilder.add("李四",1,3.0);
        receiptBuilder.add("王五",3,3.3);
        System.out.println(receiptBuilder.build());
    }
}
