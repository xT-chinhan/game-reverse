package com.bytedance.sdk.openadsdk.core.component.splash.ah.ms;

/* JADX INFO: loaded from: classes2.dex */
public class c extends ms {
    private long ab;
    private long c;
    private com.bytedance.sdk.openadsdk.core.nw.ms d;
    private boolean ka;
    private long ny;
    private long x;

    public c(com.bytedance.sdk.openadsdk.core.nw.ms msVar, boolean z) {
        this.d = msVar;
        if (msVar != null && msVar.xr() != null && !this.d.xr().isEmpty()) {
            this.xr = this.d.xr().get(0);
        }
        this.ka = z;
    }

    public com.bytedance.sdk.openadsdk.core.nw.ms d() {
        return this.d;
    }

    public boolean ka() {
        return this.ka;
    }

    public long c() {
        return this.c;
    }

    public void xr(long j) {
        this.c = j;
    }

    public long ab() {
        return this.ab;
    }

    public void ah(long j) {
        this.ab = j;
    }

    public long x() {
        return this.x;
    }

    public void d(long j) {
        this.x = j;
    }

    public long ny() {
        return this.ny;
    }

    public void ka(long j) {
        this.ny = j;
    }
}
