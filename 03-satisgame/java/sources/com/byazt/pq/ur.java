package com.byazt.pq;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 109, 1088})
public class ur {
    public long l;
    public long n = System.currentTimeMillis();
    public long q;
    public long qg;
    public long s;
    public long w;
    public long x;

    public void n() {
        this.s = System.currentTimeMillis();
    }

    public void qg() {
        this.q = System.currentTimeMillis();
    }

    public void s() {
        this.l = System.currentTimeMillis();
    }

    public long q() {
        return this.n;
    }

    public long l() {
        return this.s;
    }

    public long w() {
        return this.q;
    }

    public long x() {
        return this.l;
    }

    public long fs() {
        return this.w;
    }

    public void n(long j) {
        this.w = j;
    }

    public long rv() {
        return this.x;
    }

    public void qg(long j) {
        this.x = j;
    }

    public long tj() {
        return this.qg;
    }

    public void cp() {
        this.qg = System.currentTimeMillis();
    }

    public String toString() {
        return "RequestHttpTime{requestBuildTs=" + this.n + ", asyncCallExecTs=" + this.qg + ", requestStartExecTs=" + this.s + ", requestConnectStartTs=" + this.q + ", requestConnectFinishTs=" + this.l + ", reqCallServerStartTs=" + this.w + ", reqCallServerFinishTs=" + this.x + AbstractJsonLexerKt.END_OBJ;
    }
}
