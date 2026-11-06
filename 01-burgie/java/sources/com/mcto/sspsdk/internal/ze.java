package com.mcto.sspsdk.internal;

import com.mcto.sspsdk.QyVideoPlayOption;

/* JADX INFO: loaded from: classes2.dex */
public final class ze implements w9 {
    public final /* synthetic */ gf a;

    public ze(gf gfVar) {
        this.a = gfVar;
    }

    @Override // com.mcto.sspsdk.internal.w9
    public final void a(Object obj) {
        gf gfVar = this.a;
        int i = gfVar.l;
        gfVar.f = ((Boolean) obj).booleanValue();
        gf gfVar2 = this.a;
        if (!gfVar2.f) {
            gfVar2.g();
            this.a.a();
            return;
        }
        synchronized (gfVar2) {
            QyVideoPlayOption qyVideoPlayOption = gfVar2.F;
            if (qyVideoPlayOption != QyVideoPlayOption.MANUAL && (qyVideoPlayOption != QyVideoPlayOption.WIFI || gfVar2.f)) {
                if (gfVar2.k == null) {
                    gfVar2.k = new v3(gfVar2, gfVar2.p, 300L);
                }
                gfVar2.k.a(gfVar2.K);
            }
        }
    }
}
