package com.byazt.mm;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 2020, 37})
public class pr {
    public long c;
    public long fw;
    public boolean hn;
    public boolean hw;
    public boolean pr;
    public long uc;
    public boolean x;
    public boolean zo;

    /* JADX INFO: renamed from: com.byazt.mm.pr$pr, reason: collision with other inner class name */
    public interface InterfaceC0136pr {
        boolean l_();

        pr q_();
    }

    public void pr(boolean z) {
        this.zo = z;
    }

    public pr hw(boolean z) {
        this.x = z;
        return this;
    }

    public pr hn(boolean z) {
        this.pr = z;
        return this;
    }

    public pr x(boolean z) {
        this.hw = z;
        return this;
    }

    public pr c(boolean z) {
        this.hn = z;
        return this;
    }

    public pr pr(long j) {
        this.c = j;
        return this;
    }

    public pr hw(long j) {
        this.uc = j;
        return this;
    }

    public pr hn(long j) {
        this.fw = j;
        return this;
    }

    public JSONObject pr() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("isCompleted", this.pr);
            jSONObject.put("isFromVideoDetailPage", this.hw);
            jSONObject.put("isFromDetailPage", this.hn);
            jSONObject.put("duration", this.c);
            jSONObject.put("totalPlayDuration", this.uc);
            jSONObject.put("currentPlayPosition", this.fw);
            jSONObject.put("isAutoPlay", this.x);
            jSONObject.put("isMute", this.zo);
        } catch (Exception e) {
        }
        return jSONObject;
    }

    public static pr pr(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        pr prVar = new pr();
        prVar.hn(jSONObject.optBoolean("isCompleted"));
        prVar.x(jSONObject.optBoolean("isFromVideoDetailPage"));
        prVar.c(jSONObject.optBoolean("isFromDetailPage"));
        prVar.pr(jSONObject.optLong("duration"));
        prVar.hw(jSONObject.optLong("totalPlayDuration"));
        prVar.hn(jSONObject.optLong("currentPlayPosition"));
        prVar.hw(jSONObject.optBoolean("isAutoPlay"));
        prVar.pr(jSONObject.optBoolean("isMute"));
        return prVar;
    }
}
