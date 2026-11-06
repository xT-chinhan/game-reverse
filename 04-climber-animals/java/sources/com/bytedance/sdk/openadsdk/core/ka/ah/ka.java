package com.bytedance.sdk.openadsdk.core.ka.ah;

import com.bytedance.sdk.component.ch.ny;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.op.ab;

/* JADX INFO: loaded from: classes2.dex */
public class ka implements ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final int f2769ms;

    @Override // com.bytedance.sdk.openadsdk.core.ka.ah.ms
    public void ah(com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, lm lmVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.ka.ah.ms
    public void ms(com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, lm lmVar, Object obj, boolean z) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.ka.ah.ms
    public boolean ms(String str) {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ka.ah.ms
    public void xr(com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, lm lmVar) {
    }

    public ka(int i) {
        this.f2769ms = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ka.ah.ms
    public void ms(final com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, final lm lmVar) {
        if (lmVar.no() <= 0) {
            lmVar.ka((System.currentTimeMillis() + 10500000) / 1000);
        }
        ab.d(new ny("PreloadStrategyShowDelete-onNetworkResponse") { // from class: com.bytedance.sdk.openadsdk.core.ka.ah.ka.1
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.core.ka.d.d.ms(ka.this.f2769ms).ms(xrVar, lmVar, false);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.ka.ah.ms
    public void xr(String str) {
        com.bytedance.sdk.openadsdk.core.ka.d.d.ms(this.f2769ms).xr(str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ka.ah.ms
    public lm ms(String str, long j) {
        return com.bytedance.sdk.openadsdk.core.ka.d.d.ms(this.f2769ms).ms(str, false, j);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ka.ah.ms
    public void ms(final String str, final lm lmVar) {
        ab.ms(new ny("PreloadStrategyShowDelete-onShow") { // from class: com.bytedance.sdk.openadsdk.core.ka.ah.ka.2
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.core.ka.d.d.ms(ka.this.f2769ms).ms(str, lmVar.wg());
            }
        });
    }
}
