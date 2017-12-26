package com.lixinyan.algorithm;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;

/**
 * Created by lxy on 2017/11/28.
 *
 */
public class SemaphoreTest<T> {
    private final Set<T>  set;
    private final Semaphore semaphore;

    public SemaphoreTest(int bound) {
        this.set = Collections.synchronizedSet(new HashSet<T>());
        this.semaphore = new Semaphore(bound);
    }

    public boolean add(T o) throws InterruptedException {
        semaphore.acquire();
        boolean isAdded = false;
        try {
            isAdded = set.add(o);
            return isAdded;
        } finally {
            if (!isAdded) {
                semaphore.release();
            }
        }
    }

    public boolean remove(Object o) {
        boolean isRemoved = set.remove(o);
        if (isRemoved) {
            semaphore.release();
        }
        return isRemoved;
    }
}
