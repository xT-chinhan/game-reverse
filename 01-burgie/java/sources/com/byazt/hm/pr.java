package com.byazt.hm;

import android.text.TextUtils;
import com.byazt.qn.x;
import com.byazt.sd.iu;
import com.byazt.vkw.c;
import com.byazt.zs.uc;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 437, 37})
public final class pr {
    public static String pr(com.byazt.vkw.pr prVar, String str) {
        if (TextUtils.isEmpty(str)) {
            str = "ads_layer_default";
        }
        if (hw()) {
            str = x(prVar, str);
        }
        return pr(str, prVar != null && prVar.hw(), prVar.pr());
    }

    public static String hw(com.byazt.vkw.pr prVar, String str) {
        if (TextUtils.isEmpty(str)) {
            str = "ads_global_default";
        }
        if (hw()) {
            str = x(prVar, str) + "_global";
        }
        return pr(str, prVar != null && prVar.hw(), prVar.pr());
    }

    public static String hn(com.byazt.vkw.pr prVar, String str) {
        if (TextUtils.isEmpty(str)) {
            str = "ads_version_default";
        }
        if (hw()) {
            str = x(prVar, str);
        }
        return pr(str, prVar != null && prVar.hw(), prVar.pr());
    }

    private static String pr(String str, boolean z, String str2) {
        if (z) {
            return str;
        }
        c cVar = (c) uc.pr("app_process");
        if (!cVar.pr() && x.hw()) {
            return str + cVar.hw();
        }
        return str;
    }

    private static boolean hw() {
        if (pr()) {
            return false;
        }
        return x.pr();
    }

    private static String x(com.byazt.vkw.pr prVar, String str) {
        if (prVar != null && !TextUtils.isEmpty(prVar.pr())) {
            return prVar.pr() + "_" + str;
        }
        return str;
    }

    public static boolean pr() {
        return iu.x < 7500;
    }
}
