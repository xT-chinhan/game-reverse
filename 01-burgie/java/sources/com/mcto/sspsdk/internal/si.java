package com.mcto.sspsdk.internal;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class si implements w3 {
    public final /* synthetic */ ji a;

    public si(ji jiVar) {
        this.a = jiVar;
    }

    @Override // com.mcto.sspsdk.internal.w3
    public final void a(Object obj) {
        if (((Integer) obj).intValue() != 1) {
            ji jiVar = this.a;
            jiVar.c.a(jiVar.b, 9, "image http err.");
            return;
        }
        ji jiVar2 = this.a;
        if (jiVar2.c.f.compareAndSet(false, true)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(jiVar2.a);
            ki kiVar = jiVar2.c;
            if (kiVar.c != null) {
                kiVar.d.post(new c3(kiVar, arrayList));
            }
        }
    }
}
