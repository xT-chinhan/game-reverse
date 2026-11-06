package com.bytedance.sdk.openadsdk.core.c;

import com.bytedance.sdk.openadsdk.core.re;
import java.util.Random;

/* JADX INFO: loaded from: classes2.dex */
public class xr {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static volatile Random f2036ms = null;
    private static volatile boolean xr = false;

    public static boolean ms() {
        return xr;
    }

    public static void xr() {
        ms(re.xr().lm(), true);
    }

    public static boolean ms(float f, boolean z) {
        if (f <= 0.0f) {
            if (z) {
                xr = false;
            }
            return false;
        }
        int iNextInt = ah().nextInt(100);
        int i = (int) (f * 100.0f);
        if (z) {
            xr = iNextInt < i;
        }
        return iNextInt < i;
    }

    private static Random ah() {
        if (f2036ms != null) {
            return f2036ms;
        }
        Random randomAh = com.bytedance.sdk.component.utils.ms.ah();
        f2036ms = randomAh;
        return randomAh;
    }
}
