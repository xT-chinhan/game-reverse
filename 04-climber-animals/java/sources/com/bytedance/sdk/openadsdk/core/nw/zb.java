package com.bytedance.sdk.openadsdk.core.nw;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class zb extends com.bytedance.sdk.openadsdk.ao.xr.xr.ah {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private c f3118ms;

    public zb(lm lmVar) {
        if (lmVar == null) {
            return;
        }
        this.f3118ms = lmVar.ph();
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.ah
    public String ms() {
        c cVar = this.f3118ms;
        return cVar == null ? "" : cVar.u();
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.ah
    public String xr() {
        c cVar = this.f3118ms;
        return cVar == null ? "" : cVar.ka();
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.ah
    public String ah() {
        c cVar = this.f3118ms;
        return cVar == null ? "" : cVar.ab();
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.ah
    public String d() {
        c cVar = this.f3118ms;
        return cVar == null ? "" : cVar.x();
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.ah
    public Map<String, String> ka() {
        c cVar = this.f3118ms;
        if (cVar == null) {
            return null;
        }
        return cVar.ms();
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.ah
    public String c() {
        c cVar = this.f3118ms;
        if (cVar == null) {
            return null;
        }
        return cVar.xr();
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.ah
    public String ab() {
        c cVar = this.f3118ms;
        if (cVar == null) {
            return null;
        }
        return cVar.ny();
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.ah
    public String x() {
        c cVar = this.f3118ms;
        if (cVar == null) {
            return null;
        }
        return cVar.ch();
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.ah
    public String ny() {
        c cVar = this.f3118ms;
        if (cVar == null) {
            return null;
        }
        return cVar.hi();
    }
}
