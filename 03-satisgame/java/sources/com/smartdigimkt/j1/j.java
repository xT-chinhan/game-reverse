package com.smartdigimkt.j1;

/* JADX INFO: loaded from: classes3.dex */
public final class j implements Runnable {
    public final /* synthetic */ s a;
    public final /* synthetic */ t b;

    public j(t tVar, s sVar) {
        this.b = tVar;
        this.a = sVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        t tVar = this.b;
        a aVar = tVar.g;
        if (tVar.h || aVar == null) {
            return;
        }
        this.a.a(aVar);
    }
}
