package com.bytedance.sdk.openadsdk.core.component.reward.ms;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.anythink.basead.webtemplet.a.b;
import com.bytedance.sdk.component.ch.ny;
import com.bytedance.sdk.openadsdk.core.nw.e;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.op.ab;

/* JADX INFO: loaded from: classes2.dex */
public abstract class xr {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected Context f2229ms;
    private com.bytedance.sdk.openadsdk.core.ka.ka.d xr;

    protected abstract boolean xr();

    protected xr(Context context) {
        this.f2229ms = context == null ? re.getContext() : context.getApplicationContext();
        this.xr = new com.bytedance.sdk.openadsdk.core.ka.ka.d(xr() ? 7 : 8);
    }

    public void ms(final String str) {
        ab.ms(new ny("rewardFull preloadOnDestroy") { // from class: com.bytedance.sdk.openadsdk.core.component.reward.ms.xr.1
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVarMs = com.bytedance.sdk.openadsdk.core.component.reward.ms.ms.xr.ms().ms(str);
                if (xrVarMs == null || TextUtils.isEmpty(xrVarMs.d())) {
                    return;
                }
                int i = xr.this.xr() ? 7 : 8;
                lm lmVarMs = com.bytedance.sdk.openadsdk.core.ka.d.d.ms(i).ms(xrVarMs.d(), false, 0L);
                if (re.xr().xr(xrVarMs.d()) && lmVarMs != null) {
                    if (lmVarMs.f() + lmVarMs.re() < System.currentTimeMillis()) {
                        com.bytedance.sdk.openadsdk.core.ka.d.d.ms(i).ms(xrVarMs.d());
                    }
                }
                if (lmVarMs == null) {
                    xr.this.ms(xrVarMs);
                }
            }
        });
    }

    public void ms(com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar) {
        if (this.xr != null) {
            this.xr.ms(xrVar, ms(xrVar, null, true, null));
        }
    }

    public void ms(com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, ah ahVar) {
        if (xrVar != null) {
            xrVar.d();
        }
        ms(xrVar, ahVar, null);
    }

    public void ms(com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, final ah ahVar, com.bytedance.sdk.openadsdk.core.component.reward.business.xr.ah ahVar2) {
        boolean z = (ahVar2 == null || !ahVar2.ah()) && com.bytedance.sdk.openadsdk.core.live.ka.d.ms(xrVar.b());
        e eVarMs = ms(xrVar, ahVar2, false, ahVar);
        com.bytedance.sdk.openadsdk.core.ka.ka.d dVar = this.xr;
        if (dVar != null) {
            dVar.ms(xrVar, eVarMs, z ? -1 : 0, new com.bytedance.sdk.openadsdk.core.ka.ka.ka() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.ms.xr.2
                @Override // com.bytedance.sdk.openadsdk.core.ka.ka.ka
                public void ms(Object obj) {
                    ah ahVar3 = ahVar;
                    if (ahVar3 != null) {
                        ahVar3.ms(obj);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.ka.ka.ka
                public void xr(Object obj) {
                    ah ahVar3 = ahVar;
                    if (ahVar3 != null) {
                        ahVar3.xr(obj);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.ka.ka.ka
                public void ms(int i, String str) {
                    ah ahVar3 = ahVar;
                    if (ahVar3 != null) {
                        ahVar3.ms(i, str);
                    }
                }
            });
        }
    }

    private e ms(com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, com.bytedance.sdk.openadsdk.core.component.reward.business.xr.ah ahVar, boolean z, ah ahVar2) {
        boolean z2;
        e eVar = new e();
        if (z) {
            eVar.f3048ms = 2;
        }
        if (re.xr().ch(xrVar.d()) || xrVar.x() > 0.0f) {
            eVar.c = 2;
        }
        if (ahVar == null || !ahVar.ah()) {
            z2 = false;
        } else {
            eVar.xr = ahVar.ms();
            eVar.ah = ahVar.xr();
            z2 = true;
            eVar.d = 1;
        }
        if (ahVar2 != null) {
            eVar.x = ahVar2.ms();
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_playAgain", z2);
        bundle.putBoolean(b.c.i, z);
        bundle.putLong("start_time", eVar.x);
        eVar.ub = bundle;
        return eVar;
    }
}
