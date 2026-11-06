package com.smartdigimkt.b2;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ c b;

    public b(c cVar, int i) {
        this.b = cVar;
        this.a = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.b(this.a);
    }
}
