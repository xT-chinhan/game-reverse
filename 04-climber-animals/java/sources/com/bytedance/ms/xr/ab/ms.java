package com.bytedance.ms.xr.ab;

import android.content.Context;
import com.bytedance.ms.xr.x;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static volatile ms f553ms;
    private volatile Context xr;

    public static ms ms() {
        if (f553ms == null) {
            f553ms = new ms(x.d());
        }
        return f553ms;
    }

    private ms(Context context) {
        this.xr = context;
    }

    public String ms(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.length() > 0) {
            try {
                return com.bytedance.ms.xr.x.d.ms(com.bytedance.ms.xr.x.x.ms(this.xr), com.bytedance.ms.xr.x.x.ms(), xr.ms(x.ms().ms()), jSONObject, xr.ms());
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public void xr(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() <= 0) {
            return;
        }
        try {
            String strMs = xr.ms(x.ms().ms());
            String strMs2 = com.bytedance.ms.xr.x.d.ms(com.bytedance.ms.xr.x.x.ms(this.xr), com.bytedance.ms.xr.x.x.xr(), strMs, jSONObject, xr.xr());
            jSONObject.put("upload_scene", "direct");
            if (xr.ms(strMs, jSONObject.toString()).ms()) {
                com.bytedance.ms.xr.x.d.ms(strMs2);
            }
        } catch (Throwable unused) {
        }
    }
}
