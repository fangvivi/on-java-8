package com.wayne.io.two;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author wayne
 * @date 2022-10-25 21:39
 */
@Slf4j
public class Client {
    public static void main(String[] args) {
        try (final Socket socket = new Socket("127.0.0.1", 9999)){
            OutputStream os = socket.getOutputStream();
            PrintStream ps = new PrintStream(os);
            Scanner sc = new Scanner(System.in);
            while (true){
                System.out.print("请输入聊天信息：");
                final String content = sc.nextLine();
                ps.println(content);
                ps.flush();
            }
        } catch (IOException e) {
            log.error("异常信息【{}】",e.getMessage(), e);
        }
    }
}
