package com.bytedance.sdk.openadsdk.c.ah;

import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ub implements d {
    private int ab;
    private int ah;
    private JSONArray c;
    private int ch;
    private int d;
    private boolean hi;
    private String ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private long f1855ms;
    private long ny;
    private long x;
    private long xr;

    public void ms(boolean z) {
        this.hi = z;
    }

    public void ms(long j) {
        this.ny = j;
    }

    public void ms(int i) {
        this.ch = i;
    }

    public void ms(JSONArray jSONArray) {
        this.c = jSONArray;
    }

    public void xr(long j) {
        this.x = j;
    }

    public void xr(int i) {
        this.ab = i;
    }

    public void ah(long j) {
        this.f1855ms = j;
    }

    public void d(long j) {
        this.xr = j;
    }

    public void ah(int i) {
        this.ah = i;
    }

    public void d(int i) {
        this.d = i;
    }

    public void ms(String str) {
        this.ka = str;
    }

    @Override // com.bytedance.sdk.openadsdk.c.ah.d
    public void a_(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("buffers_time", this.f1855ms);
            jSONObject.put("total_duration", this.xr);
            jSONObject.put("error_code", this.ah);
            jSONObject.put("extra_error_code", this.d);
            jSONObject.put("error_message", this.ka);
            jSONObject.put("event_list", this.c);
            jSONObject.put("vbtt_skip_type", this.ab);
            jSONObject.put("video_cache_size", this.x);
            jSONObject.put("current", this.ny);
            jSONObject.put("percent", this.ch);
            jSONObject.put("has_endcard_skip", this.hi);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.sl.ms(th);
        }
    }
}
