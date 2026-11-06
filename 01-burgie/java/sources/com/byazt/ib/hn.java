package com.byazt.ib;

import android.os.Debug;
import android.support.v4.media.session.PlaybackStateCompat;
import com.byazt.ca.ho;
import com.byazt.sf.x;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1213, 20})
public final class hn {
    public long pr = -1;
    public long hw = 0;
    public long hn = 0;

    public hw pr(long j) {
        long jFreeMemory;
        long nativeHeapAllocatedSize;
        long jPr;
        long j2;
        long j3;
        long j4;
        try {
            Runtime runtime = Runtime.getRuntime();
            jFreeMemory = runtime.totalMemory() - runtime.freeMemory();
        } catch (Throwable th) {
            ho.hw("PerfMonitor", "sample javaUsed err: " + th.getMessage());
            jFreeMemory = 0;
        }
        try {
            nativeHeapAllocatedSize = Debug.getNativeHeapAllocatedSize();
        } catch (Throwable th2) {
            ho.hw("PerfMonitor", "sample nativeHeap err: " + th2.getMessage());
            nativeHeapAllocatedSize = 0;
        }
        try {
            jPr = pr();
        } catch (Throwable th3) {
            ho.hw("PerfMonitor", "sample limit err: " + th3.getMessage());
            jPr = 0;
        }
        long j5 = (jFreeMemory + nativeHeapAllocatedSize) / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
        long j6 = jFreeMemory / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
        long j7 = jPr / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
        long j8 = nativeHeapAllocatedSize / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
        int iPr = pr(j6, j7);
        long j9 = this.pr;
        if (j9 < 0) {
            this.pr = j5;
            this.hw = j6;
            this.hn = j8;
            j4 = 0;
            j3 = 0;
            j2 = 0;
        } else {
            long j10 = j5 - j9;
            long j11 = j6 - this.hw;
            j2 = j8 - this.hn;
            j3 = j11;
            j4 = j10;
        }
        return new hw(j5, j6, j7, iPr, j8, j4, j3, j2, j, x.pr().hw());
    }

    private static int pr(long j, long j2) {
        if (j2 <= 0) {
            return 0;
        }
        long j3 = (j * 1000) / j2;
        if (j3 < 0) {
            return 0;
        }
        if (j3 > 1000) {
            return 1000;
        }
        return (int) j3;
    }

    private static long pr() {
        try {
            long jMaxMemory = Runtime.getRuntime().maxMemory();
            if (jMaxMemory <= 0) {
                return 0L;
            }
            return jMaxMemory;
        } catch (Throwable th) {
            ho.hw("PerfMonitor", "computeLimitBytes err: " + th.getMessage());
        }
    }
}
