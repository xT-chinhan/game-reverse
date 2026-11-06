package com.byazt.cs;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 2264, 19})
public class n {
    public boolean fs;
    public long l;
    public boolean n;
    public boolean q;
    public boolean qg;
    public boolean s;
    public long w;
    public long x;

    /* JADX INFO: renamed from: com.byazt.cs.n$n, reason: collision with other inner class name */
    public interface InterfaceC0149n {
        n t();

        boolean ur();
    }

    public void n(boolean z) {
        this.fs = z;
    }

    public n qg(boolean z) {
        this.q = z;
        return this;
    }

    public n s(boolean z) {
        this.n = z;
        return this;
    }

    public n q(boolean z) {
        this.qg = z;
        return this;
    }

    public n l(boolean z) {
        this.s = z;
        return this;
    }

    public n n(long j) {
        this.l = j;
        return this;
    }

    public n qg(long j) {
        this.w = j;
        return this;
    }

    public n s(long j) {
        this.x = j;
        return this;
    }

    public JSONObject n() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("isCompleted", this.n);
            jSONObject.put("isFromVideoDetailPage", this.qg);
            jSONObject.put("isFromDetailPage", this.s);
            jSONObject.put(MediationConstant.EXTRA_DURATION, this.l);
            jSONObject.put("totalPlayDuration", this.w);
            jSONObject.put("currentPlayPosition", this.x);
            jSONObject.put("isAutoPlay", this.q);
            jSONObject.put("isMute", this.fs);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public static n n(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        n nVar = new n();
        nVar.s(jSONObject.optBoolean("isCompleted"));
        nVar.q(jSONObject.optBoolean("isFromVideoDetailPage"));
        nVar.l(jSONObject.optBoolean("isFromDetailPage"));
        nVar.n(jSONObject.optLong(MediationConstant.EXTRA_DURATION));
        nVar.qg(jSONObject.optLong("totalPlayDuration"));
        nVar.s(jSONObject.optLong("currentPlayPosition"));
        nVar.qg(jSONObject.optBoolean("isAutoPlay"));
        nVar.n(jSONObject.optBoolean("isMute"));
        return nVar;
    }
}
