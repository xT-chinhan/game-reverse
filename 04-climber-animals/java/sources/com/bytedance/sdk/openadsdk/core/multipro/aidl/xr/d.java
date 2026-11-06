package com.bytedance.sdk.openadsdk.core.multipro.aidl.xr;

import android.os.Bundle;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.core.h;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class d extends h.ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final com.bytedance.sdk.openadsdk.yu.ms.xr.ms.xr f2907ms;

    public d(com.bytedance.sdk.openadsdk.yu.ms.xr.ms.xr xrVar) {
        this.f2907ms = xrVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.h
    public Bundle ms(int i) {
        com.bytedance.sdk.openadsdk.yu.ms.xr.ms.xr xrVar = this.f2907ms;
        final Bundle bundle = new Bundle();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        if (xrVar != null) {
            xrVar.ms(i, new com.bytedance.sdk.openadsdk.h.ms.ms.xr.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.xr.d.1
                @Override // com.bytedance.sdk.openadsdk.h.ms.ms.xr.ms.ms
                public void ms(Bundle bundle2) {
                    bundle.putAll(bundle2);
                    countDownLatch.countDown();
                }
            });
        }
        try {
            countDownLatch.await(10L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            sl.ms(e);
        }
        return bundle;
    }
}
