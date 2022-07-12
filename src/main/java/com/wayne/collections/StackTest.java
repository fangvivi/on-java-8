package com.wayne.collections;

import lombok.extern.slf4j.Slf4j;


/**
 * @author wayne
 */
@Slf4j
public class StackTest {
    public static void main(String[] args) {
        MySelfStack<String> stack = new MySelfStack<>();
        String input = "hello world java";
        for (String str : input.split("\\s")) {
            stack.push(str);
        }
        while (!stack.isEmpty()){
            log.info("{}",stack.pop());
        }
    }

}
