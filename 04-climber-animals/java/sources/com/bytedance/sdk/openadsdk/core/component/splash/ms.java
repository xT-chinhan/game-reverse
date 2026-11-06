package com.bytedance.sdk.openadsdk.core.component.splash;

import com.bytedance.sdk.openadsdk.core.g;

/* JADX INFO: loaded from: classes2.dex */
public class ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.d.ms.xr.ms.xr f2426ms;

    public void ms(com.bytedance.sdk.openadsdk.d.ms.xr.ms.xr xrVar) {
        this.f2426ms = xrVar;
    }

    public void ms() {
        com.bytedance.sdk.openadsdk.d.ms.xr.ms.xr xrVar;
        if (g.xr < 4700 || (xrVar = this.f2426ms) == null) {
            return;
        }
        xrVar.xr();
        this.f2426ms = null;
    }

    public void ms(com.bytedance.sdk.openadsdk.ao.xr.xr.xr xrVar) {
        com.bytedance.sdk.openadsdk.d.ms.xr.ms.xr xrVar2;
        if (g.xr < 4700 || (xrVar2 = this.f2426ms) == null) {
            return;
        }
        xrVar2.ms(xrVar);
    }

    public void xr() {
        com.bytedance.sdk.openadsdk.d.ms.xr.ms.xr xrVar;
        if (g.xr < 4700 || (xrVar = this.f2426ms) == null) {
            return;
        }
        xrVar.ms();
    }

    public boolean ah() {
        return g.xr < 4700 || this.f2426ms == null;
    }
}
