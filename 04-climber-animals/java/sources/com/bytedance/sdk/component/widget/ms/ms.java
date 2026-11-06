package com.bytedance.sdk.component.widget.ms;

/* JADX INFO: loaded from: classes2.dex */
public class ms {
    private static volatile ms xr;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private volatile xr f1373ms;

    private ms() {
    }

    public static ms ms() {
        if (xr == null) {
            synchronized (ms.class) {
                if (xr == null) {
                    xr = new ms();
                }
            }
        }
        return xr;
    }

    public xr xr() {
        return this.f1373ms;
    }
}
