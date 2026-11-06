package com.bytedance.sdk.component.ny.d;

import com.bytedance.sdk.component.utils.sl;

/* JADX INFO: loaded from: classes2.dex */
public class ka {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static boolean f1287ms = false;
    private static int xr = 4;

    public static boolean ms() {
        return f1287ms;
    }

    public static void ms(String str, String str2) {
        if (f1287ms && str2 != null && xr <= 4) {
            sl.ms(sl.ah(str), str2);
        }
    }
}
