package com.wayne.io.three;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author wayne
 */
@Slf4j
public class Server {
    public static void main(String[] args) {
        try {
            log.info("===服务端启动===");
            ServerSocket ss = new ServerSocket(9999);
            while (true){
                final Socket socket = ss.accept();
                log.info("收到了一个连接建立请求！");
                new ServerThreadReader(socket).run();
            }
        } catch (IOException e) {
            log.error("异常信息【{}】",e.getMessage(), e);
        }
    }
}
