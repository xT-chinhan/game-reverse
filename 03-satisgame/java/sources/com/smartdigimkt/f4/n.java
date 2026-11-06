package com.smartdigimkt.f4;

import com.smartdigimkt.sdk.api.AdError;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes3.dex */
public final class n extends b {
    public volatile CopyOnWriteArraySet r;
    public final Object s;

    public n(com.smartdigimkt.g4.l lVar) {
        super(lVar);
        this.s = new Object();
    }

    @Override // com.smartdigimkt.f4.b
    public final void b(AdError adError) {
        String code = adError.getCode();
        String message = adError.getMessage();
        com.smartdigimkt.g4.d dVar = this.d;
        String strK = dVar != null ? dVar.k() : "";
        com.smartdigimkt.g4.d dVar2 = this.d;
        com.smartdigimkt.n3.k.a("placement", code, message, strK, dVar2 instanceof com.smartdigimkt.g4.l ? ((com.smartdigimkt.g4.l) dVar2).c : "", "", "");
    }

    @Override // com.smartdigimkt.f4.b
    public final boolean d() {
        return true;
    }

    @Override // com.smartdigimkt.f4.b
    public final Object a(Object obj) {
        try {
            com.smartdigimkt.g4.d dVar = this.d;
            com.smartdigimkt.n3.k.a(this.i, System.currentTimeMillis(), "placement", dVar instanceof com.smartdigimkt.g4.l ? ((com.smartdigimkt.g4.l) dVar).c : "");
        } catch (Throwable unused) {
        }
        return obj;
    }

    public final void a(com.smartdigimkt.a4.b bVar) {
        synchronized (this.s) {
            if (this.r == null) {
                this.r = new CopyOnWriteArraySet();
            }
            this.r.add(bVar);
        }
    }
}
