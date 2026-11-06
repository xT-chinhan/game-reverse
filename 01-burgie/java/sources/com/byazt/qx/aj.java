package com.byazt.qx;

import android.text.TextUtils;
import com.byazt.hg.of;
import com.byazt.wt.ls;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 49, 61})
public class aj {
    public static void pr(String str, String str2, of ofVar) {
        com.byazt.xk.hw.pr().pr("dynamic_backup_render_new", str2, ls.yb(ofVar), pr(str), (com.byazt.ttf.pr) null);
    }

    public static void pr(int i, String str, String str2, of ofVar) {
        com.byazt.xk.hw.pr().pr("express_ad_render", str2, null, ls.yb(ofVar), pr(str), null, null, null, com.byazt.sd.fw.pr(i), i, null);
    }

    public static int pr(String str) {
        if (TextUtils.isEmpty(str)) {
            return 5;
        }
        switch (str) {
            case "embeded_ad":
                return 5;
            case "draw_ad":
                return 9;
            case "rewarded_video":
                return 7;
            case "fullscreen_interstitial_ad":
                return 8;
            case "banner_ad":
                return 1;
            case "interaction":
                return 2;
            case "splash_ad":
                return 3;
            case "stream":
                return 6;
            default:
                return 5;
        }
    }
}
