package com.bytedance.adsdk.xr.xr.xr.ms;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class y implements com.bytedance.adsdk.xr.xr.xr.xr {
    private com.bytedance.adsdk.xr.xr.xr.ms ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private com.bytedance.adsdk.xr.xr.xr.ms f474ms;
    private com.bytedance.adsdk.xr.xr.xr.ms xr;

    @Override // com.bytedance.adsdk.xr.xr.xr.ms
    public Object ms(Map<String, JSONObject> map) {
        Object objMs = this.f474ms.ms(map);
        if (objMs == null) {
            return null;
        }
        if (((Boolean) objMs).booleanValue()) {
            return this.xr.ms(map);
        }
        return this.ah.ms(map);
    }

    @Override // com.bytedance.adsdk.xr.xr.xr.ms
    public com.bytedance.adsdk.xr.xr.d.ka ms() {
        return com.bytedance.adsdk.xr.xr.d.c.OPERATOR_RESULT;
    }

    @Override // com.bytedance.adsdk.xr.xr.xr.xr
    public void ms(com.bytedance.adsdk.xr.xr.xr.ms msVar) {
        this.f474ms = msVar;
    }

    @Override // com.bytedance.adsdk.xr.xr.xr.xr
    public void xr(com.bytedance.adsdk.xr.xr.xr.ms msVar) {
        this.xr = msVar;
    }

    @Override // com.bytedance.adsdk.xr.xr.xr.xr
    public void ah(com.bytedance.adsdk.xr.xr.xr.ms msVar) {
        this.ah = msVar;
    }

    @Override // com.bytedance.adsdk.xr.xr.xr.ms
    public String xr() {
        return this.f474ms.xr() + "?" + this.xr.xr() + ":" + this.ah.xr();
    }

    public String toString() {
        return xr();
    }
}
