package com.byazt.mn;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 403, 37})
public class pr {
    public static String pr(String str) {
        if (TextUtils.isEmpty(str)) {
            return "key_tt_csj_node_line_";
        }
        if ("ad_show".equals(str)) {
            return "key_tt_csj_node_line_" + str + "_";
        }
        return "key_tt_csj_other_node_line_" + str + "_";
    }
}
