package com.bytedance.sdk.openadsdk.core.multipro.xr;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ms {
    public long ab;
    public boolean ah;
    public long c;
    public boolean d;
    public long ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public boolean f2932ms;
    public boolean x;
    public boolean xr;

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.multipro.xr.ms$ms, reason: collision with other inner class name */
    public interface InterfaceC0296ms {
        boolean m_();

        ms r_();
    }

    public void ms(boolean z) {
        this.x = z;
    }

    public ms xr(boolean z) {
        this.d = z;
        return this;
    }

    public ms ah(boolean z) {
        this.f2932ms = z;
        return this;
    }

    public ms d(boolean z) {
        this.xr = z;
        return this;
    }

    public ms ka(boolean z) {
        this.ah = z;
        return this;
    }

    public ms ms(long j) {
        this.ka = j;
        return this;
    }

    public ms xr(long j) {
        this.c = j;
        return this;
    }

    public ms ah(long j) {
        this.ab = j;
        return this;
    }

    public JSONObject ms() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("isCompleted", this.f2932ms);
            jSONObject.put("isFromVideoDetailPage", this.xr);
            jSONObject.put("isFromDetailPage", this.ah);
            jSONObject.put("duration", this.ka);
            jSONObject.put("totalPlayDuration", this.c);
            jSONObject.put("currentPlayPosition", this.ab);
            jSONObject.put("isAutoPlay", this.d);
            jSONObject.put("isMute", this.x);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public static ms ms(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        ms msVar = new ms();
        msVar.ah(jSONObject.optBoolean("isCompleted"));
        msVar.d(jSONObject.optBoolean("isFromVideoDetailPage"));
        msVar.ka(jSONObject.optBoolean("isFromDetailPage"));
        msVar.ms(jSONObject.optLong("duration"));
        msVar.xr(jSONObject.optLong("totalPlayDuration"));
        msVar.ah(jSONObject.optLong("currentPlayPosition"));
        msVar.xr(jSONObject.optBoolean("isAutoPlay"));
        msVar.ms(jSONObject.optBoolean("isMute"));
        return msVar;
    }
}
