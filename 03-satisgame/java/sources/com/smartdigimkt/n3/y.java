package com.smartdigimkt.n3;

import com.smartdigimkt.sdk.core.SDKContext;

/* JADX INFO: loaded from: classes3.dex */
public final class y implements com.smartdigimkt.h4.c {
    public final /* synthetic */ com.smartdigimkt.f3.d a;
    public final /* synthetic */ a0 b;

    public y(a0 a0Var, com.smartdigimkt.f3.d dVar) {
        this.b = a0Var;
        this.a = dVar;
    }

    @Override // com.smartdigimkt.h4.c
    public final void a(Object obj) {
        String str = this.b.a;
        this.a.getClass();
        com.smartdigimkt.z2.j.a(com.smartdigimkt.z2.d.a(SDKContext.getInstance().d())).a(this.a);
        this.b.b.decrementAndGet();
    }

    @Override // com.smartdigimkt.h4.c
    public final void a(Throwable th) {
        String str = this.b.a;
        this.a.getClass();
        th.getMessage();
        this.b.b.decrementAndGet();
    }
}
