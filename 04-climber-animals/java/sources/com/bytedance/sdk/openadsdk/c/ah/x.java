package com.bytedance.sdk.openadsdk.c.ah;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class x implements d {
    private int ah;
    private Map<String, Object> d;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private long f1856ms;
    private long xr;

    public void ms(int i) {
        this.ah = i;
    }

    public void ms(long j) {
        this.f1856ms = j;
    }

    public void xr(long j) {
        this.xr = j;
    }

    public void ms(Map<String, Object> map) {
        this.d = map;
    }

    @Override // com.bytedance.sdk.openadsdk.c.ah.d
    public void a_(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        Map<String, Object> map = this.d;
        if (map != null) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                try {
                    jSONObject.put(entry.getKey(), entry.getValue());
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.sl.ms(th);
                }
            }
        }
        try {
            jSONObject.put("buffers_time", this.f1856ms);
            jSONObject.put("total_duration", this.xr);
            jSONObject.put("vbtt_skip_type", this.ah);
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.sl.ms(th2);
        }
    }
}
