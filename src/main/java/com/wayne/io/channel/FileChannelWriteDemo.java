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
public class FileChannelWriteDemo {
    public static void main(String[] args) throws IOException {
        // 获取channel
        RandomAccessFile raf = new RandomAccessFile("src/main/resources/b.txt","rw");
        final FileChannel channel = raf.getChannel();
        // 创建buffer
        final ByteBuffer buffer = ByteBuffer.allocate(1024);
        String data = "白日依山尽";
        final byte[] bytes = data.getBytes();
        buffer.clear();
        // 写入内容
        buffer.put(bytes);
        buffer.flip();
        while (buffer.hasRemaining()){
            channel.write(buffer);
        }
        log.info("数据写入完成");
        // 关闭通道
        channel.close();
    }
}
