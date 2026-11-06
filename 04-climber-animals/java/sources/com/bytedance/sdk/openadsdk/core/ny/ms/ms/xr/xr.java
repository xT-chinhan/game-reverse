package com.bytedance.sdk.openadsdk.core.ny.ms.ms.xr;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class xr implements com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.video.xr.xr f3154ms;
    private com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms xr;

    public xr(com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms msVar, com.bytedance.sdk.openadsdk.core.video.xr.xr xrVar) {
        this.xr = msVar;
        this.f3154ms = xrVar;
    }

    public xr(com.bytedance.sdk.openadsdk.core.video.xr.xr xrVar) {
        this.f3154ms = xrVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms
    public boolean ms(Map<String, Object> map) {
        com.bytedance.sdk.openadsdk.core.video.xr.xr xrVar = this.f3154ms;
        if (xrVar == null) {
            return this.xr.ms(map);
        }
        if (xrVar.ms()) {
            return true;
        }
        com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms msVar = this.xr;
        if (msVar == null) {
            return false;
        }
        return msVar.ms(map);
    }
}
