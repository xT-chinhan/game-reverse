package com.byazt.av;

import android.app.Notification;
import com.byazt.qx.BaseException;
import com.byazt.wm.DownloadInfo;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 425, 19})
public abstract class n {
    public int fs;
    public String l;
    public Notification n;
    public long q;
    public int qg;
    public boolean rv;
    public long s;
    public int w = 0;
    public long x;

    public abstract void n(BaseException baseException, boolean z);

    public n(int i, String str) {
        this.qg = i;
        this.l = str;
    }

    public void n(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        this.qg = downloadInfo.getId();
        this.l = downloadInfo.getTitle();
    }

    public int n() {
        return this.qg;
    }

    public long qg() {
        return this.s;
    }

    public void n(long j) {
        this.s = j;
    }

    public long s() {
        return this.q;
    }

    public void qg(long j) {
        this.q = j;
    }

    public String q() {
        return this.l;
    }

    public int l() {
        return this.w;
    }

    public void n(int i, BaseException baseException, boolean z) {
        n(i, baseException, z, false);
    }

    public void n(int i, BaseException baseException, boolean z, boolean z2) {
        if (z2 || this.w != i) {
            this.w = i;
            n(baseException, z);
        }
    }

    public long w() {
        if (this.x == 0) {
            this.x = System.currentTimeMillis();
        }
        return this.x;
    }

    public void n(long j, long j2) {
        this.s = j;
        this.q = j2;
        this.w = 4;
        n((BaseException) null, false);
    }

    public void n(Notification notification) {
        if (this.qg == 0 || notification == null) {
            return;
        }
        qg.n().n(this.qg, this.w, notification);
    }

    public synchronized void x() {
        this.fs++;
    }

    public boolean fs() {
        return this.rv;
    }
}
