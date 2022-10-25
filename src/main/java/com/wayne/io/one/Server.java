package com.wayne.io.one;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author wayne
 * @date 2022-10-25 21:27
 */
@Slf4j
public class Server {
    public static void main(String[] args) {
      log.info("===服务端启动===");
        // 定义一个ServerSock对象进行服务端注册
        try (ServerSocket ss = new ServerSocket(9999)){
            // 监听客户端的请求
            final Socket sock = ss.accept();
            final InputStream is = sock.getInputStream();
            BufferedReader br
                    = new BufferedReader(new InputStreamReader(is));

            String msg;
            if ((msg = br.readLine()) != null){
                log.info("服务端收到【{}】", msg);
            }
        } catch (IOException e) {
            log.error("异常信息【{}】",e.getMessage(), e);
        }
    }
}
