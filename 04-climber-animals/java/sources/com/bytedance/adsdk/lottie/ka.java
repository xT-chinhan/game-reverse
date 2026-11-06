package com.bytedance.adsdk.lottie;

import android.content.Context;
import android.os.Trace;
import com.anythink.core.common.d.j;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class ka {
    private static int ab = 0;
    private static boolean ah = true;
    private static long[] c = null;
    private static com.bytedance.adsdk.lottie.ah.ka ch = null;
    private static boolean d = true;
    private static volatile com.bytedance.adsdk.lottie.ah.x hi = null;
    private static String[] ka = null;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public static boolean f166ms = false;
    private static com.bytedance.adsdk.lottie.ah.c ny = null;
    private static volatile com.bytedance.adsdk.lottie.ah.ab sl = null;
    private static int x = 0;
    private static boolean xr = false;

    public static void ms(String str) {
        if (xr) {
            int i = ab;
            if (i == 20) {
                x++;
                return;
            }
            ka[i] = str;
            c[i] = System.nanoTime();
            Trace.beginSection(str);
            ab++;
        }
    }

    public static float xr(String str) {
        int i = x;
        if (i > 0) {
            x = i - 1;
            return 0.0f;
        }
        if (!xr) {
            return 0.0f;
        }
        int i2 = ab - 1;
        ab = i2;
        if (i2 == -1) {
            throw new IllegalStateException("Can't end trace section. There are none.");
        }
        if (!str.equals(ka[i2])) {
            throw new IllegalStateException("Unbalanced trace call " + str + ". Expected " + ka[ab] + j.z);
        }
        Trace.endSection();
        return (System.nanoTime() - c[ab]) / 1000000.0f;
    }

    public static com.bytedance.adsdk.lottie.ah.x ms(Context context) {
        com.bytedance.adsdk.lottie.ah.x xVar = hi;
        if (xVar == null) {
            synchronized (com.bytedance.adsdk.lottie.ah.x.class) {
                xVar = hi;
                if (xVar == null) {
                    com.bytedance.adsdk.lottie.ah.ab abVarXr = xr(context);
                    com.bytedance.adsdk.lottie.ah.c xrVar = ny;
                    if (xrVar == null) {
                        xrVar = new com.bytedance.adsdk.lottie.ah.xr();
                    }
                    xVar = new com.bytedance.adsdk.lottie.ah.x(abVarXr, xrVar);
                    hi = xVar;
                }
            }
        }
        return xVar;
    }

    public static com.bytedance.adsdk.lottie.ah.ab xr(Context context) {
        if (!ah) {
            return null;
        }
        final Context applicationContext = context.getApplicationContext();
        com.bytedance.adsdk.lottie.ah.ab abVar = sl;
        if (abVar == null) {
            synchronized (com.bytedance.adsdk.lottie.ah.ab.class) {
                abVar = sl;
                if (abVar == null) {
                    com.bytedance.adsdk.lottie.ah.ka kaVar = ch;
                    if (kaVar == null) {
                        kaVar = new com.bytedance.adsdk.lottie.ah.ka() { // from class: com.bytedance.adsdk.lottie.ka.1
                            @Override // com.bytedance.adsdk.lottie.ah.ka
                            public File ms() {
                                return new File(com.bytedance.sdk.openadsdk.api.plugin.xr.xr(applicationContext), "lottie_network_cache");
                            }
                        };
                    }
                    abVar = new com.bytedance.adsdk.lottie.ah.ab(kaVar);
                    sl = abVar;
                }
            }
        }
        return abVar;
    }

    public static boolean ms() {
        return d;
    }
}
