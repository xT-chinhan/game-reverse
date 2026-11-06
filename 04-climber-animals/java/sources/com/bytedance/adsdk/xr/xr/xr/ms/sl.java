package com.bytedance.adsdk.xr.xr.xr.ms;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class sl extends h {
    public sl() {
        super(com.bytedance.adsdk.xr.xr.d.ah.MOD);
    }

    @Override // com.bytedance.adsdk.xr.xr.xr.ms
    public Object ms(Map<String, JSONObject> map) {
        Object objMs;
        Object objMs2 = this.f470ms.ms(map);
        if (objMs2 == null || (objMs = this.xr.ms(map)) == null) {
            return null;
        }
        return com.bytedance.adsdk.xr.xr.ka.ms.c.ms((Number) objMs2, (Number) objMs);
    }
}
