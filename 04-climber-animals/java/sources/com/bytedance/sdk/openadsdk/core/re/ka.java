package com.bytedance.sdk.openadsdk.core.re;

import android.content.Context;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bytedance.sdk.openadsdk.core.nw.p;
import com.bytedance.sdk.openadsdk.core.re;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class ka {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static volatile ka f3298ms;
    private com.bytedance.sdk.openadsdk.zb.ms.ms ah;
    private final com.bytedance.sdk.component.ny.ms d;
    private Context xr;

    public static ka ms() {
        if (f3298ms == null) {
            synchronized (ka.class) {
                if (f3298ms == null) {
                    com.bytedance.sdk.component.xr.ms.ms.ms.ms().ms(com.bytedance.sdk.openadsdk.core.ah.ah.ms().c() != 2);
                    f3298ms = new ka(re.getContext());
                }
            }
        }
        return f3298ms;
    }

    private ka(Context context) {
        this.xr = context == null ? re.getContext() : context.getApplicationContext();
        com.bytedance.sdk.component.ny.ms msVarMs = new com.bytedance.sdk.component.ny.ms.C0249ms().ms(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, TimeUnit.MILLISECONDS).xr(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, TimeUnit.MILLISECONDS).ah(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, TimeUnit.MILLISECONDS).ms(new ms.C0304ms()).ms(p.ms()).ms(p.xr()).ms(true).ms();
        this.d = msVarMs;
        com.bytedance.sdk.component.xr.ms.d dVarMs = msVarMs.c().ms();
        if (dVarMs != null) {
            dVarMs.ms(32);
            dVarMs.xr(com.bytedance.sdk.openadsdk.core.ah.ah.ms().ka());
        }
    }

    public com.bytedance.sdk.component.ny.ms xr() {
        return this.d;
    }

    public com.bytedance.sdk.openadsdk.zb.ms.ms ah() {
        d();
        return this.ah;
    }

    private void d() {
        if (this.ah == null) {
            this.ah = new com.bytedance.sdk.openadsdk.zb.ms.ms();
        }
    }
}
