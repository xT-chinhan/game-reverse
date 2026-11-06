package com.bytedance.sdk.openadsdk.core.u;

/* JADX INFO: loaded from: classes2.dex */
public class ms extends xr {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static volatile ms f3368ms;

    private ms() {
    }

    public static xr ms() {
        if (f3368ms == null) {
            synchronized (xr.class) {
                if (f3368ms == null) {
                    f3368ms = new ms();
                }
            }
        }
        return f3368ms;
    }

    @Override // com.bytedance.sdk.openadsdk.core.u.xr
    protected synchronized int xr() {
        int iAh = com.bytedance.sdk.openadsdk.core.ah.ka.ms().ah();
        float fD = com.bytedance.sdk.openadsdk.core.ah.ka.ms().d();
        if (fD <= 0.0f) {
            return iAh;
        }
        return (int) Math.ceil(fD * iAh);
    }

    @Override // com.bytedance.sdk.openadsdk.core.u.xr
    protected synchronized long ah() {
        return com.bytedance.sdk.openadsdk.core.ah.ka.ms().xr();
    }
}
