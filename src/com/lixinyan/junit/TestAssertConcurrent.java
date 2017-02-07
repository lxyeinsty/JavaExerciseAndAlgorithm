package com.lixinyan.junit;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by administrator on 2016/6/23.
 *
 */
public class TestAssertConcurrent {

    @Test
    public void testAssertConcurrent() throws InterruptedException {
        List<Runnable> tasks = new ArrayList<>(100000);
        for (int i = 0; i < 100000; i++) {
            tasks.add(new Runnable() {
                @Override
                public void run() {
                    try{
                        Thread.sleep(20);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            });
        }

        ConcurrecyTestUtil.assertConcurrent("1024tasks", tasks, 10, 1000);
    }
}
