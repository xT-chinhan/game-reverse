package com.byazt.m;

import android.net.TrafficStats;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_MAX_JITTER_BUFFER_DELAY, 26})
public class qg {
    public static volatile qg fs = null;
    public static volatile boolean n = false;
    public static final String qg = "qg";
    public static long x = -1;
    public long w;
    public final cp s = cp.n();
    public final AtomicInteger q = new AtomicInteger();
    public final n l = new n(com.byazt.l.l.n());

    public static qg n() {
        if (fs == null) {
            synchronized (qg.class) {
                if (fs == null) {
                    fs = new qg();
                }
            }
        }
        return fs;
    }

    private qg() {
    }

    public void qg() {
        try {
            com.byazt.fe.n.s(qg, "startSampling: mSamplingCounter = " + this.q);
            if (this.q.getAndIncrement() == 0) {
                this.l.n();
                this.w = SystemClock.uptimeMillis();
            }
        } catch (Throwable unused) {
        }
    }

    public void s() {
        try {
            com.byazt.fe.n.s(qg, "stopSampling: mSamplingCounter = " + this.q);
            if (this.q.decrementAndGet() == 0) {
                this.l.qg();
                x();
            }
        } catch (Throwable unused) {
        }
    }

    public static long q() {
        return TrafficStats.getTotalRxBytes() - TrafficStats.getMobileRxBytes();
    }

    public static void l() {
        n = com.byazt.ta.w.qg(com.byazt.xv.s.u());
    }

    public void w() {
        long mobileRxBytes;
        try {
            l();
            if (n) {
                mobileRxBytes = q();
            } else {
                mobileRxBytes = TrafficStats.getMobileRxBytes();
            }
            long j = x;
            long j2 = mobileRxBytes - j;
            if (j >= 0) {
                synchronized (this) {
                    long jUptimeMillis = SystemClock.uptimeMillis();
                    this.s.n(j2, jUptimeMillis - this.w);
                    this.w = jUptimeMillis;
                }
            }
            x = mobileRxBytes;
        } catch (Exception unused) {
        }
    }

    public void x() {
        w();
        x = -1L;
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_MAX_JITTER_BUFFER_DELAY, 48})
    private class n extends Handler {
        public n(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                return;
            }
            qg.this.w();
            sendEmptyMessageDelayed(1, 1000L);
        }

        public void n() {
            sendEmptyMessage(1);
        }

        public void qg() {
            removeMessages(1);
        }
    }
}
