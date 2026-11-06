package com.byazt.ynv;

import android.os.Process;
import android.os.SystemClock;
import com.byazt.tk.k;
import com.byazt.yq.q;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_AUTO_REOPEN, 8})
public final class s {
    public boolean n;
    public long qg;
    public long s;

    private static int n(long j) {
        if (j < 0) {
            return 0;
        }
        if (j > 1000) {
            return 1000;
        }
        return (int) j;
    }

    public qg n(long j, int i, boolean z, boolean z2) {
        com.byazt.yq.s sVarQg = q.n().qg();
        int iN = n();
        try {
            return n(iN, j, i, z, z2, sVarQg, qg(), SystemClock.elapsedRealtime());
        } catch (Throwable th) {
            k.qg("PerfMonitor_CpuMonitor", "cpu app sample err: " + th.getMessage());
            return new qg(-1, iN, 0, j, sVarQg);
        }
    }

    private qg n(int i, long j, int i2, boolean z, boolean z2, com.byazt.yq.s sVar, long j2, long j3) {
        if (j2 < 0 || j3 <= 0 || i <= 0) {
            return new qg(-1, i, 0, j, sVar);
        }
        if (!this.n) {
            n(j2, j3);
            return new qg(-1, i, 0, j, sVar);
        }
        long j4 = j2 - this.qg;
        long j5 = j3 - this.s;
        n(j2, j3);
        long j6 = j5 * ((long) i);
        if (j4 < 0 || j6 <= 0) {
            return new qg(-1, i, 0, j, sVar);
        }
        int iN = n((j4 * 1000) / j6);
        return new qg(iN, i, (z && z2) ? iN - i2 : 0, j, sVar);
    }

    private void n(long j, long j2) {
        if (j < 0 || j2 <= 0) {
            return;
        }
        this.qg = j;
        this.s = j2;
        this.n = true;
    }

    private static int n() {
        try {
            return Runtime.getRuntime().availableProcessors();
        } catch (Throwable unused) {
            return -1;
        }
    }

    private static long qg() {
        try {
            return Process.getElapsedCpuTime();
        } catch (Throwable unused) {
            return -1L;
        }
    }
}
