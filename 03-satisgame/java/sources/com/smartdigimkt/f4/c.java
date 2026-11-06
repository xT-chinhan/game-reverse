package com.smartdigimkt.f4;

import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends b {
    public c(com.smartdigimkt.a3.a aVar) {
        com.smartdigimkt.g4.a aVar2 = new com.smartdigimkt.g4.a(aVar);
        aVar2.a = aVar.z;
        aVar2.b = "offer";
        super(aVar2);
    }

    @Override // com.smartdigimkt.f4.b
    public final void a(int i, Object obj) {
        if (obj == null) {
            a(i, com.anythink.core.common.l.q.m, "Return Empty Ad.", com.smartdigimkt.z3.b.a("10010", "Return Empty Ad."));
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(obj.toString());
            if (TextUtils.isEmpty(jSONObject.optString(com.anythink.core.common.l.f.R))) {
                a(i, com.anythink.core.common.l.q.n, "Return Empty Ad.", com.smartdigimkt.z3.b.a("10010", obj.toString()));
            } else {
                a(i, (Object) jSONObject, true);
            }
        } catch (Throwable unused) {
            a(i, com.anythink.core.common.l.q.o, "Return Empty Ad.", com.smartdigimkt.z3.b.a("10010", obj.toString()));
        }
    }
}
