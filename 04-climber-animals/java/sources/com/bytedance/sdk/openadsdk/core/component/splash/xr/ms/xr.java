package com.bytedance.sdk.openadsdk.core.component.splash.xr.ms;

import com.bytedance.sdk.component.c.hi;
import com.bytedance.sdk.component.c.u;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.ab;
import com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.x;
import com.bytedance.sdk.openadsdk.core.jw.ao;
import com.bytedance.sdk.openadsdk.core.jw.h;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.op.ny;

/* JADX INFO: loaded from: classes2.dex */
public class xr implements com.bytedance.sdk.openadsdk.core.component.splash.ah.xr.ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private ab f2447ms = new ab();

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.ah.xr.ms
    public void ms(com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.xr xrVar, com.bytedance.sdk.openadsdk.core.component.splash.ah.ah.ah<x, ab> ahVar) {
        xr(xrVar, ahVar);
    }

    private void xr(final com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.xr xrVar, final com.bytedance.sdk.openadsdk.core.component.splash.ah.ah.ah<x, ab> ahVar) {
        if (xrVar == null || ahVar == null) {
            return;
        }
        this.f2447ms.xr(xrVar.u());
        this.f2447ms.ms(xrVar.xr());
        if (re.xr().ny(xrVar.ny()) == 4) {
            x xVar = new x(xrVar.xr(), xrVar.u());
            xVar.ms(false);
            xVar.ms(xrVar.ms());
            xVar.ms(xrVar.ah());
            ahVar.xr(xVar);
            return;
        }
        com.bytedance.sdk.openadsdk.zb.xr xrVarKa = xrVar.ka();
        if (xrVarKa == null) {
            this.f2447ms.xr(2);
            this.f2447ms.ms("image request fail");
            this.f2447ms.ms(false);
            ahVar.ms(this.f2447ms);
            return;
        }
        com.bytedance.sdk.openadsdk.core.ab.ms.ms("Splash_FullLink", "加载图片素材 " + xrVar.xr().eu());
        h.ms(xrVarKa, xrVar.c(), xrVar.ab(), new h.ms() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.xr.ms.xr.1
            @Override // com.bytedance.sdk.openadsdk.core.jw.h.ms
            public void ms(com.bytedance.sdk.openadsdk.core.re.ms.xr xrVar2, hi hiVar) {
                x xVar2 = new x(xrVar2, xrVar.xr(), xrVar.u());
                xVar2.ms(false);
                xVar2.ms(xrVar.ms());
                xVar2.ka(xrVar.ah());
                if (hiVar != null) {
                    xVar2.ms(hiVar.ab());
                    xVar2.xr(hiVar.ny());
                    xVar2.xr(ao.ms(hiVar.ab()));
                    if (hiVar.ch() != null) {
                        xVar2.xr(hiVar.ch().xr());
                        xVar2.ah(hiVar.ch().ms());
                        xVar2.d(hiVar.ch().ah());
                    }
                }
                ahVar.xr(xVar2);
            }

            @Override // com.bytedance.sdk.openadsdk.core.jw.h.ms
            public void ms() {
                xr.this.f2447ms.xr(2);
                xr.this.f2447ms.ms("load image fail");
                xr.this.f2447ms.ms(false);
                ahVar.ms(xr.this.f2447ms);
            }
        }, ny.ka(), 4, new u() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.xr.ms.xr.2
            @Override // com.bytedance.sdk.component.c.u
            @ATSMethod(1)
            public void ms(int i, Object obj) {
                if (i == 3 && xr.this.ms(xrVar)) {
                    x xVar2 = new x(xrVar.xr(), xrVar.u());
                    xVar2.ms(false);
                    xVar2.ms(xrVar.ms());
                    xVar2.ms(xrVar.ah());
                    xVar2.d(true);
                    xVar2.xr(false);
                    ahVar.ah(xVar2);
                }
            }
        }, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ms(com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.xr xrVar) {
        lm lmVarXr;
        if (xrVar == null || (lmVarXr = xrVar.xr()) == null) {
            return false;
        }
        int iCe = lmVarXr.ce();
        return iCe == 3 || iCe == 4;
    }
}
