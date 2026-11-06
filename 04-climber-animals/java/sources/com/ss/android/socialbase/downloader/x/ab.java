package com.ss.android.socialbase.downloader.x;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes3.dex */
public class ab {
    private ms ah;
    private Handler d;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private Object f4792ms = new Object();
    private Queue<xr> xr = new ConcurrentLinkedQueue();

    public ab(String str) {
        this.ah = new ms(str);
    }

    public void ms() {
        this.ah.start();
    }

    public void ms(Runnable runnable) {
        ms(runnable, 0L);
    }

    public void ms(Runnable runnable, long j) {
        if (this.d == null) {
            synchronized (this.f4792ms) {
                if (this.d == null) {
                    this.xr.add(new xr(runnable, j));
                    return;
                }
            }
        }
        this.d.postDelayed(runnable, j);
    }

    public void xr() {
        this.ah.quit();
    }

    private class ms extends HandlerThread {
        ms(String str) {
            super(str);
        }

        @Override // android.os.HandlerThread
        protected void onLooperPrepared() {
            super.onLooperPrepared();
            Looper looper = getLooper();
            synchronized (ab.this.f4792ms) {
                ab.this.d = new Handler(looper);
            }
            while (!ab.this.xr.isEmpty()) {
                xr xrVar = (xr) ab.this.xr.poll();
                if (xrVar != null) {
                    ab.this.d.postDelayed(xrVar.f4794ms, xrVar.xr);
                }
            }
        }
    }

    private class xr {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        public Runnable f4794ms;
        public long xr;

        public xr(Runnable runnable, long j) {
            this.f4794ms = runnable;
            this.xr = j;
        }
    }
}
