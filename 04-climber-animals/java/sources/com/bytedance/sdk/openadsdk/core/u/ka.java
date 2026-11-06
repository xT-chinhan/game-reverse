package com.bytedance.sdk.openadsdk.core.u;

/* JADX INFO: loaded from: classes2.dex */
public class ka extends xr {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static volatile ka f3367ms;

    private ka() {
    }

    public static xr ms() {
        if (f3367ms == null) {
            synchronized (xr.class) {
                if (f3367ms == null) {
                    f3367ms = new ka();
                }
            }
        }
        return f3367ms;
    }

    @Override // com.bytedance.sdk.openadsdk.core.u.xr
    protected int xr() {
        return com.bytedance.sdk.openadsdk.core.ah.ka.ms().ah();
    }

    @Override // com.bytedance.sdk.openadsdk.core.u.xr
    protected long ah() {
        return com.bytedance.sdk.openadsdk.core.ah.ka.ms().xr();
    }
}
