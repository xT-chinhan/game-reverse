package com.byazt.pp;

import android.content.Context;
import android.os.Trace;
import com.anythink.core.common.d.i;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_HTTP_RES_FINSIH_TIME, 18})
public class l {
    public static volatile com.byazt.uf.fs cp = null;
    public static volatile com.byazt.uf.x d = null;
    public static int fs = 0;
    public static String[] l = null;
    public static boolean n = false;
    public static boolean q = true;
    public static boolean qg = false;
    public static com.byazt.uf.w rv = null;
    public static boolean s = true;
    public static com.byazt.uf.l tj;
    public static long[] w;
    public static int x;

    public static void n(String str) {
        if (qg) {
            int i = x;
            if (i == 20) {
                fs++;
                return;
            }
            l[i] = str;
            w[i] = System.nanoTime();
            Trace.beginSection(str);
            x++;
        }
    }

    public static float qg(String str) {
        int i = fs;
        if (i > 0) {
            fs = i - 1;
            return 0.0f;
        }
        if (!qg) {
            return 0.0f;
        }
        int i2 = x - 1;
        x = i2;
        if (i2 == -1) {
            throw new IllegalStateException("Can't end trace section. There are none.");
        }
        if (!str.equals(l[i2])) {
            throw new IllegalStateException("Unbalanced trace call " + str + ". Expected " + l[x] + i.E);
        }
        Trace.endSection();
        return (System.nanoTime() - w[x]) / 1000000.0f;
    }

    public static com.byazt.uf.fs n(Context context) {
        com.byazt.uf.fs fsVar = cp;
        if (fsVar == null) {
            synchronized (com.byazt.uf.fs.class) {
                fsVar = cp;
                if (fsVar == null) {
                    com.byazt.uf.x xVarQg = qg(context);
                    com.byazt.uf.w qgVar = rv;
                    if (qgVar == null) {
                        qgVar = new com.byazt.uf.qg();
                    }
                    fsVar = new com.byazt.uf.fs(xVarQg, qgVar);
                    cp = fsVar;
                }
            }
        }
        return fsVar;
    }

    public static com.byazt.uf.x qg(Context context) {
        if (!s) {
            return null;
        }
        final Context applicationContext = context.getApplicationContext();
        com.byazt.uf.x xVar = d;
        if (xVar == null) {
            synchronized (com.byazt.uf.x.class) {
                xVar = d;
                if (xVar == null) {
                    com.byazt.uf.l lVar = tj;
                    if (lVar == null) {
                        lVar = new com.byazt.uf.l() { // from class: com.byazt.pp.l.1
                            @Override // com.byazt.uf.l
                            public File n() {
                                return new File(com.byazt.qyu.qg.s(applicationContext), "lottie_network_cache");
                            }
                        };
                    }
                    xVar = new com.byazt.uf.x(lVar);
                    d = xVar;
                }
            }
        }
        return xVar;
    }

    public static boolean n() {
        return q;
    }
}
