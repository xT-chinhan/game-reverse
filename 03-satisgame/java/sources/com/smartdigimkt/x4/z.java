package com.smartdigimkt.x4;

import com.smartdigimkt.sdk.core.SDKContext;

/* JADX INFO: loaded from: classes3.dex */
public final class z implements Runnable {
    public final /* synthetic */ SDKContext a;
    public final /* synthetic */ com.smartdigimkt.h3.b b;
    public final /* synthetic */ com.smartdigimkt.v4.a c;
    public final /* synthetic */ a0 d;

    public z(a0 a0Var, SDKContext sDKContext, com.smartdigimkt.h3.b bVar, com.smartdigimkt.v4.a aVar) {
        this.d = a0Var;
        this.a = sDKContext;
        this.b = bVar;
        this.c = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.a(new y(this));
    }
}
