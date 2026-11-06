package com.bytedance.sdk.openadsdk.core.ka.ah;

import com.bytedance.sdk.component.ch.ny;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.op.ab;

/* JADX INFO: loaded from: classes2.dex */
public class xr implements ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private int f2772ms;

    @Override // com.bytedance.sdk.openadsdk.core.ka.ah.ms
    public void ah(com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, lm lmVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.ka.ah.ms
    public void ms(com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, lm lmVar, Object obj, boolean z) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.ka.ah.ms
    public void ms(String str, lm lmVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.ka.ah.ms
    public boolean ms(String str) {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ka.ah.ms
    public void xr(com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, lm lmVar) {
    }

    public xr(int i) {
        this.f2772ms = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ka.ah.ms
    public void ms(final com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, final lm lmVar) {
        if (lmVar.no() <= 0) {
            lmVar.ka((System.currentTimeMillis() + 10500000) / 1000);
        }
        ab.d(new ny("PreloadStrategyLoadDelete-onNetworkResponse") { // from class: com.bytedance.sdk.openadsdk.core.ka.ah.xr.1
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.core.ka.d.d.ms(xr.this.f2772ms).ms(xrVar, lmVar, false);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.ka.ah.ms
    public void xr(String str) {
        com.bytedance.sdk.openadsdk.core.ka.d.d.ms(this.f2772ms).xr(str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ka.ah.ms
    public lm ms(String str, long j) {
        lm lmVarMs = com.bytedance.sdk.openadsdk.core.ka.d.d.ms(this.f2772ms).ms(str, false, j);
        if (lmVarMs != null) {
            com.bytedance.sdk.openadsdk.core.ka.d.d.ms(this.f2772ms).ms(str, lmVarMs.wg());
        }
        return lmVarMs;
    }
}
