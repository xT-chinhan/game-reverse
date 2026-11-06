package com.byazt.ka;

import android.os.Process;
import android.os.SystemClock;
import com.byazt.ca.ho;
import com.byazt.sf.x;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1547, 20})
public final class hn {
    public long hn;
    public long hw;
    public boolean pr;

    public hw pr(long j, int i, boolean z, boolean z2) {
        com.byazt.sf.hn hnVarHw = x.pr().hw();
        int iPr = pr();
        try {
            return pr(iPr, j, i, z, z2, hnVarHw, hw(), SystemClock.elapsedRealtime());
        } catch (Throwable th) {
            ho.hw("PerfMonitor_CpuMonitor", "cpu app sample err: " + th.getMessage());
            return new hw(-1, iPr, 0, j, hnVarHw);
        }
    }

    private hw pr(int i, long j, int i2, boolean z, boolean z2, com.byazt.sf.hn hnVar, long j2, long j3) {
        if (j2 < 0 || j3 <= 0 || i <= 0) {
            return new hw(-1, i, 0, j, hnVar);
        }
        if (!this.pr) {
            pr(j2, j3);
            return new hw(-1, i, 0, j, hnVar);
        }
        long j4 = j2 - this.hw;
        long j5 = j3 - this.hn;
        pr(j2, j3);
        long j6 = j5 * ((long) i);
        if (j4 < 0 || j6 <= 0) {
            return new hw(-1, i, 0, j, hnVar);
        }
        int iPr = pr((j4 * 1000) / j6);
        return new hw(iPr, i, (z && z2) ? iPr - i2 : 0, j, hnVar);
    }

    private void pr(long j, long j2) {
        if (j < 0 || j2 <= 0) {
            return;
        }
        this.hw = j;
        this.hn = j2;
        this.pr = true;
    }

    private static int pr(long j) {
        if (j < 0) {
            return 0;
        }
        if (j > 1000) {
            return 1000;
        }
        return (int) j;
    }

    private static int pr() {
        try {
            return Runtime.getRuntime().availableProcessors();
        } catch (Throwable th) {
            return -1;
        }
    }

    private static long hw() {
        try {
            return Process.getElapsedCpuTime();
        } catch (Throwable th) {
            return -1L;
        }
    }
}
