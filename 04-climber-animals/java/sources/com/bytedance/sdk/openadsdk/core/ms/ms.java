package com.bytedance.sdk.openadsdk.core.ms;

import com.bytedance.sdk.openadsdk.core.yu;

/* JADX INFO: loaded from: classes2.dex */
public class ms implements yu.xr {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private yu.xr f2872ms;
    private int xr;

    public ms(yu.xr xrVar) {
        this.f2872ms = xrVar;
    }

    public void ms(int i) {
        this.xr = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.yu.xr
    public void ms(int i, String str, com.bytedance.sdk.openadsdk.core.nw.xr xrVar) {
        yu.xr xrVar2 = this.f2872ms;
        if (xrVar2 != null) {
            xrVar2.ms(i, str, xrVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.yu.xr
    public void ms(final com.bytedance.sdk.openadsdk.core.nw.ms msVar, final com.bytedance.sdk.openadsdk.core.nw.xr xrVar) {
        int i = this.xr;
        boolean z = true;
        boolean z2 = i == 3 || i == 4;
        if (z2) {
            z = (com.bytedance.sdk.openadsdk.core.ah.ka.ms().sl() & 1) != 1;
        }
        if (z) {
            if (this.f2872ms != null) {
                Runnable runnable = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ms.ms.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ms.this.f2872ms.ms(msVar, xrVar);
                    }
                };
                if (z2) {
                    com.bytedance.sdk.openadsdk.op.ab.ms(runnable);
                    return;
                } else {
                    com.bytedance.sdk.openadsdk.op.ab.xr(runnable);
                    return;
                }
            }
            return;
        }
        yu.xr xrVar2 = this.f2872ms;
        if (xrVar2 != null) {
            xrVar2.ms(msVar, xrVar);
        }
    }
}
