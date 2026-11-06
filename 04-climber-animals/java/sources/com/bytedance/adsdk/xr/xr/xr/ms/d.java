package com.bytedance.adsdk.xr.xr.xr.ms;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class d extends h {
    public d() {
        super(com.bytedance.adsdk.xr.xr.d.ah.EQ);
    }

    @Override // com.bytedance.adsdk.xr.xr.xr.ms
    public Object ms(Map<String, JSONObject> map) {
        Object objMs = this.f470ms.ms(map);
        Object objMs2 = this.xr.ms(map);
        if (objMs == null && objMs2 == null) {
            return Boolean.TRUE;
        }
        if (objMs == null && objMs2 != null) {
            return Boolean.FALSE;
        }
        if (objMs != null && objMs2 == null) {
            return Boolean.FALSE;
        }
        if ((objMs instanceof Number) && (objMs2 instanceof Number)) {
            return Boolean.valueOf(com.bytedance.adsdk.xr.xr.ka.ms.xr.ms((Number) objMs, (Number) objMs2));
        }
        return Boolean.valueOf(objMs.equals(objMs2));
    }
}
