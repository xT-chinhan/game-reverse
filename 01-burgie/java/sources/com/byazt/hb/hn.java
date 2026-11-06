package com.byazt.hb;

import android.text.TextUtils;
import com.byazt.sd.a;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1397, 20})
public class hn {
    public static String pr(String str) {
        String strGz = a.hw().gz();
        if (TextUtils.isEmpty(strGz)) {
            return "https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/csj_assets/".concat(String.valueOf(str));
        }
        return strGz + str;
    }
}
