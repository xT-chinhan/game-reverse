package com.byazt.edb;

import android.net.TrafficStats;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 444, 13})
public class hw {
    public static volatile boolean pr;
    public long uc;
    public static final String hw = hw.class.getSimpleName();
    public static long fw = -1;
    public static volatile hw zo = null;
    public final w hn = w.pr();
    public final AtomicInteger x = new AtomicInteger();
    public final pr c = new pr(com.byazt.gi.c.pr());

    public static hw pr() {
        if (zo == null) {
            synchronized (hw.class) {
                if (zo == null) {
                    zo = new hw();
                }
            }
        }
        return zo;
    }

    private hw() {
    }

    public void hw() {
        try {
            com.byazt.p000do.pr.hn(hw, "startSampling: mSamplingCounter = " + this.x);
            if (this.x.getAndIncrement() == 0) {
                this.c.pr();
                this.uc = SystemClock.uptimeMillis();
            }
        } catch (Throwable th) {
        }
    }

    public void hn() {
        try {
            com.byazt.p000do.pr.hn(hw, "stopSampling: mSamplingCounter = " + this.x);
            if (this.x.decrementAndGet() == 0) {
                this.c.hw();
                fw();
            }
        } catch (Throwable th) {
        }
    }

    public static long x() {
        return TrafficStats.getTotalRxBytes() - TrafficStats.getMobileRxBytes();
    }

    public static void c() {
        pr = com.byazt.tuy.uc.hw(com.byazt.lj.hn.of());
    }

    public void uc() {
        long mobileRxBytes;
        try {
            c();
            if (pr) {
                mobileRxBytes = x();
            } else {
                mobileRxBytes = TrafficStats.getMobileRxBytes();
            }
            long j = fw;
            long j2 = mobileRxBytes - j;
            if (j >= 0) {
                synchronized (this) {
                    long jUptimeMillis = SystemClock.uptimeMillis();
                    this.hn.pr(j2, jUptimeMillis - this.uc);
                    this.uc = jUptimeMillis;
                }
            }
            fw = mobileRxBytes;
        } catch (Exception e) {
        }
    }

    public void fw() {
        uc();
        fw = -1L;
    }

    @com.byazt.vzx.pr(pr = {0, 1, 444, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_HIGH_THRESHOLD})
    private class pr extends Handler {
        public pr(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    hw.this.uc();
                    sendEmptyMessageDelayed(1, 1000L);
                    break;
            }
        }

        public void pr() {
            sendEmptyMessage(1);
        }

        public void hw() {
            removeMessages(1);
        }
    }
}
