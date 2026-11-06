package com.mcto.sspsdk.internal;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class jk implements f7 {
    public final /* synthetic */ lk a;

    public jk(lk lkVar) {
        this.a = lkVar;
    }

    @Override // com.mcto.sspsdk.internal.f7
    public final void a(vh vhVar) {
        lk lkVar = this.a;
        lkVar.h = vhVar.m == 0;
        lkVar.c = vhVar;
        p pVar = null;
        ArrayList arrayList = vhVar.b;
        if (arrayList == null || arrayList.isEmpty()) {
            lk lkVar2 = this.a;
            lkVar2.e = 3;
            lkVar2.f = "no ads！";
        } else {
            pVar = (p) arrayList.get(0);
            if (lj.b(pVar.G)) {
                lk lkVar3 = this.a;
                lkVar3.e = 4;
                lkVar3.f = "empty url or empty renderType.";
            }
        }
        lk lkVar4 = this.a;
        lkVar4.g = vhVar.a.f;
        lkVar4.b = pVar;
        lkVar4.a();
    }

    @Override // com.mcto.sspsdk.internal.f7
    public final void a(vh vhVar, int i, String str) {
        lk lkVar = this.a;
        lkVar.e = i;
        lkVar.f = str;
        lkVar.h = false;
        if (vhVar != null) {
            lkVar.c = vhVar;
            lkVar.h = vhVar.m == 0;
            lkVar.g = vhVar.a.f;
        }
        lkVar.a();
    }
}
