package com.smartdigimkt.f4;

import com.smartdigimkt.n3.a0;
import com.smartdigimkt.sdk.api.AdError;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class q extends b {
    public final List r;

    public q(int i, ArrayList arrayList) {
        super(new com.smartdigimkt.g4.o(i, arrayList));
        this.r = arrayList;
    }

    @Override // com.smartdigimkt.f4.b
    public final void a(AdError adError) {
        JSONObject jSONObject = new JSONObject();
        Map mapE = this.d.e();
        if (mapE != null) {
            try {
                HashMap map = (HashMap) mapE;
                for (String str : map.keySet()) {
                    jSONObject.put(str, map.get(str));
                }
            } catch (Exception unused) {
            }
        }
        try {
            String string = jSONObject.toString();
            com.smartdigimkt.g4.d dVar = this.d;
            ((com.smartdigimkt.g4.o) dVar).f = true;
            String strI = dVar.i();
            com.smartdigimkt.g4.d dVar2 = this.d;
            ((com.smartdigimkt.g4.o) dVar2).f = false;
            String strK = dVar2.k();
            a0.a().a(this.d.j(), strK, string, strI, com.smartdigimkt.f3.d.a(1000));
        } catch (Throwable unused2) {
        }
    }

    @Override // com.smartdigimkt.f4.b
    public final void b(AdError adError) {
        List list = this.r;
        com.smartdigimkt.n3.k.a("tk", adError.getCode(), adError.getMessage(), this.d.k(), (String) null, String.valueOf(list != null ? list.size() : 1), String.valueOf(0));
    }

    @Override // com.smartdigimkt.f4.b
    public final boolean c() {
        return true;
    }
}
