package com.lixinyan.se.thread;

/**
 * Created by administrator on 2016/5/8.
 *
 */
public class MyTask implements Runnable {
    private int taskNum;

    public MyTask(int taskNum) {
        this.taskNum = taskNum;
    }

    @Override
    public void run() {
        System.out.println("正在执行task" + taskNum);
        try {
            Thread.currentThread().sleep(4000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println("task" + taskNum + "执行完毕 ");
    }

}
