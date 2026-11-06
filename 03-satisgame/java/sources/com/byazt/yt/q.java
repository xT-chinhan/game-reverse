package com.byazt.yt;

import com.byazt.af.x;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1955, 5})
public class q {
    public float n;
    public float qg;

    public q(float f, float f2) {
        this.n = f;
        this.qg = f2;
    }

    public q() {
        this(1.0f, 1.0f);
    }

    public float n() {
        return this.n;
    }

    public float qg() {
        return this.qg;
    }

    public void n(float f, float f2) {
        this.n = f;
        this.qg = f2;
    }

    public boolean qg(float f, float f2) {
        return this.n == f && this.qg == f2;
    }

    public String toString() {
        return n() + x.n + qg();
    }
}
