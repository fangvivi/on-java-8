package com.wayne.io.three;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author wayne
 */
@Slf4j
public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("127.0.0.1", 9999);
             final OutputStream os = socket.getOutputStream();
             PrintStream ps = new PrintStream(os)) {
            Scanner sc = new Scanner(System.in);
            while (true) {
                System.out.print("请输入消息：");
                final String msg = sc.nextLine();
                ps.println(msg);
                ps.flush();
            }
        } catch (IOException e) {
            log.error("异常信息【{}】", e.getMessage(), e);
        }
    }
}
