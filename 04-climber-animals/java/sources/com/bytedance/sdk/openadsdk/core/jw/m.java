package com.bytedance.sdk.openadsdk.core.jw;

import android.util.Pair;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class m extends com.bytedance.sdk.component.ny.xr.ka {
    public m(com.bytedance.sdk.component.xr.ms.sl slVar) {
        super(slVar);
    }

    public void ms(JSONObject jSONObject, String str) {
        Pair<Integer, ?> pairMs;
        try {
            pairMs = com.bytedance.sdk.openadsdk.core.ah.c.ms().ms(jSONObject.toString(), str);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.sl.xr(th.getMessage());
            pairMs = null;
        }
        if (pairMs != null && pairMs.first != null) {
            if (((Integer) pairMs.first).intValue() == 4) {
                ms("application/octet-stream", (byte[]) pairMs.second);
                ms(true);
                xr("x-pglcypher", String.valueOf(pairMs.first));
                return;
            }
            ms((JSONObject) pairMs.second);
            return;
        }
        ah(com.bytedance.sdk.component.utils.ms.ms(jSONObject).toString());
    }

    public void xr(JSONObject jSONObject, String str) {
        if (com.bytedance.sdk.openadsdk.core.re.xr().o()) {
            ms(jSONObject, str);
        } else {
            ah(com.bytedance.sdk.component.utils.ms.ms(jSONObject).toString());
        }
    }

    public void ah(JSONObject jSONObject, String str) {
        if (com.bytedance.sdk.openadsdk.core.re.xr().nn()) {
            ms(jSONObject, str);
        } else {
            ah(com.bytedance.sdk.component.utils.ms.ms(jSONObject).toString());
        }
    }
}
