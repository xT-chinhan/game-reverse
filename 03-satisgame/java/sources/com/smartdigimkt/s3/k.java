package com.smartdigimkt.s3;

import com.smartdigimkt.v2.p;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class k implements Runnable {
    public final /* synthetic */ l a;

    public k(l lVar) {
        this.a = lVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.smartdigimkt.h3.b bVar = this.a.b;
        if (bVar != null) {
            synchronized (bVar) {
            }
        }
        l lVar = this.a;
        JSONObject jSONObjectA = m.a(lVar.e, lVar.c, lVar.d);
        com.smartdigimkt.h3.b bVar2 = this.a.b;
        if (jSONObjectA != null && com.smartdigimkt.r4.h.z()) {
            try {
                jSONObjectA.put(com.anythink.core.bridge.a.b.k, p.c().d());
                jSONObjectA.put(com.anythink.core.bridge.a.b.l, p.c().d);
            } catch (Throwable unused) {
            }
        }
        this.a.a.onComplete(jSONObjectA);
        com.smartdigimkt.h3.b bVar3 = this.a.b;
    }
}
