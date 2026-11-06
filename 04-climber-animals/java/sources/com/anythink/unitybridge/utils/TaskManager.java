package com.anythink.unitybridge.utils;

import android.util.Log;
import com.umeng.analytics.pro.bv;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes.dex */
public class TaskManager {
    private static TaskManager sSelf;
    private ThreadPoolExecutor mAPKDownPool = null;
    private ExecutorService mSinglePool;

    protected TaskManager() {
        this.mSinglePool = null;
        this.mSinglePool = Executors.newSingleThreadExecutor();
    }

    public static TaskManager getInstance() {
        if (sSelf == null) {
            sSelf = new TaskManager();
        }
        return sSelf;
    }

    private void run(Worker worker) {
        this.mSinglePool.execute(worker);
    }

    public void run_proxy(Runnable runnable) {
        run_proxyDelayed(runnable, 0L);
    }

    public void run_proxyDelayed(final Runnable runnable, final long j) {
        if (runnable != null) {
            Worker worker = new Worker() { // from class: com.anythink.unitybridge.utils.TaskManager.1
                @Override // com.anythink.unitybridge.utils.Worker
                public void work() {
                    try {
                        Thread.sleep(j);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Log.d(bv.aI, "thread-" + getID());
                    runnable.run();
                }
            };
            worker.setID(new Long(System.currentTimeMillis() / 1000).intValue());
            run(worker);
        }
    }

    public void release() {
        this.mSinglePool.shutdown();
        this.mAPKDownPool.shutdown();
    }
}
