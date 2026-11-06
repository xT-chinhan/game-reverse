package com.bytedance.sdk.openadsdk.core.y;

/* JADX INFO: loaded from: classes2.dex */
public class xr {
    public static boolean ms(long j, long j2) {
        return (j & j2) == j2;
    }

    public static boolean ms(long j) {
        return ms(j, ms.USE_ALOG.ms());
    }

    public static boolean xr(long j) {
        return ms(j, ms.USE_PITAYA.ms());
    }
}
