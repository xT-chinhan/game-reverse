package com.bytedance.sdk.openadsdk.core.component.reward.ms;

import com.bytedance.sdk.openadsdk.ao.xr.xr.hi;
import com.bytedance.sdk.openadsdk.ao.xr.xr.ub;
import com.bytedance.sdk.openadsdk.t.ms.xr.ms.ab;

/* JADX INFO: loaded from: classes2.dex */
public class ah {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private ab f2222ms;
    private com.bytedance.sdk.openadsdk.t.ms.xr.ms.d xr;

    public ah(ab abVar) {
        this.f2222ms = abVar;
    }

    public ah(com.bytedance.sdk.openadsdk.t.ms.xr.ms.d dVar) {
        this.xr = dVar;
    }

    public void ms(int i, String str) {
        ab abVar = this.f2222ms;
        if (abVar != null) {
            abVar.ms(i, str);
        }
        com.bytedance.sdk.openadsdk.t.ms.xr.ms.d dVar = this.xr;
        if (dVar != null) {
            dVar.ms(i, str);
        }
    }

    public void ms(Object obj) {
        ab abVar = this.f2222ms;
        if (abVar != null && (obj instanceof ub)) {
            abVar.ms((ub) obj);
        }
        com.bytedance.sdk.openadsdk.t.ms.xr.ms.d dVar = this.xr;
        if (dVar == null || !(obj instanceof hi)) {
            return;
        }
        dVar.ms((hi) obj);
    }

    public void xr(Object obj) {
        ab abVar = this.f2222ms;
        if (abVar != null && (obj instanceof ub)) {
            abVar.xr();
            this.f2222ms.xr((ub) obj);
        }
        com.bytedance.sdk.openadsdk.t.ms.xr.ms.d dVar = this.xr;
        if (dVar == null || !(obj instanceof hi)) {
            return;
        }
        dVar.xr();
        this.xr.xr((hi) obj);
    }

    public long ms() {
        Object obj = this.f2222ms;
        if (obj != null) {
            return obj instanceof com.bytedance.sdk.openadsdk.core.ms.xr ? ((com.bytedance.sdk.openadsdk.core.ms.xr) obj).ms() : System.currentTimeMillis();
        }
        Object obj2 = this.xr;
        if (obj2 != null) {
            return obj2 instanceof com.bytedance.sdk.openadsdk.core.ms.xr ? ((com.bytedance.sdk.openadsdk.core.ms.xr) obj2).ms() : System.currentTimeMillis();
        }
        return 0L;
    }
}
