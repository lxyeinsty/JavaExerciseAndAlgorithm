package com.lixinyan.se.thread;

import java.util.concurrent.Callable;

/**
 * Created by administrator on 2016/8/9.
 *
 */
public class CallableTask extends Task implements Callable<String> {
    @Override
    public String call() throws Exception {
        run();
        return "Return value of " + this;
    }
}
