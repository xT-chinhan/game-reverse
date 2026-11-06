package com.bytedance.sdk.openadsdk.core.component.splash.ah.ah;

import com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.ab;
import com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.ny;

/* JADX INFO: loaded from: classes2.dex */
public class ms {
    private d<ny, ab> ah;
    private com.bytedance.sdk.openadsdk.ao.xr.xr.xr d;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.component.splash.d.xr f2373ms;
    private com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.ah xr;

    public ms(com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.ah ahVar, d<ny, ab> dVar, com.bytedance.sdk.openadsdk.core.component.splash.ms.ms msVar) {
        if (ahVar == null || dVar == null) {
            return;
        }
        this.xr = ahVar;
        this.ah = dVar;
        com.bytedance.sdk.openadsdk.core.component.splash.d.xr xrVar = new com.bytedance.sdk.openadsdk.core.component.splash.d.xr(ahVar.getContext(), ahVar.ab(), ahVar.c(), this.xr.x(), ahVar, dVar, msVar);
        this.f2373ms = xrVar;
        this.d = xrVar;
    }

    public void ms(int i) {
        com.bytedance.sdk.openadsdk.core.component.splash.d.xr xrVar = this.f2373ms;
        if (xrVar != null) {
            xrVar.xr(i);
        }
    }

    public void ms(c cVar) {
        com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.ah ahVar = this.xr;
        if (ahVar == null || ahVar.d == null || cVar == null) {
            return;
        }
        boolean zMs = cVar.ms();
        this.xr.d.ms(zMs);
        com.bytedance.sdk.openadsdk.core.component.splash.d.xr xrVar = this.f2373ms;
        if (xrVar != null) {
            xrVar.xr(zMs);
        }
    }

    public com.bytedance.sdk.openadsdk.ao.xr.xr.xr ms() {
        return this.d;
    }

    public void xr() {
        com.bytedance.sdk.openadsdk.core.component.splash.d.xr xrVar = this.f2373ms;
        if (xrVar != null) {
            xrVar.ms(this.xr, this.ah);
        }
    }
}
