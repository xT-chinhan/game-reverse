package com.bytedance.sdk.openadsdk.core.cv;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class xr {
    private JSONObject ah;
    private int d;
    private JSONObject ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private byte[] f2453ms;
    private Map<String, String> xr;

    public JSONObject ms() {
        return this.ka;
    }

    public void ms(JSONObject jSONObject) {
        this.ka = jSONObject;
    }

    public int xr() {
        return this.d;
    }

    public void ms(int i) {
        this.d = i;
    }

    public byte[] ah() {
        return this.f2453ms;
    }

    public void ms(byte[] bArr) {
        this.f2453ms = bArr;
    }

    public JSONObject d() {
        return this.ah;
    }

    public void xr(JSONObject jSONObject) {
        this.ah = jSONObject;
    }

    public Map<String, String> ka() {
        return this.xr;
    }

    public void ms(Map<String, String> map) {
        this.xr = map;
    }
}
