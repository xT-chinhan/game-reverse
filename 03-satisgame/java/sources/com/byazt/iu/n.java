package com.byazt.iu;

import android.text.TextUtils;
import com.byazt.nf.rv;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1305, 19})
public class n {
    public static String n(String str) {
        String strBb = rv.qg().bb();
        if (TextUtils.isEmpty(strBb)) {
            return "https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/csj_assets/".concat(String.valueOf(str));
        }
        return strBb + str;
    }
}
