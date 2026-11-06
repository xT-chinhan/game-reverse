package com.smartdigimkt.m;

import com.smartdigimkt.k.r;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements Runnable {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ r b;
    public final /* synthetic */ long c;
    public final /* synthetic */ long d;
    public final /* synthetic */ j e;

    public c(long j, long j2, r rVar, j jVar, boolean z) {
        this.e = jVar;
        this.a = z;
        this.b = rVar;
        this.c = j;
        this.d = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.a) {
            this.e.a(this.b);
        }
        this.e.a(this.b, this.c, this.d, false);
    }
}
