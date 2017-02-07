package com.lixinyan.se.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by administrator on 2016/5/27.‘
 *
 */
public class BoundedBuffer {

    public final Lock lock = new ReentrantLock(); //锁对象
    public final Condition write = lock.newCondition();//写线程条件
    public final Condition read = lock.newCondition();//读线程条件

    public final Object[] items = new Object[100]; //用数组做缓存队列

    private int putptr;//写索引
    private int takeptr;//读索引
    private int count;//队列中数组个数

    public void put(Object x) throws InterruptedException {
        lock.lock();
        try {
            while (count == items.length) { //如果队列满了
                write.await(); //阻塞写线程
            }
            items[putptr] = x;
            if (++putptr == items.length) { //如果写所有到了队列最后一个位置了那么置为0
                putptr = 0;
            }
            ++count;
            read.signal();//唤醒读线程
        } finally {
            lock.unlock();
        }
    }

    public Object take() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0)//如果队列为空
                read.await();//阻塞读线程
            Object x = items[takeptr];//取值
            if (++takeptr == items.length) takeptr = 0;//如果读索引读到队列的最后一个位置了，那么置为0
            --count;//个数--
            write.signal();//唤醒写线程
            return x;
        } finally {
            lock.unlock();
        }
    }

    /**
     * 这是一个处于多线程工作环境下的缓存区，缓存区提供了两个方法，put和take，put是存数据，take是取数据，
     * 内部有个缓存队列，具体变量和方法说明见代码，这个缓存区类实现的功能：有多个线程往里面存数据和从里面取数据，
     * 其缓存队列(先进先出后进后出)能缓存的最大数值是100，多个线程间是互斥的，
     * 当缓存队列中存储的值达到100时，将写线程阻塞，并唤醒读线程，当缓存队列中存储的值为0时，
     * 将读线程阻塞，并唤醒写线程，下面分析一下代码的执行过程：

     一个写线程执行，调用put方法；
     判断count是否为100，显然没有100；
     继续执行，存入值；
     判断当前写入的索引位置++后，是否和100相等，相等将写入索引值变为0，并将count+1；
     仅唤醒读线程阻塞队列中的一个；
     一个读线程执行，调用take方法；
     ……
     仅唤醒写线程阻塞队列中的一个。
     这样由于阻塞该阻塞的，唤醒该唤醒的，阻塞该阻塞的，所以能提高效率。
     */
}
