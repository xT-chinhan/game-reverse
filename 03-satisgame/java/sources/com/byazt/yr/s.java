package com.byazt.yr;

import android.os.Debug;
import com.anythink.china.a.c;
import com.byazt.tk.k;
import com.byazt.yq.q;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1087, 8})
public final class s {
    public long n = -1;
    public long qg = 0;
    public long s = 0;

    public qg n(long j) {
        long jFreeMemory;
        long nativeHeapAllocatedSize;
        long jN;
        long j2;
        long j3;
        long j4;
        try {
            Runtime runtime = Runtime.getRuntime();
            jFreeMemory = runtime.totalMemory() - runtime.freeMemory();
        } catch (Throwable th) {
            k.qg("PerfMonitor", "sample javaUsed err: " + th.getMessage());
            jFreeMemory = 0;
        }
        try {
            nativeHeapAllocatedSize = Debug.getNativeHeapAllocatedSize();
        } catch (Throwable th2) {
            k.qg("PerfMonitor", "sample nativeHeap err: " + th2.getMessage());
            nativeHeapAllocatedSize = 0;
        }
        try {
            jN = n();
        } catch (Throwable th3) {
            k.qg("PerfMonitor", "sample limit err: " + th3.getMessage());
            jN = 0;
        }
        long j5 = (jFreeMemory + nativeHeapAllocatedSize) / c.k;
        long j6 = jFreeMemory / c.k;
        long j7 = jN / c.k;
        long j8 = nativeHeapAllocatedSize / c.k;
        int iN = n(j6, j7);
        long j9 = this.n;
        if (j9 < 0) {
            this.n = j5;
            this.qg = j6;
            this.s = j8;
            j4 = 0;
            j3 = 0;
            j2 = 0;
        } else {
            long j10 = j5 - j9;
            long j11 = j6 - this.qg;
            j2 = j8 - this.s;
            j3 = j11;
            j4 = j10;
        }
        return new qg(j5, j6, j7, iN, j8, j4, j3, j2, j, q.n().qg());
    }

    private static int n(long j, long j2) {
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

    private static long n() {
        try {
            long jMaxMemory = Runtime.getRuntime().maxMemory();
            if (jMaxMemory > 0) {
                return jMaxMemory;
            }
            return 0L;
        } catch (Throwable th) {
            k.qg("PerfMonitor", "computeLimitBytes err: " + th.getMessage());
        }
    }
}
