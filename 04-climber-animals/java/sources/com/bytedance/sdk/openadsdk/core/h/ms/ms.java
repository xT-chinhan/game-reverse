package com.bytedance.sdk.openadsdk.core.h.ms;

import android.app.Activity;
import android.content.Context;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ms extends com.bytedance.sdk.component.ms.ka<JSONObject, JSONObject> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private String f2544ms;
    private Context xr;

    public static void ms(com.bytedance.sdk.component.ms.h hVar, Context context) {
        hVar.ms("closeView", (com.bytedance.sdk.component.ms.ka<?, ?>) new ms("closeView", context));
    }

    public ms(String str, Context context) {
        this.f2544ms = str;
        this.xr = context;
    }

    @Override // com.bytedance.sdk.component.ms.ka
    public JSONObject ms(JSONObject jSONObject, com.bytedance.sdk.component.ms.c cVar) throws Exception {
        JSONObject jSONObject2 = new JSONObject();
        String str = this.f2544ms;
        str.hashCode();
        if (str.equals("closeView")) {
            Context context = this.xr;
            if (context != null) {
                ((Activity) context).finish();
                jSONObject2.put("success", true);
            } else {
                jSONObject2.put("success", false);
            }
        }
        return jSONObject2;
    }
}
