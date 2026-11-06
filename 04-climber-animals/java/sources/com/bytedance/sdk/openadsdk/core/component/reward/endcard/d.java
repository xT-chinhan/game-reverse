package com.bytedance.sdk.openadsdk.core.component.reward.endcard;

import com.bytedance.sdk.openadsdk.core.nw.lm;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
class d extends com.bytedance.sdk.openadsdk.core.y.d {
    private final String ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final WeakReference<com.bytedance.sdk.openadsdk.core.qv.d> f2170ms;
    private final lm xr;

    d(lm lmVar, String str, com.bytedance.sdk.openadsdk.core.qv.d dVar) {
        this.xr = lmVar;
        this.ah = str;
        this.f2170ms = new WeakReference<>(dVar);
    }

    @Override // com.bytedance.sdk.openadsdk.u.ms
    public void ms() {
        WeakReference<com.bytedance.sdk.openadsdk.core.qv.d> weakReference = this.f2170ms;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f2170ms.get().ms();
    }

    @Override // com.bytedance.sdk.openadsdk.u.ms
    public void ms(int i, String str) {
        WeakReference<com.bytedance.sdk.openadsdk.core.qv.d> weakReference = this.f2170ms;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f2170ms.get();
    }
}
