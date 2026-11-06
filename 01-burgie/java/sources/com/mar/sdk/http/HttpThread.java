package com.mar.sdk.http;

import android.graphics.Bitmap;
import com.mar.sdk.log.Log;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class HttpThread {
    private static HttpThread instance;
    private final String TAG = "MARSDK-Thread";
    private final ArrayBlockingQueue<Runnable> blockingQueue = new ArrayBlockingQueue<>(99);
    public Runnable runnable = new Runnable() { // from class: com.mar.sdk.http.HttpThread.2
        Runnable r = null;

        /* JADX INFO: Infinite loop detected, blocks: 9, insns: 0 */
        @Override // java.lang.Runnable
        public void run() {
            Log.d("MARSDK-Thread", "http thread start run:" + Thread.currentThread().getName());
            while (true) {
                try {
                    this.r = (Runnable) HttpThread.this.blockingQueue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                HttpThread.this.threadPoolExecutor.execute(this.r);
                Log.d("MARSDK-Thread", "http thread runnable:" + this.r);
            }
        }
    };
    private final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(4, 32, 60, TimeUnit.SECONDS, new ArrayBlockingQueue(128), new RejectedExecutionHandler() { // from class: com.mar.sdk.http.HttpThread.1
        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            HttpThread.this.addTask(r);
            Log.d("MARSDK-Thread", "thread task re add");
        }
    });

    public static HttpThread getInstance() {
        if (instance == null) {
            instance = new HttpThread();
        }
        return instance;
    }

    private HttpThread() {
        this.threadPoolExecutor.execute(this.runnable);
    }

    public boolean addTask(Callable<Boolean> callable, long timeout, TimeUnit unit) {
        Future<Boolean> future = this.threadPoolExecutor.submit(callable);
        try {
            return future.get(timeout, unit).booleanValue();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public String addTask(Callable<String> callable) {
        Future<String> future = this.threadPoolExecutor.submit(callable);
        try {
            return future.get(5L, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Bitmap addTask(Callable<Bitmap> callable, long timeout) {
        Future<Bitmap> future = this.threadPoolExecutor.submit(callable);
        try {
            return future.get(timeout, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public long addTask(Callable<Long> callable, String st) {
        Future<Long> future = this.threadPoolExecutor.submit(callable);
        try {
            return future.get(1L, TimeUnit.SECONDS).longValue();
        } catch (Exception e) {
            e.printStackTrace();
            return System.currentTimeMillis();
        }
    }

    public void addTask(Runnable runnable) {
        if (runnable == null) {
            Log.d("MARSDK-Thread", "add task fail, runnable is null");
        } else {
            this.blockingQueue.add(runnable);
        }
    }

    public void addTask(List<Runnable> runnableList) {
        if (runnableList.size() <= 0) {
            Log.d("MARSDK-Thread", "addTask: fail,task list of size is 0");
        } else {
            this.blockingQueue.addAll(runnableList);
        }
    }
}
