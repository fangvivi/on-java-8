package com.wayne.io.channel;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author wayne
 */
@Slf4j
public class FileChannelReadDemo {
    public static void main(String[] args) throws IOException {
        // 创建channel
        RandomAccessFile raf = new RandomAccessFile("src/main/resources/a.txt","rw");
        final FileChannel channel = raf.getChannel();
        // 创建buffer
        ByteBuffer buffer = ByteBuffer.allocate(20);
        // 读取数据到buffer中
        int readBytes = channel.read(buffer);
        while (readBytes != -1){
            log.info("读取了【{}】个字节", readBytes);
            // 翻转读写模式，可以理解成把入口转换成出口
            buffer.flip();
            while (buffer.hasRemaining()){
                // 从buffer中取出一个字节
                final char c = (char)buffer.get();
                log.info("【{}】", c);
            }
            buffer.clear();
            readBytes = channel.read(buffer);
        }
        raf.close();
        log.info("结束");


    }
}
