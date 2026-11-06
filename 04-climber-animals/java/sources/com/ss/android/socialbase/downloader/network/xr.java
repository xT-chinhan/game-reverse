package com.ss.android.socialbase.downloader.network;

import android.net.TrafficStats;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public class xr {
    private static long ab = -1;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public static volatile boolean f4736ms = false;
    private static volatile xr x = null;
    private static final String xr = "xr";
    private long c;
    private final hi ah = hi.ms();
    private final AtomicInteger d = new AtomicInteger();
    private final ms ka = new ms(com.ss.android.socialbase.downloader.x.ka.ms());

    public static xr ms() {
        if (x == null) {
            synchronized (xr.class) {
                if (x == null) {
                    x = new xr();
                }
            }
        }
        return x;
    }

    private xr() {
    }

    public void xr() {
        try {
            com.ss.android.socialbase.downloader.ah.ms.ah(xr, "startSampling: mSamplingCounter = " + this.d);
            if (this.d.getAndIncrement() == 0) {
                this.ka.ms();
                this.c = SystemClock.uptimeMillis();
            }
        } catch (Throwable unused) {
        }
    }

    public void ah() {
        try {
            com.ss.android.socialbase.downloader.ah.ms.ah(xr, "stopSampling: mSamplingCounter = " + this.d);
            if (this.d.decrementAndGet() == 0) {
                this.ka.xr();
                ab();
            }
        } catch (Throwable unused) {
        }
    }

    public static long d() {
        return TrafficStats.getTotalRxBytes() - TrafficStats.getMobileRxBytes();
    }

    public static void ka() {
        f4736ms = com.ss.android.socialbase.downloader.ny.c.xr(com.ss.android.socialbase.downloader.downloader.ah.k());
    }

    protected void c() {
        long mobileRxBytes;
        try {
            ka();
            if (f4736ms) {
                mobileRxBytes = d();
            } else {
                mobileRxBytes = TrafficStats.getMobileRxBytes();
            }
            long j = ab;
            long j2 = mobileRxBytes - j;
            if (j >= 0) {
                synchronized (this) {
                    long jUptimeMillis = SystemClock.uptimeMillis();
                    this.ah.ms(j2, jUptimeMillis - this.c);
                    this.c = jUptimeMillis;
                }
            }
            ab = mobileRxBytes;
        } catch (Exception e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
        }
    }

    protected void ab() {
        c();
        ab = -1L;
    }

    private class ms extends Handler {
        public ms(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                return;
            }
            xr.this.c();
            sendEmptyMessageDelayed(1, 1000L);
        }

        public void ms() {
            sendEmptyMessage(1);
        }

        public void xr() {
            removeMessages(1);
        }
    }
}
