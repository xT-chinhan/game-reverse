package com.smartdigimkt.m;

/* JADX INFO: loaded from: classes3.dex */
public final class h implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ j b;

    public h(j jVar, int i) {
        this.b = jVar;
        this.a = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.b.a.cancel(this.a);
        } catch (Throwable th) {
            th.getMessage();
        }
    }
}
