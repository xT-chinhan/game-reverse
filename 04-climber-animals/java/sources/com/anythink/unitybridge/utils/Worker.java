package com.anythink.unitybridge.utils;

/* JADX INFO: loaded from: classes.dex */
public abstract class Worker implements Runnable {
    public static final int TYPE_NORMAL = 1;
    public static final int TYPE_PHOTO = 2;
    public static final int TYPE_PRECLICK = 3;
    protected boolean mRunning = true;
    protected int mType = 1;
    private int mWorkID = 0;
    protected WorkerListener mWorkerStatus;

    public abstract void work();

    void setID(int i) {
        this.mWorkID = i;
    }

    public int getID() {
        return this.mWorkID;
    }

    public void setStatusListener(WorkerListener workerListener) {
        this.mWorkerStatus = workerListener;
    }

    @Override // java.lang.Runnable
    public void run() {
        WorkerListener workerListener = this.mWorkerStatus;
        if (workerListener != null) {
            workerListener.onWorkStart(this);
        }
        work();
        WorkerListener workerListener2 = this.mWorkerStatus;
        if (workerListener2 != null) {
            workerListener2.onWorkFinished(this);
        }
    }
}
