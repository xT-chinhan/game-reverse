package com.bytedance.sdk.component.ah.xr;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
public class le {
    long ab;
    long ah;
    long c;
    long d;
    long ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    long f1046ms = System.currentTimeMillis();
    long xr;

    public void ms() {
        this.ah = System.currentTimeMillis();
    }

    public void xr() {
        this.d = System.currentTimeMillis();
    }

    public void ah() {
        this.ka = System.currentTimeMillis();
    }

    public long d() {
        return this.f1046ms;
    }

    public long ka() {
        return this.ah;
    }

    public long c() {
        return this.d;
    }

    public long ab() {
        return this.ka;
    }

    public long x() {
        return this.c;
    }

    public void ms(long j) {
        this.c = j;
    }

    public long ny() {
        return this.ab;
    }

    public void xr(long j) {
        this.ab = j;
    }

    public long ch() {
        return this.xr;
    }

    public void hi() {
        this.xr = System.currentTimeMillis();
    }

    public String toString() {
        return "RequestHttpTime{requestBuildTs=" + this.f1046ms + ", asyncCallExecTs=" + this.xr + ", requestStartExecTs=" + this.ah + ", requestConnectStartTs=" + this.d + ", requestConnectFinishTs=" + this.ka + ", reqCallServerStartTs=" + this.c + ", reqCallServerFinishTs=" + this.ab + AbstractJsonLexerKt.END_OBJ;
    }
}
