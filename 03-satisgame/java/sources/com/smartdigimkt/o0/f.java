package com.smartdigimkt.o0;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements e {
    public final int a;
    public final int b;
    public final com.smartdigimkt.z0.m c;

    public f(b bVar) {
        com.smartdigimkt.z0.m mVar = bVar.P0;
        this.c = mVar;
        mVar.c(12);
        this.a = mVar.h();
        this.b = mVar.h();
    }

    @Override // com.smartdigimkt.o0.e
    public final boolean a() {
        return this.a != 0;
    }

    @Override // com.smartdigimkt.o0.e
    public final int b() {
        return this.b;
    }

    @Override // com.smartdigimkt.o0.e
    public final int c() {
        int i = this.a;
        return i == 0 ? this.c.h() : i;
    }
}
