package com.smartdigimkt.g4;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class m extends d {
    public final com.smartdigimkt.h0.e c;

    public m(com.smartdigimkt.h0.e eVar) {
        this.c = eVar;
    }

    @Override // com.smartdigimkt.g4.d
    public final Map e() {
        String str = this.c.c;
        HashMap map = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                map.put(next, jSONObject.optString(next));
            }
        } catch (Exception unused) {
        }
        return map;
    }

    @Override // com.smartdigimkt.g4.d
    public final byte[] h() {
        return new byte[0];
    }

    @Override // com.smartdigimkt.g4.d
    public final int j() {
        com.smartdigimkt.h0.e eVar = this.c;
        if (eVar != null) {
            return eVar.b;
        }
        return 2;
    }

    @Override // com.smartdigimkt.g4.d
    public final String k() {
        com.smartdigimkt.h0.e eVar = this.c;
        return eVar != null ? eVar.d : "";
    }
}
