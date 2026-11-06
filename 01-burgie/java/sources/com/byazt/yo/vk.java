package com.byazt.yo;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1051, 50})
public class vk extends pr {
    public long hw;
    public String pr;

    public vk(String str, long j) {
        this.pr = str;
        this.hw = j;
    }

    @Override // com.byazt.yo.x
    public void pr(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("preload_url", this.pr);
            jSONObject.put("preload_size", this.hw);
        } catch (Throwable th) {
        }
    }
}
