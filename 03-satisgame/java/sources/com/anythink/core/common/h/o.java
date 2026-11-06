package com.anythink.core.common.h;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class o extends ax {
    public int a;
    public bx b;
    public long c;

    @Override // com.anythink.core.common.h.ax
    public final JSONObject a() {
        JSONObject jSONObjectO = this.b.O(this.a);
        if (jSONObjectO != null) {
            try {
                jSONObjectO.put(com.anythink.core.common.l.f.br, this.c);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return jSONObjectO;
    }
}
