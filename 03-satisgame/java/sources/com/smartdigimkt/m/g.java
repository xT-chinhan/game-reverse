package com.smartdigimkt.m;

import com.smartdigimkt.k.r;

/* JADX INFO: loaded from: classes3.dex */
public final class g implements Runnable {
    public final /* synthetic */ r a;
    public final /* synthetic */ j b;

    public g(j jVar, r rVar) {
        this.b = jVar;
        this.a = rVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.b.a.cancel(j.a(this.b, this.a).a);
            this.b.b.remove(this.a.o);
        } catch (Throwable th) {
            th.getMessage();
        }
    }
}
