package com.smartdigimkt.f4;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends b {
    public f(com.smartdigimkt.g4.e eVar) {
        super(eVar);
    }

    @Override // com.smartdigimkt.f4.b
    public final Object a(Object obj) {
        com.smartdigimkt.p4.e eVar;
        try {
            com.smartdigimkt.g4.d dVar = this.d;
            String str = "";
            if ((dVar instanceof com.smartdigimkt.g4.e) && (eVar = ((com.smartdigimkt.g4.e) dVar).e) != null) {
                str = eVar.e;
            }
            com.smartdigimkt.n3.k.a(this.i, System.currentTimeMillis(), "bid", str);
            return new JSONObject(obj.toString());
        } catch (Throwable unused) {
            return null;
        }
    }
}
