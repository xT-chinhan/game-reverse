package com.bytedance.sdk.openadsdk.core.ms;

import android.os.Looper;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.ao.xr.xr.hi;
import com.bytedance.sdk.openadsdk.core.nw;

/* JADX INFO: loaded from: classes2.dex */
public class c extends com.bytedance.sdk.openadsdk.t.ms.xr.ms.d implements xr {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private long f2861ms;

    public c(Bridge bridge) {
        super(bridge);
        this.f2861ms = System.currentTimeMillis();
    }

    @Override // com.bytedance.sdk.openadsdk.t.ms.xr.ms.d
    public void ms(final int i, final String str) {
        if (str == null) {
            str = "未知异常";
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.ms(i, str);
        } else {
            nw.c().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ms.c.1
                @Override // java.lang.Runnable
                public void run() {
                    c.super.ms(i, str);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.t.ms.xr.ms.d
    public void ms(final hi hiVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.ms(hiVar);
        } else {
            nw.c().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ms.c.2
                @Override // java.lang.Runnable
                public void run() {
                    c.super.ms(hiVar);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.t.ms.xr.ms.d
    public void xr() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.xr();
        } else {
            nw.c().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ms.c.3
                @Override // java.lang.Runnable
                public void run() {
                    c.super.xr();
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.t.ms.xr.ms.d
    public void xr(final hi hiVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.xr(hiVar);
        } else {
            nw.c().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ms.c.4
                @Override // java.lang.Runnable
                public void run() {
                    c.super.xr(hiVar);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ms.xr
    public long ms() {
        return this.f2861ms;
    }
}
