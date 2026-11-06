package com.bytedance.sdk.openadsdk.core.ms;

import android.os.Looper;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.core.nw;

/* JADX INFO: loaded from: classes2.dex */
public class ah extends com.bytedance.sdk.openadsdk.t.ms.xr.ms.ms implements xr {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private long f2856ms;

    public ah(Bridge bridge) {
        super(bridge);
        this.f2856ms = System.currentTimeMillis();
    }

    @Override // com.bytedance.sdk.openadsdk.t.ms.xr.ms.ms
    public void ms(final com.bytedance.sdk.openadsdk.ao.xr.xr.xr xrVar) {
        if (com.bytedance.sdk.openadsdk.core.component.splash.d.ms()) {
            super.ms(xrVar);
        } else {
            com.bytedance.sdk.openadsdk.op.ab.ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ms.ah.1
                @Override // java.lang.Runnable
                public void run() {
                    ah.super.ms(xrVar);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.t.ms.xr.ms.ms
    public void ms(final com.bytedance.sdk.openadsdk.ao.xr.xr.ms msVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.ms(msVar);
        } else {
            nw.c().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ms.ah.2
                @Override // java.lang.Runnable
                public void run() {
                    ah.super.ms(msVar);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.t.ms.xr.ms.ms
    public void xr(final com.bytedance.sdk.openadsdk.ao.xr.xr.xr xrVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.xr(xrVar);
        } else {
            nw.c().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ms.ah.3
                @Override // java.lang.Runnable
                public void run() {
                    ah.super.xr(xrVar);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.t.ms.xr.ms.ms
    public void ms(final com.bytedance.sdk.openadsdk.ao.xr.xr.xr xrVar, final com.bytedance.sdk.openadsdk.ao.xr.xr.ms msVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.ms(xrVar, msVar);
        } else {
            nw.c().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ms.ah.4
                @Override // java.lang.Runnable
                public void run() {
                    ah.super.ms(xrVar, msVar);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ms.xr
    public long ms() {
        return this.f2856ms;
    }
}
