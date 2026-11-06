package com.smartdigimkt.f4;

import com.smartdigimkt.n3.a0;
import com.smartdigimkt.sdk.api.AdError;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class m extends b {
    public m(int i, com.smartdigimkt.b3.l lVar, String str, LinkedHashMap linkedHashMap) {
        super(new com.smartdigimkt.g4.k(i, lVar, str, linkedHashMap));
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
            JSONObject jSONObject2 = ((com.smartdigimkt.g4.k) this.d).c;
            String string = jSONObject.toString();
            String string2 = jSONObject2 != null ? jSONObject2.toString() : "";
            String strK = this.d.k();
            a0.a().a(this.d.j(), strK, string, string2, com.smartdigimkt.f3.d.a(1000));
            com.smartdigimkt.n3.k.a("tk", adError.getCode(), adError.getMessage(), strK, "", "1", "");
        } catch (Throwable unused2) {
        }
    }

    @Override // com.smartdigimkt.f4.b
    public final boolean e() {
        return false;
    }
}
