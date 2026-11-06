package com.bytedance.adsdk.xr.xr.xr.ms;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class c extends h {
    public c() {
        super(com.bytedance.adsdk.xr.xr.d.ah.GT);
    }

    @Override // com.bytedance.adsdk.xr.xr.xr.ms
    public Object ms(Map<String, JSONObject> map) {
        Object objMs;
        Object objMs2 = this.f470ms.ms(map);
        if (objMs2 == null || (objMs = this.xr.ms(map)) == null) {
            return null;
        }
        return com.bytedance.adsdk.xr.xr.ka.ms.ah.ms(objMs2, (Number) objMs);
    }
}
