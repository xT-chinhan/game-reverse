package com.byazt.tbt;

import com.byazt.pq.ur;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1089, 29})
public class cp {
    public long l;
    public long n;
    public long q;
    public long qg;
    public long s;
    public long w;
    public long x;

    public cp() {
        this.n = System.currentTimeMillis();
    }

    public cp(Object obj) {
        this.n = System.currentTimeMillis();
        try {
            if (obj instanceof ur) {
                ur urVar = (ur) obj;
                this.n = urVar.q();
                this.qg = urVar.tj();
                this.s = urVar.l();
                this.q = urVar.w();
                this.l = urVar.x();
                this.w = urVar.fs();
                this.x = urVar.rv();
            }
        } catch (Throwable unused) {
        }
    }

    public void n() {
        this.s = System.currentTimeMillis();
    }

    public void qg() {
        this.q = System.currentTimeMillis();
    }

    public void s() {
        this.l = System.currentTimeMillis();
    }

    public void n(long j) {
        this.w = j;
    }

    public void qg(long j) {
        this.x = j;
    }

    public void q() {
        this.qg = System.currentTimeMillis();
    }
}
