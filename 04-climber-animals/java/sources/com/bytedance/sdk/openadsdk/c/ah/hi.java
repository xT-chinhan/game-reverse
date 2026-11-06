package com.bytedance.sdk.openadsdk.c.ah;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class hi extends ms {
    private long ah;
    private String c;
    private int d;
    private String ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private String f1849ms;
    private long xr;

    public void ms(String str) {
        this.f1849ms = str;
    }

    public void ms(long j) {
        this.xr = j;
    }

    public void xr(long j) {
        this.ah = j;
    }

    public void ms(int i) {
        this.d = i;
    }

    public void xr(String str) {
        this.ka = str;
    }

    public void ah(String str) {
        this.c = str;
    }

    @Override // com.bytedance.sdk.openadsdk.c.ah.d
    public void a_(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("preload_url", this.f1849ms);
            jSONObject.put("preload_size", this.xr);
            jSONObject.put(com.baidu.mobads.sdk.internal.d.b, this.ah);
            jSONObject.put("error_code", this.d);
            jSONObject.put("error_message", this.ka);
            jSONObject.put("error_message_server", this.c);
            ms(jSONObject);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.sl.ms(th);
        }
    }
}
