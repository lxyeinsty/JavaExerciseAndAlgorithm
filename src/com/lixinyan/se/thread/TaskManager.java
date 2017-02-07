package com.lixinyan.se.thread;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by administrator on 2016/8/9.
 *
 */
public class TaskManager<R, C extends Callable<R>> extends ArrayList<TaskItem<R, C>> {
    private ExecutorService executorService = Executors.newSingleThreadExecutor();

    public void add(C task) {
        this.add(new TaskItem<R, C>(executorService.submit(task), task));
    }

    public List<R> getResults() {
        Iterator<TaskItem<R, C>> items = this.iterator();
        List<R> results = new ArrayList<>();
        while (items.hasNext()) {
            TaskItem<R, C> item = items.next();
            if (item.future.isDone()) {
                try {
                    results.add(item.future.get());
                } catch (InterruptedException | ExecutionException ex) {
                    throw  new RuntimeException(ex);
                }
            }
        }

        return results;
    }

    public List<String> purge() {
        Iterator<TaskItem<R, C>> items = this.iterator();
        List<String> results = new ArrayList<>();
        while (items.hasNext()) {
            TaskItem<R, C> item = items.next();
            if (!item.future.isDone()) {
                results.add("Canceling " + item.task);
                item.future.cancel(true);
                items.remove();
            }
        }

        return results;
    }
}
