package com.smartdigimkt.n3;

import com.smartdigimkt.sdk.api.AdError;
import com.smartdigimkt.sdk.core.SDKContext;

/* JADX INFO: loaded from: classes3.dex */
public final class z implements com.smartdigimkt.a4.b {
    public final /* synthetic */ com.smartdigimkt.f3.d a;
    public final /* synthetic */ a0 b;

    public z(a0 a0Var, com.smartdigimkt.f3.d dVar) {
        this.b = a0Var;
        this.a = dVar;
    }

    @Override // com.smartdigimkt.a4.b
    public final void a(int i) {
    }

    @Override // com.smartdigimkt.a4.b
    public final void a(int i, Object obj) {
        String str = this.b.a;
        this.a.getClass();
        com.smartdigimkt.z2.j.a(com.smartdigimkt.z2.d.a(SDKContext.getInstance().d())).a(this.a);
        this.b.b.decrementAndGet();
    }

    @Override // com.smartdigimkt.a4.b
    public final void a(int i, String str, AdError adError) {
        String str2 = this.b.a;
        this.a.getClass();
        this.b.b.decrementAndGet();
    }
}
