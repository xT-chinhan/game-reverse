package com.smartdigimkt.y;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ b b;

    public a(b bVar, int i) {
        this.b = bVar;
        this.a = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        c.a(this.b.a, this.a);
    }
}
