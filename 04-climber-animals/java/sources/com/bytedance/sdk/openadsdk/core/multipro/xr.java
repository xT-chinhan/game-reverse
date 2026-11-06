package com.bytedance.sdk.openadsdk.core.multipro;

import com.bytedance.sdk.openadsdk.core.jw.g;

/* JADX INFO: loaded from: classes2.dex */
public class xr {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public static boolean f2930ms;
    public static boolean xr;

    static class ms {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        static final com.bytedance.sdk.component.d.ms.xr f2931ms = g.ms("sp_multi_info");
    }

    public static void ms() {
        if (!xr) {
            ms.f2931ms.ms("is_support_multi_process", true);
        }
        f2930ms = true;
        xr = true;
    }

    public static void xr() {
        if (xr) {
            ms.f2931ms.ms("is_support_multi_process", false);
        }
        f2930ms = false;
    }

    public static boolean ah() {
        if (!xr) {
            f2930ms = ms.f2931ms.xr("is_support_multi_process", false);
            xr = true;
        }
        return f2930ms;
    }
}
