package com.byazt.hoz;

import android.text.TextUtils;
import com.byazt.gct.hd;
import com.byazt.llp.cp;
import com.byazt.vgx.w;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 424, 19})
public class n {
    public static boolean n(cp cpVar) {
        if (cpVar == null) {
            return false;
        }
        return n(cpVar.sz());
    }

    public static boolean n(hd hdVar) {
        if (hdVar == null) {
            return false;
        }
        String strQg = hdVar.qg();
        if (TextUtils.isEmpty(strQg)) {
            return false;
        }
        return strQg.startsWith("snssdk2329") || strQg.startsWith("snssdk1128");
    }

    public static boolean n(String str) {
        if (str == null) {
            return false;
        }
        if (str.startsWith("snssdk1128")) {
            return w.s("com.ss.android.ugc.aweme");
        }
        if (str.startsWith("snssdk2329")) {
            return w.s("com.ss.android.ugc.aweme.lite");
        }
        return false;
    }
}
