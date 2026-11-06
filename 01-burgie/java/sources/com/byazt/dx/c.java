package com.byazt.dx;

import android.content.Context;
import android.os.Trace;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 229, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c {
    public static com.byazt.bny.uc aj;
    public static String[] c;
    public static volatile com.byazt.bny.fw k;
    public static long[] uc;
    public static com.byazt.bny.c vk;
    public static volatile com.byazt.bny.zo w;
    public static boolean pr = false;
    public static boolean hw = false;
    public static boolean hn = true;
    public static boolean x = true;
    public static int fw = 0;
    public static int zo = 0;

    public static void pr(String str) {
        if (!hw) {
            return;
        }
        int i = fw;
        if (i == 20) {
            zo++;
            return;
        }
        c[i] = str;
        uc[i] = System.nanoTime();
        Trace.beginSection(str);
        fw++;
    }

    public static float hw(String str) {
        int i = zo;
        if (i > 0) {
            zo = i - 1;
            return 0.0f;
        }
        if (!hw) {
            return 0.0f;
        }
        int i2 = fw - 1;
        fw = i2;
        if (i2 == -1) {
            throw new IllegalStateException("Can't end trace section. There are none.");
        }
        if (!str.equals(c[i2])) {
            throw new IllegalStateException("Unbalanced trace call " + str + ". Expected " + c[fw] + ".");
        }
        Trace.endSection();
        return (System.nanoTime() - uc[fw]) / 1000000.0f;
    }

    public static com.byazt.bny.zo pr(Context context) {
        com.byazt.bny.zo zoVar = w;
        if (zoVar == null) {
            synchronized (com.byazt.bny.zo.class) {
                zoVar = w;
                if (zoVar == null) {
                    com.byazt.bny.fw fwVarHw = hw(context);
                    com.byazt.bny.uc hwVar = aj;
                    if (hwVar == null) {
                        hwVar = new com.byazt.bny.hw();
                    }
                    zoVar = new com.byazt.bny.zo(fwVarHw, hwVar);
                    w = zoVar;
                }
            }
        }
        return zoVar;
    }

    public static com.byazt.bny.fw hw(Context context) {
        if (!hn) {
            return null;
        }
        final Context applicationContext = context.getApplicationContext();
        com.byazt.bny.fw fwVar = k;
        if (fwVar == null) {
            synchronized (com.byazt.bny.fw.class) {
                fwVar = k;
                if (fwVar == null) {
                    com.byazt.bny.c cVar = vk;
                    if (cVar == null) {
                        cVar = new com.byazt.bny.c() { // from class: com.byazt.dx.c.1
                            @Override // com.byazt.bny.c
                            public File pr() {
                                return new File(com.byazt.mg.hw.hw(applicationContext), "lottie_network_cache");
                            }
                        };
                    }
                    fwVar = new com.byazt.bny.fw(cVar);
                    k = fwVar;
                }
            }
        }
        return fwVar;
    }

    public static boolean pr() {
        return x;
    }
}
