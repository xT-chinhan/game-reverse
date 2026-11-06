package com.smartdigimkt.z;

/* JADX INFO: loaded from: classes3.dex */
public final class w implements Runnable {
    public final /* synthetic */ x a;

    public w(x xVar) {
        this.a = xVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        x xVar = this.a;
        xVar.b.a(xVar.a);
    }
}
