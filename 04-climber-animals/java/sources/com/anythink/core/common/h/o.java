package com.anythink.core.common.h;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class o extends av {
    public int a;
    public bu b;
    public long c;

    @Override // com.anythink.core.common.h.av
    public final JSONObject a() {
        JSONObject jSONObjectO = this.b.O(this.a);
        if (jSONObjectO != null) {
            try {
                jSONObjectO.put("sdk_time", this.c);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return jSONObjectO;
    }
}
