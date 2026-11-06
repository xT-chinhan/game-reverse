package com.smartdigimkt.f4;

import com.smartdigimkt.n3.a0;
import com.smartdigimkt.sdk.api.AdError;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class j extends b {
    public final JSONObject r;

    public j(int i, com.smartdigimkt.e3.a aVar, String str) {
        com.smartdigimkt.g4.h hVar = new com.smartdigimkt.g4.h(i, aVar, str);
        super(hVar);
        if (hVar instanceof com.smartdigimkt.g4.h) {
            this.r = hVar.d;
        }
    }

    @Override // com.smartdigimkt.f4.b
    public final void a(AdError adError) {
        try {
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
            String string = jSONObject.toString();
            JSONObject jSONObject2 = this.r;
            String string2 = jSONObject2 != null ? jSONObject2.toString() : "";
            String strK = this.d.k();
            a0.a().a(this.d.j(), strK, string, string2, com.smartdigimkt.f3.d.a(1000));
            com.smartdigimkt.n3.k.a("tk", adError.getCode(), adError.getMessage(), strK, "", "1", "");
        } catch (Throwable unused2) {
        }
    }
}
