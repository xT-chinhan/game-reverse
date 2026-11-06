package com.byazt.pb;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 868, 8})
public class s implements com.byazt.ew.s {
    public com.byazt.gcl.s n;

    public s(com.byazt.gcl.s sVar) {
        this.n = sVar;
    }

    @Override // com.byazt.ew.s
    public void n(String str, JSONObject jSONObject) {
        com.byazt.gcl.s sVar = this.n;
        if (sVar != null) {
            sVar.qg(str, jSONObject);
        }
    }
}
