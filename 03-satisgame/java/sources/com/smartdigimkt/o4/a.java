package com.smartdigimkt.o4;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements Runnable {
    public final /* synthetic */ boolean a = false;
    public final /* synthetic */ com.smartdigimkt.h3.b b;
    public final /* synthetic */ e c;

    public a(e eVar, com.smartdigimkt.h3.b bVar) {
        this.c = eVar;
        this.b = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.c.a(this.a, this.b);
    }
}
