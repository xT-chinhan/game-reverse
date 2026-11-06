package com.smartdigimkt.j;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class o implements com.smartdigimkt.k.n {
    public final /* synthetic */ com.smartdigimkt.k.r a;
    public final /* synthetic */ u b;

    public o(u uVar, com.smartdigimkt.k.r rVar) {
        this.b = uVar;
        this.a = rVar;
    }

    @Override // com.smartdigimkt.k.n
    public final void onCallback(com.smartdigimkt.k.r rVar) {
        if (rVar != null) {
            com.smartdigimkt.k.r rVar2 = this.a;
            rVar2.A = rVar.A;
            rVar2.B = rVar.B;
            rVar2.C = rVar.C;
            rVar2.D = rVar.D;
            if (TextUtils.isEmpty(rVar.E)) {
                rVar.E = "1";
            }
            rVar2.E = rVar.E;
            com.smartdigimkt.k.r rVar3 = this.a;
            rVar3.F = rVar.F;
            rVar3.G = rVar.G;
            rVar3.x = rVar.x;
            rVar3.z = rVar.b();
            com.smartdigimkt.k.r rVar4 = this.a;
            rVar4.h = rVar.h;
            rVar4.i = rVar.i;
        }
        this.b.c(this.a);
    }
}
