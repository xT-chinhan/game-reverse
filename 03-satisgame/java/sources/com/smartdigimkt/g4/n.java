package com.smartdigimkt.g4;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class n extends d {
    public final com.smartdigimkt.f3.d c;
    public final boolean d;

    public n(com.smartdigimkt.f3.d dVar, boolean z) {
        this.c = dVar;
        this.d = z;
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
        JSONObject jSONObject;
        try {
            String str = this.c.c;
            boolean z = str != null && str.contains("gzip");
            try {
                jSONObject = new JSONObject(this.c.e);
                try {
                    if (this.d) {
                        jSONObject.put(com.anythink.core.common.l.f.T, 1);
                    }
                } catch (Exception e) {
                    e = e;
                    e.printStackTrace();
                }
            } catch (Exception e2) {
                e = e2;
                jSONObject = null;
            }
            if (z) {
                return jSONObject != null ? d.a(jSONObject.toString()) : new byte[0];
            }
            return jSONObject != null ? jSONObject.toString().getBytes() : new byte[0];
        } catch (Throwable unused) {
            return new byte[0];
        }
    }

    @Override // com.smartdigimkt.g4.d
    public final int j() {
        return this.c.b;
    }

    @Override // com.smartdigimkt.g4.d
    public final String k() {
        return this.c.d;
    }
}
