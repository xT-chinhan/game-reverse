package com.smartdigimkt.x4;

import com.smartdigimkt.sdk.api.SDMSDK;

/* JADX INFO: loaded from: classes3.dex */
public final class y implements SDMSDK.InitCallBack {
    public final /* synthetic */ z a;

    public y(z zVar) {
        this.a = zVar;
    }

    @Override // com.smartdigimkt.sdk.api.SDMSDK.InitCallBack
    public final void fail(String str) {
        this.a.c.a(com.smartdigimkt.z3.b.a("10010", str));
        z zVar = this.a;
        a0 a0Var = zVar.d;
        com.smartdigimkt.h3.b bVar = zVar.b;
        zVar.getClass();
        a0Var.getClass();
        com.smartdigimkt.h3.b bVar2 = this.a.b;
        if (bVar2 != null) {
            bVar2.a("stateCheck");
        }
        z zVar2 = this.a;
        zVar2.d.d(zVar2.c);
    }

    @Override // com.smartdigimkt.sdk.api.SDMSDK.InitCallBack
    public final void success() {
        this.a.a.k();
        this.a.d.getClass();
        z zVar = this.a;
        a0 a0Var = zVar.d;
        com.smartdigimkt.v4.a aVar = zVar.c;
        a0Var.getClass();
        a0.f(aVar);
        com.smartdigimkt.v4.a aVar2 = this.a.c;
        long jCurrentTimeMillis = System.currentTimeMillis();
        com.smartdigimkt.w4.a aVar3 = aVar2.i;
        if (aVar3 != null) {
            aVar3.g = jCurrentTimeMillis;
        }
        com.smartdigimkt.h3.b bVar = this.a.b;
        if (bVar != null) {
            bVar.a("stateCheck");
        }
        z zVar2 = this.a;
        zVar2.d.a(zVar2.c);
    }
}
