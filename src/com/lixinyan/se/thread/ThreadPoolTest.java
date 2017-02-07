package com.lixinyan.se.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by administrator on 2016/5/8.
 *
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 200,
                TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(5));
        for (int i = 0; i < 15; i++) {
            MyTask mytask = new MyTask(i);
            threadPoolExecutor.execute(mytask);
            System.out.println("线程池中线程的数目：" + threadPoolExecutor.getPoolSize() +
            "，队列中等待执行的任务数目：" + threadPoolExecutor.getQueue().size() +
            "，已经执行完的任务书：" + threadPoolExecutor.getCompletedTaskCount());
        }

        threadPoolExecutor.shutdown();
    }
}

