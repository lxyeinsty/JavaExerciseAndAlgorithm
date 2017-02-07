package com.lixinyan.se.thread;

import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by Administrator on 2016/12/10.
 *
 */
public class Lockers {
    public static class LockTest {
        Lock lock = new ReentrantLock();
        double value = 0d;
        int addTimes = 0;

        /**
         * 增加value的值，该方法的操作分为2步，而且相互依赖，必须实现在一个事务中
         * 所以该方法必须同步，以前的做法是在方法声明中使用Synchronized关键字。
         */
        public void addValue(double v) {
            lock.lock();
            System.out.print("LockTest to addValue: " + v + "   "  + System.currentTimeMillis());

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {

            }

            this.value += v;
            this.addTimes++;
            lock.unlock();
        }

        public double getValue() {
            return this.value;
        }
        }

    public static void testLockTest() throws Exception {
        final LockTest lockTest = new LockTest();
        //新建任务1，调用locktest的的Value方法
        Runnable task1 = new Runnable() {
            @Override
            public void run() {
                lockTest.addValue(1);
            }
        };

        //新建任务2，调用lockTest的getvalye方法
        Runnable task2 = new Runnable() {
            @Override
            public void run() {
                System.out.print("value" + lockTest.getValue());
            }
        };

        //新建任务执行服务
        ExecutorService cachedServices = Executors.newCachedThreadPool();
        Future future = null;
        //同时执行任务1三次，由于addValue方法使用了锁机制，所以实质上回顺序执行
        for (int i = 0; i < 10; i++) {
            future = cachedServices.submit(task1);
        }
        //等待最后一个任务1被执行完成
        future.get();
        //在执行任务2，输出结果
        future =   cachedServices.submit(task2);
        //等待任务2执行完成后，关闭执行服务
        future.get();
        cachedServices.shutdownNow();
    }

    /**
     * ReadWriteLock内置两个lock，一个是读lock，一个是写lock
     * 多线程同时可以执行多个读lock，但是一个线程只能得到一个write Lock
     * 而且写的lock被锁定后，任何线程多不能得到lock，ReadWriteLock提供的方法有：
     * readLock(): 返回一个读的lock
     * writeLocal(): 返回一个写的lock，此lock是排它锁
     */
    public static class ReadWriteLockTest {
        // 锁
        ReadWriteLock lock = new ReentrantReadWriteLock();
        // 值
        double value = 0d;
        int addtimes = 0;

        /**
         * 增加value的值，不允许多个线程同时进入该方法
         */
        public void addValue(double v) {
            // 得到writeLock并锁定
            Lock writeLock = lock.writeLock();
            writeLock.lock();
            System.out.println("ReadWriteLockTest to addValue: " + v + "   "
                    + System.currentTimeMillis());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            try {
                // 做写的工作
                this.value += v;
                this.addtimes++;
            } finally {
                // 释放writeLock锁
                writeLock.unlock();
            }
        }

        /**
         * 获得信息。当有线程在调用addValue方法时，getInfo得到的信息可能是不正确的。
         * 所以，也必须保证该方法在被调用时，没有方法在调用addValue方法。
         */
        public String getInfo() {
            // 得到readLock并锁定
            Lock readLock = lock.readLock();
            readLock.lock();
            System.out.println("ReadWriteLockTest to getInfo   "
                    + System.currentTimeMillis());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            try {
                // 做读的工作
                return this.value + " : " + this.addtimes;
            } finally {
                // 释放readLock
                readLock.unlock();
            }
        }
    }
    }

