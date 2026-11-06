package com.smartdigimkt.h1;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends com.smartdigimkt.p3.a {
    public final /* synthetic */ k b;

    public f(k kVar) {
        this.b = kVar;
    }

    @Override // com.smartdigimkt.p3.a
    public final int a() {
        return 1;
    }

    @Override // com.smartdigimkt.p3.a
    public final void b() {
        k kVar = this.b;
        if (kVar.m == 0) {
            kVar.m = System.currentTimeMillis();
        }
    }
}
