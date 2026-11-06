package com.bytedance.sdk.component.adexpress.ms.ms;

import com.bytedance.sdk.component.c.ub;

/* JADX INFO: loaded from: classes2.dex */
public class ms {
    private static ms ka = new ms();
    private volatile ah ah;
    private volatile ka c;
    private volatile ub d;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private volatile xr f893ms;
    private volatile d xr;

    private ms() {
    }

    public static ms ms() {
        return ka;
    }

    public void ms(xr xrVar) {
        this.f893ms = xrVar;
    }

    public xr xr() {
        return this.f893ms;
    }

    public void ms(ah ahVar) {
        this.ah = ahVar;
    }

    public ah ah() {
        return this.ah;
    }

    public void ms(d dVar) {
        this.xr = dVar;
    }

    public d d() {
        return this.xr;
    }

    public void ms(ub ubVar) {
        this.d = ubVar;
    }

    public ub ka() {
        return this.d;
    }

    public void ms(ka kaVar) {
        this.c = kaVar;
    }

    public ka c() {
        return this.c;
    }
}
