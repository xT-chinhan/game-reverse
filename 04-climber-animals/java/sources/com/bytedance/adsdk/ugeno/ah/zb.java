package com.bytedance.adsdk.ugeno.ah;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class zb {
    private JSONObject ah;
    private zb d;
    private zb ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private com.bytedance.adsdk.ugeno.xr.ah f346ms;
    private int xr;

    public com.bytedance.adsdk.ugeno.xr.ah ms() {
        return this.f346ms;
    }

    public void ms(com.bytedance.adsdk.ugeno.xr.ah ahVar) {
        this.f346ms = ahVar;
    }

    public int xr() {
        return this.xr;
    }

    public void ms(int i) {
        this.xr = i;
    }

    public JSONObject ah() {
        return this.ah;
    }

    public void ms(JSONObject jSONObject) {
        this.ah = jSONObject;
    }

    public zb d() {
        return this.d;
    }

    public void ms(zb zbVar) {
        this.d = zbVar;
    }

    public void xr(zb zbVar) {
        this.ka = zbVar;
    }

    public String toString() {
        return "UGenEvent{mWidget=" + this.f346ms + ", mEventType=" + this.xr + ", mEvent=" + this.ah + AbstractJsonLexerKt.END_OBJ;
    }
}
