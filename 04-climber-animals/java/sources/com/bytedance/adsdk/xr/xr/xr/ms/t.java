package com.bytedance.adsdk.xr.xr.xr.ms;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class t implements com.bytedance.adsdk.xr.xr.xr.ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final String f472ms;

    public t(String str) {
        this.f472ms = str;
    }

    @Override // com.bytedance.adsdk.xr.xr.xr.ms
    public Object ms(Map<String, JSONObject> map) {
        return this.f472ms;
    }

    @Override // com.bytedance.adsdk.xr.xr.xr.ms
    public com.bytedance.adsdk.xr.xr.d.ka ms() {
        return com.bytedance.adsdk.xr.xr.d.c.STRING;
    }

    @Override // com.bytedance.adsdk.xr.xr.xr.ms
    public String xr() {
        return "'" + this.f472ms + "'";
    }

    public String toString() {
        return xr();
    }
}
