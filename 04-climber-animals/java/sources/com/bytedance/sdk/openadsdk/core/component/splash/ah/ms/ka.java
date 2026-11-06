package com.bytedance.sdk.openadsdk.core.component.splash.ah.ms;

import com.bytedance.sdk.openadsdk.core.nw.e;

/* JADX INFO: loaded from: classes2.dex */
public class ka extends ms {
    public static int d = 1;
    public static int ka = 2;
    private e ab;
    private com.bytedance.sdk.openadsdk.ao.xr.ah.xr c;
    private String x;

    public ka(com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, e eVar) {
        this.c = xrVar;
        this.ab = eVar;
        if (xrVar != null) {
            this.x = xrVar.d();
        }
    }

    public com.bytedance.sdk.openadsdk.ao.xr.ah.xr d() {
        return this.c;
    }

    public e ka() {
        return this.ab;
    }

    public String c() {
        return this.x;
    }
}
