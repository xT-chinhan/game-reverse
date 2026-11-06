package com.smartdigimkt.j;

/* JADX INFO: loaded from: classes3.dex */
public final class p implements com.smartdigimkt.k.n {
    public final /* synthetic */ long a;
    public final /* synthetic */ com.smartdigimkt.k.r b;
    public final /* synthetic */ u c;

    public p(u uVar, long j, com.smartdigimkt.k.r rVar) {
        this.c = uVar;
        this.a = j;
        this.b = rVar;
    }

    @Override // com.smartdigimkt.k.n
    public final void onCallback(com.smartdigimkt.k.r rVar) {
        if (rVar.h <= this.a) {
            this.c.b(rVar);
        } else {
            this.c.g(this.b);
        }
    }
}
