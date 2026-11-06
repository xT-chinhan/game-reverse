package com.bytedance.sdk.openadsdk.core.component.splash.ah.ah;

import com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.ab;
import com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.x;

/* JADX INFO: loaded from: classes2.dex */
public class c {
    private ah<x, ab> ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.component.splash.ah.xr.ms f2362ms;
    private com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.xr xr;

    public c(com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.xr xrVar, ah<x, ab> ahVar) {
        if (xrVar == null || ahVar == null) {
            return;
        }
        this.xr = xrVar;
        this.ah = ahVar;
        if (xrVar.hi() == 1) {
            this.f2362ms = new com.bytedance.sdk.openadsdk.core.component.splash.xr.ms.xr();
        } else {
            this.f2362ms = new com.bytedance.sdk.openadsdk.core.component.splash.xr.ms.d();
        }
    }

    public boolean ms() {
        return this.f2362ms instanceof com.bytedance.sdk.openadsdk.core.component.splash.xr.ms.d;
    }

    public void xr() {
        com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.xr xrVar = this.xr;
        if (xrVar == null || this.ah == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.component.splash.ah.xr.ms msVar = this.f2362ms;
        if (msVar instanceof com.bytedance.sdk.openadsdk.core.component.splash.xr.ms.xr) {
            msVar.ms(xrVar, new ah<x, ab>() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.ah.ah.c.1
                @Override // com.bytedance.sdk.openadsdk.core.component.splash.ah.ah.ah
                /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
                public void ah(x xVar) {
                    if (xVar != null) {
                        xVar.ka(false);
                    }
                    c.this.ah.ah(xVar);
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.splash.ah.ah.ah
                public void xr(x xVar) {
                    if (xVar != null) {
                        xVar.ka(true);
                    }
                    c.this.ah.xr(xVar);
                    com.bytedance.sdk.openadsdk.core.component.splash.c.ms(c.this.xr.sl());
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.splash.ah.ah.ah
                public void ms(ab abVar) {
                    c.this.ah.ms(abVar);
                }
            });
        } else {
            msVar.ms(xrVar, new ah<x, ab>() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.ah.ah.c.2
                @Override // com.bytedance.sdk.openadsdk.core.component.splash.ah.ah.ah
                /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
                public void ah(x xVar) {
                    if (xVar != null) {
                        xVar.ka(false);
                    }
                    c.this.ah.ah(xVar);
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.splash.ah.ah.ah
                public void xr(x xVar) {
                    if (xVar != null) {
                        xVar.ka(true);
                    }
                    c.this.ah.xr(xVar);
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.splash.ah.ah.ah
                public void ms(ab abVar) {
                    if (c.this.xr.zb() && c.this.xr.xr() != null) {
                        c.this.xr.xr().zb(1);
                    }
                    new com.bytedance.sdk.openadsdk.core.component.splash.xr.ms.xr().ms(c.this.xr, c.this.ah);
                }
            });
        }
    }
}
