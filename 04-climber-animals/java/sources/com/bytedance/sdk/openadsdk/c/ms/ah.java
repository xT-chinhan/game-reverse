package com.bytedance.sdk.openadsdk.c.ms;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ah implements xr {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    xr f1859ms;

    @Override // com.bytedance.sdk.openadsdk.c.ms.xr
    public void ms(JSONObject jSONObject) throws JSONException {
        xr xrVar = this.f1859ms;
        if (xrVar != null) {
            xrVar.ms(jSONObject);
        }
        jSONObject.put("event_ts", System.currentTimeMillis());
    }
}
