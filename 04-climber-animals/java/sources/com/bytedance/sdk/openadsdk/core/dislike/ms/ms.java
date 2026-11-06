package com.bytedance.sdk.openadsdk.core.dislike.ms;

/* JADX INFO: loaded from: classes2.dex */
public class ms {
    private static d ah = null;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static volatile boolean f2471ms = false;
    private static ah xr;

    public static void ms(ah ahVar, d dVar) {
        if (f2471ms) {
            return;
        }
        f2471ms = true;
        xr = ahVar;
        ah = dVar;
    }

    public static ah ms() {
        return xr;
    }

    public static d xr() {
        return ah;
    }
}
