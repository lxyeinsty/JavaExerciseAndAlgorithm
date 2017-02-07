package com.lixinyan.se.Spider;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by administrator on 2016/5/25.
 *
 */
public class MyBoot {

    private List<String> hrefs = Collections.synchronizedList(new ArrayList<String>());
    private List<String> visited = Collections.synchronizedList(new ArrayList<String>());
    private List<String> images = Collections.synchronizedList(new ArrayList<String>());

    public MyBoot(String href) {
        this.hrefs.add(href);
    }

    public void run() throws InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(2);
        pool.execute(new SearchHreg(hrefs, visited, images));
        Thread.sleep(5000);
        pool.execute(new SearchHreg(hrefs, visited, images));
        pool.shutdown();
    }

    public static void main(String[] args) throws InterruptedException {
        MyBoot myBoot = new MyBoot("http://www.jianshu.com/");
        myBoot.run();
    }

}