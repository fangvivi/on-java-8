package com.wayne.io.three;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.net.Socket;

/**
 * @author wayne
 */
@Slf4j
public class ServerThreadReader extends Thread{
    private final Socket socket;

    public ServerThreadReader(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (final InputStream is = socket.getInputStream();
             BufferedReader br = new BufferedReader(new InputStreamReader(is))){
            String msg;
            while ((msg=br.readLine())!= null){
                log.info("收到信息【{}】", msg);
            }
        } catch (IOException e) {
            log.error("异常信息【{}】",e.getMessage(), e);
        }
    }
}
