package com.byazt.gi;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 587, 62})
public class fw {
    public pr hn;
    public Handler x;
    public Object pr = new Object();
    public Queue<hw> hw = new ConcurrentLinkedQueue();

    public fw(String str) {
        this.hn = new pr(str);
    }

    public void pr() {
        this.hn.start();
    }

    public void pr(Runnable runnable) {
        pr(runnable, 0L);
    }

    public void pr(Runnable runnable, long j) {
        if (this.x == null) {
            synchronized (this.pr) {
                if (this.x == null) {
                    this.hw.add(new hw(runnable, j));
                    return;
                }
            }
        }
        this.x.postDelayed(runnable, j);
    }

    public void hw() {
        this.hn.quit();
    }

    @com.byazt.vzx.pr(pr = {0, 1, 587, 766})
    private class pr extends HandlerThread {
        public pr(String str) {
            super(str);
        }

        @Override // android.os.HandlerThread
        public void onLooperPrepared() {
            super.onLooperPrepared();
            Looper looper = getLooper();
            synchronized (fw.this.pr) {
                fw.this.x = new Handler(looper);
            }
            while (!fw.this.hw.isEmpty()) {
                hw hwVar = (hw) fw.this.hw.poll();
                if (hwVar != null) {
                    fw.this.x.postDelayed(hwVar.pr, hwVar.hw);
                }
            }
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 587, 984})
    private class hw {
        public long hw;
        public Runnable pr;

        public hw(Runnable runnable, long j) {
            this.pr = runnable;
            this.hw = j;
        }
    }
}
