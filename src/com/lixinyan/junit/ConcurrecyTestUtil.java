package com.lixinyan.junit;

import org.junit.Assert;
import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by administrator on 2016/6/23.
 *
 */
public class ConcurrecyTestUtil {

    public static void assertConcurrent(final String message,
                                        final List<? extends Runnable> runnables,
                                        final int maxTimeSeconds,
                                        final int maxThreadPoolSize)
                                        throws InterruptedException {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start(message);

        final int numThreads = runnables.size();
        final List<Throwable> exceptions = Collections.synchronizedList(new ArrayList<Throwable>());
        final ExecutorService threadPool = Executors.newFixedThreadPool(
                numThreads > maxThreadPoolSize ? maxThreadPoolSize : numThreads);
        try {
            final CountDownLatch afterInitBlocker = new CountDownLatch(1);
            final CountDownLatch allDone = new CountDownLatch(numThreads);
            for (final Runnable submittedTestRunnable : runnables) {
                threadPool.submit(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            afterInitBlocker.await();
                            submittedTestRunnable.run();
                        } catch (final Throwable ex) {
                            exceptions.add(ex);
                        } finally {
                            allDone.countDown();
                        }
                    }
                });
            }
            afterInitBlocker.countDown();
            Assert.assertTrue(message + "timeout! More than" + maxTimeSeconds + "seconds",
                    allDone.await(maxTimeSeconds, TimeUnit.SECONDS));
            stopWatch.stop();
            System.out.println(stopWatch.prettyPrint());
        } finally {
            threadPool.shutdown();
        }

        Assert.assertTrue(message + "failed with exceptions" + exceptions, exceptions.isEmpty());
    }
}
