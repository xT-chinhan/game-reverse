package com.byazt.hkc;

import android.text.TextUtils;
import com.anythink.core.common.d.i;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 46, 19})
public class n {
    public static String n(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        StringBuilder sb = new StringBuilder("https://sf3-fe-tos.pglstatp-toutiao.com/obj/ad-pattern/static/images/");
        if (str.indexOf(i.E) > 0) {
            return sb.append(str).toString();
        }
        return sb.append(str).append(".png").toString();
    }
}
