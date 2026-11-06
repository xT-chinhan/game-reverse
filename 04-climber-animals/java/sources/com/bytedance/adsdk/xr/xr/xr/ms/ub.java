package com.bytedance.adsdk.xr.xr.xr.ms;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ub implements com.bytedance.adsdk.xr.xr.xr.ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private Number f473ms;

    public ub(String str) {
        if (str.indexOf(46) >= 0) {
            Float fValueOf = Float.valueOf(str);
            this.f473ms = fValueOf;
            if (Float.isInfinite(fValueOf.floatValue())) {
                this.f473ms = Double.valueOf(str);
                return;
            }
            return;
        }
        try {
            this.f473ms = Integer.valueOf(str);
        } catch (NumberFormatException unused) {
            this.f473ms = Long.valueOf(str);
        }
    }

    @Override // com.bytedance.adsdk.xr.xr.xr.ms
    public Object ms(Map<String, JSONObject> map) {
        return this.f473ms;
    }

    @Override // com.bytedance.adsdk.xr.xr.xr.ms
    public com.bytedance.adsdk.xr.xr.d.ka ms() {
        return com.bytedance.adsdk.xr.xr.d.c.NUMBER;
    }

    @Override // com.bytedance.adsdk.xr.xr.xr.ms
    public String xr() {
        return this.f473ms.toString();
    }

    public String toString() {
        return xr();
    }
}
