package com.smartdigimkt.v0;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements Runnable {
    public final /* synthetic */ i a;

    public e(i iVar) {
        this.a = iVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        i iVar = this.a;
        if (iVar.L) {
            return;
        }
        iVar.o.a(iVar);
    }
}
