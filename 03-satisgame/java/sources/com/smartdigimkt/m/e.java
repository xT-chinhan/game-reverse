package com.smartdigimkt.m;

import com.smartdigimkt.k.r;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements Runnable {
    public final /* synthetic */ r a;
    public final /* synthetic */ j b;

    public e(j jVar, r rVar) {
        this.b = jVar;
        this.a = rVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.a(this.a);
        this.b.a(this.a, 0L, 100L, true);
    }
}
