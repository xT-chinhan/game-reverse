package com.byazt.dz;

import android.text.TextUtils;
import com.byazt.af.w;
import com.byazt.hg.yb;
import com.byazt.wt.ls;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 903, 37})
public class pr {
    public static boolean pr(w wVar) {
        if (wVar == null) {
            return false;
        }
        return pr(wVar.g());
    }

    public static boolean pr(yb ybVar) {
        if (ybVar == null) {
            return false;
        }
        String strHw = ybVar.hw();
        if (TextUtils.isEmpty(strHw)) {
            return false;
        }
        if (!strHw.startsWith("snssdk2329") && !strHw.startsWith("snssdk1128")) {
            return false;
        }
        return true;
    }

    public static boolean pr(String str) {
        if (str == null) {
            return false;
        }
        if (str.startsWith("snssdk1128")) {
            return ls.hn("com.ss.android.ugc.aweme");
        }
        if (!str.startsWith("snssdk2329")) {
            return false;
        }
        return ls.hn("com.ss.android.ugc.aweme.lite");
    }
}
