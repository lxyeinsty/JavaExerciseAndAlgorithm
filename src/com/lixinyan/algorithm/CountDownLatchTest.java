package com.lixinyan.algorithm;

import java.util.concurrent.CountDownLatch;

/**
 * Created by lxy on 2017/11/28.
 *
 */
public class CountDownLatchTest {

    public long timeTask(int threads, final Runnable task) {
        final CountDownLatch startGate = new CountDownLatch(1);
        final CountDownLatch endGate = new CountDownLatch(threads);

        for (int i = 0; i < threads; i++) {
            Thread thread = new Thread() {
                @Override
                public void run() {
                    try {
                        startGate.await();
                        try {
                            task.run();
                        } finally {
                            endGate.countDown();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };

            thread.start();
        }

        long start = System.nanoTime();
        startGate.countDown();
        long end = System.nanoTime();
        return end - start;
    }
}
