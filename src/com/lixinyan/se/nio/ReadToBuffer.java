package com.lixinyan.se.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by administrator on 2016/4/20.
 *
 */
public class ReadToBuffer {
    public static void main(String[] args) {
        try {
            RandomAccessFile aFile = new RandomAccessFile("data/nio-data.txt", "rw");
            FileChannel inChannel = aFile.getChannel();

            ByteBuffer byteBuffer = ByteBuffer.allocate(48);
            int bytesRead = inChannel.read(byteBuffer);
            while (bytesRead != -1) {
                System.out.println("Read " + bytesRead);
                byteBuffer.flip();

                while(byteBuffer.hasRemaining()){
                    System.out.print((char) byteBuffer.get());
                }

                byteBuffer.clear();
                bytesRead = inChannel.read(byteBuffer);
            }

            aFile.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
