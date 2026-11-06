package com.byazt.shr;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1216, 101})
public class fs implements q {
    public long n;
    public Map<String, Object> q;
    public long qg;
    public int s;

    public void n(int i) {
        this.s = i;
    }

    public void n(long j) {
        this.n = j;
    }

    public void qg(long j) {
        this.qg = j;
    }

    public void n(Map<String, Object> map) {
        this.q = map;
    }

    @Override // com.byazt.shr.q
    public void n(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        Map<String, Object> map = this.q;
        if (map != null) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                try {
                    jSONObject.put(entry.getKey(), entry.getValue());
                } catch (Throwable unused) {
                }
            }
        }
        try {
            jSONObject.put("buffers_time", this.n);
            jSONObject.put("total_duration", this.qg);
            jSONObject.put("vbtt_skip_type", this.s);
        } catch (Throwable unused2) {
        }
    }
}
