package com.bytedance.sdk.openadsdk.core.component.splash.xr.ms;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.ka;
import com.bytedance.sdk.component.utils.u;
import com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.ab;
import com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.x;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.qr;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.op.ny;

/* JADX INFO: loaded from: classes2.dex */
public class d implements com.bytedance.sdk.openadsdk.core.component.splash.ah.xr.ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private ab f2441ms = new ab();

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.ah.xr.ms
    public void ms(com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.xr xrVar, com.bytedance.sdk.openadsdk.core.component.splash.ah.ah.ah<x, ab> ahVar) {
        xr(xrVar, ahVar);
    }

    private void xr(com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.xr xrVar, com.bytedance.sdk.openadsdk.core.component.splash.ah.ah.ah<x, ab> ahVar) {
        com.bykv.vk.openvk.component.video.api.ah.d dVarMs;
        if (xrVar == null || ahVar == null) {
            return;
        }
        this.f2441ms.xr(xrVar.u());
        this.f2441ms.ms(xrVar.xr());
        int iNy = xrVar.ny();
        com.bykv.vk.openvk.component.video.api.ah.ah ahVarX = xrVar.x();
        this.f2441ms.ms(true);
        if (ahVarX == null) {
            this.f2441ms.xr(2);
            this.f2441ms.ms("no video info");
            ahVar.ms(this.f2441ms);
            return;
        }
        String strSl = ahVarX.sl();
        if (TextUtils.isEmpty(strSl)) {
            this.f2441ms.xr(2);
            this.f2441ms.ms("no video url");
            ahVar.ms(this.f2441ms);
            return;
        }
        String strUb = ahVarX.ub();
        if (TextUtils.isEmpty(strUb)) {
            strUb = ka.xr(strSl);
        }
        if (TextUtils.isEmpty(strUb)) {
            this.f2441ms.xr(2);
            this.f2441ms.ms("no video cahce filename");
            ahVar.ms(this.f2441ms);
            return;
        }
        com.bytedance.sdk.openadsdk.core.ab.ms.ms("Splash_FullLink", "加载视频素材");
        lm lmVarXr = xrVar.xr();
        if (lmVarXr == null) {
            return;
        }
        boolean zCh = xrVar.ch();
        ahVarX.ka(1);
        if (ahVarX.ao() == 0) {
            ahVarX.d(307200);
        }
        if (zCh) {
            dVarMs = qr.ms(2, lmVarXr);
        } else {
            dVarMs = qr.ms(3, lmVarXr);
        }
        dVarMs.ms("material_meta", lmVarXr);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (ny.ms(lmVarXr.pd()).ms(dVarMs)) {
            x xVar = new x(xrVar.xr(), xrVar.u());
            xVar.ms(true);
            xVar.ah(true);
            xVar.ms(xrVar.ms());
            xVar.ka(xrVar.ah());
            ahVar.xr(xVar);
            dVarMs.ny(1);
            com.bytedance.sdk.openadsdk.core.video.d.xr.ms(dVarMs, lmVarXr, SystemClock.elapsedRealtime() - jElapsedRealtime);
            return;
        }
        if (re.xr().x(String.valueOf(iNy)) && !u.d(re.getContext())) {
            this.f2441ms.xr(2);
            this.f2441ms.ms("network error");
            ahVar.ms(this.f2441ms);
        } else {
            if (xrVar.xr() != null && xrVar.xr().vl() == 3) {
                x xVar2 = new x(xrVar.xr(), xrVar.u());
                xVar2.ms(true);
                xVar2.ah(false);
                xVar2.ms(xrVar.ms());
                xVar2.ka(xrVar.ah());
                xVar2.ms(qr.ms(xrVar.xr()));
                ahVar.xr(xVar2);
                return;
            }
            com.bykv.vk.openvk.component.video.ms.ms.ms();
            ms(dVarMs, xrVar, xrVar.xr(), ahVar);
        }
    }

    private void ms(com.bykv.vk.openvk.component.video.api.ah.d dVar, final com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.xr xrVar, lm lmVar, final com.bytedance.sdk.openadsdk.core.component.splash.ah.ah.ah<x, ab> ahVar) {
        if (lmVar == null || ahVar == null || xrVar == null || dVar == null || qr.u(lmVar) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.video.d.xr.ms(dVar, new com.bykv.vk.openvk.component.video.api.ka.xr() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.xr.ms.d.1
            @Override // com.bykv.vk.openvk.component.video.api.ka.ms.InterfaceC0178ms
            public void ms(com.bykv.vk.openvk.component.video.api.ah.d dVar2, int i) {
                if (ahVar != null) {
                    x xVar = new x(xrVar.xr(), xrVar.u());
                    xVar.ms(true);
                    xVar.ah(false);
                    xVar.ms((com.bytedance.sdk.component.ny.xr) null);
                    xVar.ms(xrVar.ms());
                    xVar.ka(xrVar.ah());
                    ahVar.xr(xVar);
                }
            }

            @Override // com.bykv.vk.openvk.component.video.api.ka.ms.InterfaceC0178ms
            public void ms(com.bykv.vk.openvk.component.video.api.ah.d dVar2, int i, String str) {
                if (ahVar != null) {
                    d.this.f2441ms.xr(2);
                    d.this.f2441ms.ms("preload video fail");
                    ahVar.ms(d.this.f2441ms);
                }
            }
        });
    }
}
