package com.smartdigimkt.x;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements Runnable {
    public final /* synthetic */ i a;
    public final /* synthetic */ j b;

    public e(j jVar, com.smartdigimkt.s3.l lVar) {
        this.b = jVar;
        this.a = lVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.a(this.a);
    }
}
