package com.lixinyan.se.thread;

import java.util.concurrent.TimeUnit;

/**
 * Created by administrator on 2016/8/9.
 *
 */
public class Task implements Runnable {
    private static int counter = 0;
    private final int id = counter++;

    @Override
    public void run() {
        System.out.println(this + "started");
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException ex) {
            System.out.println(this + "Interrupted");
            return;
        }

        System.out.println(this + "completed");
    }

    @Override
    public String toString() {
        return "Task" + id;
    }

    public int getId() {
        return id;
    }
}
