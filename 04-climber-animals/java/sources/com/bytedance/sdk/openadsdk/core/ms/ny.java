package com.bytedance.sdk.openadsdk.core.ms;

import android.os.Looper;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.ao.xr.xr.ub;
import com.bytedance.sdk.openadsdk.core.nw;

/* JADX INFO: loaded from: classes2.dex */
public class ny extends com.bytedance.sdk.openadsdk.t.ms.xr.ms.ab implements xr {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private long f2874ms;

    public ny(Bridge bridge) {
        super(bridge);
        this.f2874ms = System.currentTimeMillis();
    }

    @Override // com.bytedance.sdk.openadsdk.t.ms.xr.ms.ab
    public void ms(final int i, final String str) {
        if (str == null) {
            str = "未知异常";
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.ms(i, str);
        } else {
            nw.c().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ms.ny.1
                @Override // java.lang.Runnable
                public void run() {
                    ny.super.ms(i, str);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.t.ms.xr.ms.ab
    public void ms(final ub ubVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.ms(ubVar);
        } else {
            nw.c().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ms.ny.2
                @Override // java.lang.Runnable
                public void run() {
                    ny.super.ms(ubVar);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.t.ms.xr.ms.ab
    public void xr() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.xr();
        } else {
            nw.c().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ms.ny.3
                @Override // java.lang.Runnable
                public void run() {
                    ny.super.xr();
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.t.ms.xr.ms.ab
    public void xr(final ub ubVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.xr(ubVar);
        } else {
            nw.c().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ms.ny.4
                @Override // java.lang.Runnable
                public void run() {
                    ny.super.xr(ubVar);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ms.xr
    public long ms() {
        return this.f2874ms;
    }
}
