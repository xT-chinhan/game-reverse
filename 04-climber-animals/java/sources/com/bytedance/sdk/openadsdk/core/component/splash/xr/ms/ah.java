package com.bytedance.sdk.openadsdk.core.component.splash.xr.ms;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.ab;
import com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.c;
import com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.ka;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.core.yu;

/* JADX INFO: loaded from: classes2.dex */
public class ah {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private ab f2439ms = new ab();
    private int ah = 3;
    private final yu xr = re.ms();

    public void ms(final ka kaVar, final com.bytedance.sdk.openadsdk.core.component.splash.ah.ah.xr<c, ab> xrVar) {
        if (this.xr == null || kaVar == null) {
            return;
        }
        this.f2439ms.xr(false);
        this.xr.ms(kaVar.d(), kaVar.ka(), this.ah, new yu.xr() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.xr.ms.ah.1
            @Override // com.bytedance.sdk.openadsdk.core.yu.xr
            public void ms(int i, String str, com.bytedance.sdk.openadsdk.core.nw.xr xrVar2) {
                ah.this.f2439ms.xr(i);
                ah.this.f2439ms.ah(xrVar2 != null ? xrVar2.ah() : 0);
                if (TextUtils.isEmpty(str)) {
                    str = "load ad error";
                }
                ah.this.f2439ms.ms(str);
                xrVar.ms(ah.this.f2439ms);
            }

            @Override // com.bytedance.sdk.openadsdk.core.yu.xr
            public void ms(com.bytedance.sdk.openadsdk.core.nw.ms msVar, com.bytedance.sdk.openadsdk.core.nw.xr xrVar2) {
                if (msVar == null || msVar.xr() == null) {
                    ah.this.f2439ms.xr(1);
                    ah.this.f2439ms.ms("no ad or material");
                    xrVar.ms(ah.this.f2439ms);
                    return;
                }
                c cVar = new c(msVar, false);
                cVar.xr(xrVar2.ny());
                cVar.ah(xrVar2.ch());
                cVar.d(xrVar2.hi());
                cVar.ka(xrVar2.sl());
                cVar.ms(kaVar.ms());
                cVar.ms(kaVar.ah());
                xrVar.xr(cVar);
            }
        });
    }
}
