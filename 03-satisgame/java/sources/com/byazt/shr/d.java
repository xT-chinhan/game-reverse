package com.byazt.shr;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1216, 113})
public class d extends n {
    public String l;
    public String n;
    public int q;
    public long qg;
    public long s;
    public String w;

    public void n(String str) {
        this.n = str;
    }

    public void n(long j) {
        this.qg = j;
    }

    public void qg(long j) {
        this.s = j;
    }

    public void n(int i) {
        this.q = i;
    }

    public void qg(String str) {
        this.l = str;
    }

    public void s(String str) {
        this.w = str;
    }

    @Override // com.byazt.shr.q
    public void n(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("preload_url", this.n);
            jSONObject.put("preload_size", this.qg);
            jSONObject.put("load_time", this.s);
            jSONObject.put("error_code", this.q);
            jSONObject.put("error_message", this.l);
            jSONObject.put("error_message_server", this.w);
        } catch (Throwable unused) {
        }
    }
}
