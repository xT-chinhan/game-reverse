package com.bytedance.ms.xr.x;

/* JADX INFO: loaded from: classes2.dex */
public final class ch {
    public static void ms(String str) {
        if (com.bytedance.ms.xr.x.ka().ka()) {
            com.bytedance.sdk.component.utils.sl.ms("npth", str);
        }
    }

    public static void ms(Throwable th) {
        if (com.bytedance.ms.xr.x.ka().ka()) {
            com.bytedance.sdk.component.utils.sl.ah("npth", "NPTH Catch Error", th);
        }
    }

    public static void xr(Throwable th) {
        if (com.bytedance.ms.xr.x.ka().ka()) {
            com.bytedance.sdk.component.utils.sl.xr("npth", "NPTH Catch Error", th);
        }
    }
}
