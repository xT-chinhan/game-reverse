package com.bytedance.pangle.ka;

import com.bytedance.pangle.c;

/* JADX INFO: loaded from: classes2.dex */
public class ka {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static c f643ms;

    public static void ms(c cVar) {
        f643ms = cVar;
    }

    public static void ms(Runnable runnable, boolean z) {
        if (z) {
            ms(runnable);
        } else {
            xr(runnable);
        }
    }

    public static void ms(Runnable runnable) {
        f643ms.ms(runnable);
    }

    public static void xr(Runnable runnable) {
        f643ms.xr(runnable);
    }

    public static void ah(Runnable runnable) {
        f643ms.ah(runnable);
    }
}
