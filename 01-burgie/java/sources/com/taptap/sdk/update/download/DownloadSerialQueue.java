package com.taptap.sdk.update.download;

import com.taptap.sdk.update.download.core.Util;
import com.taptap.sdk.update.download.core.cause.EndCause;
import com.taptap.sdk.update.download.core.listener.DownloadListener2;
import com.taptap.sdk.update.download.core.listener.DownloadListenerBunch;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadSerialQueue extends DownloadListener2 implements Runnable {
    static final int ID_INVALID = 0;
    private static final Executor SERIAL_EXECUTOR = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 30, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkDownload DynamicSerial", false));
    private static final String TAG = "DownloadSerialQueue";
    DownloadListenerBunch listenerBunch;
    volatile boolean looping;
    volatile boolean paused;
    volatile DownloadTask runningTask;
    volatile boolean shutedDown;
    private final ArrayList<DownloadTask> taskList;

    public DownloadSerialQueue() {
        this(null);
    }

    DownloadSerialQueue(DownloadListener listener, ArrayList<DownloadTask> taskList) {
        this.shutedDown = false;
        this.looping = false;
        this.paused = false;
        this.listenerBunch = new DownloadListenerBunch.Builder().append(this).append(listener).build();
        this.taskList = taskList;
    }

    public DownloadSerialQueue(DownloadListener listener) {
        this(listener, new ArrayList());
    }

    public void setListener(DownloadListener listener) {
        this.listenerBunch = new DownloadListenerBunch.Builder().append(this).append(listener).build();
    }

    public synchronized void enqueue(DownloadTask task) {
        this.taskList.add(task);
        Collections.sort(this.taskList);
        if (!this.paused && !this.looping) {
            this.looping = true;
            startNewLooper();
        }
    }

    public synchronized void pause() {
        if (this.paused) {
            Util.w(TAG, "require pause this queue(remain " + this.taskList.size() + "), butit has already been paused");
            return;
        }
        this.paused = true;
        if (this.runningTask != null) {
            this.runningTask.cancel();
            this.taskList.add(0, this.runningTask);
            this.runningTask = null;
        }
    }

    public synchronized void resume() {
        if (!this.paused) {
            Util.w(TAG, "require resume this queue(remain " + this.taskList.size() + "), but it is still running");
            return;
        }
        this.paused = false;
        if (!this.taskList.isEmpty() && !this.looping) {
            this.looping = true;
            startNewLooper();
        }
    }

    public int getWorkingTaskId() {
        if (this.runningTask != null) {
            return this.runningTask.getId();
        }
        return 0;
    }

    public int getWaitingTaskCount() {
        return this.taskList.size();
    }

    public synchronized DownloadTask[] shutdown() {
        DownloadTask[] tasks;
        this.shutedDown = true;
        if (this.runningTask != null) {
            this.runningTask.cancel();
        }
        tasks = new DownloadTask[this.taskList.size()];
        this.taskList.toArray(tasks);
        this.taskList.clear();
        return tasks;
    }

    @Override // java.lang.Runnable
    public void run() {
        DownloadTask nextTask;
        while (!this.shutedDown) {
            synchronized (this) {
                if (!this.taskList.isEmpty() && !this.paused) {
                    nextTask = this.taskList.remove(0);
                }
                this.runningTask = null;
                this.looping = false;
                return;
            }
            nextTask.execute(this.listenerBunch);
        }
    }

    void startNewLooper() {
        SERIAL_EXECUTOR.execute(this);
    }

    @Override // com.taptap.sdk.update.download.DownloadListener
    public void taskStart(DownloadTask task) {
        this.runningTask = task;
    }

    @Override // com.taptap.sdk.update.download.DownloadListener
    public synchronized void taskEnd(DownloadTask task, EndCause cause, Exception realCause) {
        if (cause != EndCause.CANCELED && task == this.runningTask) {
            this.runningTask = null;
        }
    }
}
