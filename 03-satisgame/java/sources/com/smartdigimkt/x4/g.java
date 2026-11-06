package com.smartdigimkt.x4;

/* JADX INFO: loaded from: classes3.dex */
public final class g implements com.smartdigimkt.m3.b {
    public final Runnable a;

    public g(c cVar) {
        this.a = cVar;
    }

    @Override // com.smartdigimkt.m3.b
    public final boolean a() {
        return false;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Runnable runnable = this.a;
        if (runnable != null) {
            runnable.run();
        }
    }
}
