package com.smartdigimkt.t4;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements com.smartdigimkt.m3.b {
    public final /* synthetic */ c a;

    public b(c cVar) {
        this.a = cVar;
    }

    @Override // com.smartdigimkt.m3.b
    public final boolean a() {
        return false;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.a.mHasReturn) {
            return;
        }
        this.a.isAdTimeout = true;
        c cVar = this.a;
        cVar.onTimeout(cVar.mRequestId);
    }
}
