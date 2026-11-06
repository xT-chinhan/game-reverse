package com.byazt.ql;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.nf.rv;
import com.byazt.tk.x;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_PRE_DECODE_AUTO_PAUSE, 26})
public class qg {
    public static String l = null;
    public static String n = null;
    public static String q = null;
    public static volatile com.byazt.ej.n qg = null;
    public static volatile com.byazt.ej.n s = null;
    public static int w = 1;

    private static com.byazt.ej.n x() {
        if (qg == null) {
            synchronized (qg.class) {
                if (qg == null) {
                    com.byazt.ryy.n nVar = new com.byazt.ryy.n();
                    qg = nVar;
                    nVar.n(rv());
                    qg.l();
                }
            }
        }
        return qg;
    }

    private static com.byazt.ej.n fs() {
        if (s == null) {
            synchronized (qg.class) {
                if (s == null) {
                    com.byazt.ej.n nVarS = com.byazt.gks.qg.n().s();
                    s = nVarS;
                    nVarS.n(rv());
                    s.l();
                }
            }
        }
        return s;
    }

    private static String rv() {
        if (!TextUtils.isEmpty(n)) {
            return n;
        }
        int iYr = rv.qg().yr();
        w = iYr;
        String strQg = qg(iYr);
        n = strQg;
        return strQg;
    }

    private static String qg(int i) {
        File fileN;
        Context context = rv.getContext();
        if (i == 1) {
            fileN = x.qg(context, com.byazt.byp.qg.n(), "tt_ad");
        } else {
            fileN = x.n(context, com.byazt.byp.qg.n(), "tt_ad");
        }
        if (fileN.isFile()) {
            fileN.delete();
        }
        if (!fileN.exists()) {
            fileN.mkdirs();
        }
        return fileN.getAbsolutePath();
    }

    public static com.byazt.ej.n n(int i) {
        if (i == 1) {
            return fs();
        }
        return x();
    }

    public static String n() {
        return rv() + File.separator + "video_brand";
    }

    public static String[] qg() {
        String strQg = qg(1);
        com.byazt.ej.n nVarS = com.byazt.gks.qg.n().s();
        nVarS.n(strQg);
        String strQg2 = qg(0);
        com.byazt.ej.n nVarS2 = com.byazt.gks.qg.n().s();
        nVarS2.n(strQg2);
        return new String[]{nVarS.s(), nVarS.q(), nVarS.qg(), nVarS.n(), nVarS2.s(), nVarS2.q(), nVarS2.qg(), nVarS2.n()};
    }

    public static long[] s() {
        return new long[]{10485760, 20971520, 31457280, 20971520, 10485760, 20971520, 31457280, 20971520};
    }

    public static int q() {
        return w;
    }

    public static String n(String str) {
        return rv() + File.separator + str;
    }

    public static String l() {
        if (q == null) {
            q = n("splash_image");
        }
        return q;
    }

    public static String w() {
        if (l == null) {
            l = n("image");
        }
        return l;
    }
}
