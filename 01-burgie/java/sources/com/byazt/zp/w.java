package com.byazt.zp;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.sd.a;
import com.tapsdk.tapad.internal.runtime.view.ImageViewManager;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1229, 109})
public class w {
    public static String c;
    public static String pr;
    public static String x;
    public static volatile com.byazt.ihe.pr hw = null;
    public static volatile com.byazt.ihe.pr hn = null;
    public static int uc = 1;

    private static com.byazt.ihe.pr fw() {
        if (hw == null) {
            synchronized (w.class) {
                if (hw == null) {
                    com.byazt.g.pr prVar = new com.byazt.g.pr();
                    hw = prVar;
                    prVar.pr(aj());
                    hw.c();
                }
            }
        }
        return hw;
    }

    private static com.byazt.ihe.pr zo() {
        if (hn == null) {
            synchronized (w.class) {
                if (hn == null) {
                    com.byazt.ihe.pr prVarHn = com.byazt.it.hw.pr().hn();
                    hn = prVarHn;
                    prVarHn.pr(aj());
                    hn.c();
                }
            }
        }
        return hn;
    }

    private static String aj() {
        if (!TextUtils.isEmpty(pr)) {
            return pr;
        }
        int iRr = a.hw().rr();
        uc = iRr;
        String strHw = hw(iRr);
        pr = strHw;
        return strHw;
    }

    private static String hw(int i) {
        Context context = a.getContext();
        File fileHw = i == 1 ? com.byazt.ca.fw.hw(context, com.byazt.iy.hw.pr(), "tt_ad") : com.byazt.ca.fw.pr(context, com.byazt.iy.hw.pr(), "tt_ad");
        if (fileHw.isFile()) {
            fileHw.delete();
        }
        if (!fileHw.exists()) {
            fileHw.mkdirs();
        }
        return fileHw.getAbsolutePath();
    }

    public static com.byazt.ihe.pr pr(int i) {
        if (i == 1) {
            return zo();
        }
        return fw();
    }

    public static String pr() {
        return aj() + File.separator + "video_brand";
    }

    public static String[] hw() {
        String strHw = hw(1);
        com.byazt.ihe.pr prVarHn = com.byazt.it.hw.pr().hn();
        prVarHn.pr(strHw);
        String strHw2 = hw(0);
        com.byazt.ihe.pr prVarHn2 = com.byazt.it.hw.pr().hn();
        prVarHn2.pr(strHw2);
        return new String[]{prVarHn.hn(), prVarHn.x(), prVarHn.hw(), prVarHn.pr(), prVarHn2.hn(), prVarHn2.x(), prVarHn2.hw(), prVarHn2.pr()};
    }

    public static long[] hn() {
        return new long[]{10485760, 20971520, 31457280, 20971520, 10485760, 20971520, 31457280, 20971520};
    }

    public static int x() {
        return uc;
    }

    public static String pr(String str) {
        return aj() + File.separator + str;
    }

    public static String c() {
        if (x == null) {
            x = pr("splash_image");
        }
        return x;
    }

    public static String uc() {
        if (c == null) {
            c = pr(ImageViewManager.NAME);
        }
        return c;
    }
}
