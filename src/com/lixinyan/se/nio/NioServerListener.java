package com.lixinyan.se.nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * Created by administrator on 2016/5/27.
 *
 */
public class NioServerListener extends Thread {

    protected Selector selector;
    protected SocketChannel socketChannel;

    public NioServerListener(Selector selector) {
        this.selector = selector;
    }

    @Override
    public void run() {
        try {
            //while循环监听事件
            while (true) {
                //阻塞，置到某个注册的通道有事件就绪
                selector.select();
                //获取选择器中已经就绪的SelectionKey集合
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    iterator.remove();
                    //接受连接就绪事件
                    if (key.isAcceptable()) {
                        ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
                        socketChannel = serverSocketChannel.accept();
                        //套接字通道设置为非阻塞模式
                        socketChannel.configureBlocking(false);
                        //向socket通道 注册读就绪事件
                        socketChannel.register(selector, SelectionKey.OP_READ);
                    } else if (key.isReadable()) {
                        ByteBuffer byteBuffer = ByteBuffer.allocate(100);
                        int len = socketChannel.read(byteBuffer);
                        byteBuffer.flip();
                        //读取完毕
                if(byteBuffer.limit() > 0){
                    System.out.println("来自服务端消息:" + new String(byteBuffer.array()).trim());
                }
            }
        }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        //打开一个 ServerSocketChannel实例 并设置为false
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        //绑定ip + 端口
        serverSocketChannel.socket().bind(new InetSocketAddress("127.0.0.1", 1024));
        //打开一个选择器
        Selector selector = Selector.open();
        //向 serverSocketChannel 注册 接收就绪事件
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        //开启线程进行监听
        NioServerListener nioServerListener = new NioServerListener(selector);
        nioServerListener.start();
        //进行控制台输入 写事件 进行通讯
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            //java IO 阻塞读取数据
            String data = bufferedReader.readLine();
            if ("exit".equals(data)) {
                if (null != nioServerListener.socketChannel) {
                    nioServerListener.socketChannel.close();
                }
                System.out.println("主线程关闭.....");
                System.exit(0);
            }
            ByteBuffer buffer = ByteBuffer.wrap(data.getBytes());
            nioServerListener.socketChannel.write(buffer);
        }
    }
}
