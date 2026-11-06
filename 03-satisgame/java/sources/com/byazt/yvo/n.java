package com.byazt.yvo;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1177, 19})
public class n {
    public static String n(String str) {
        if (TextUtils.isEmpty(str)) {
            return "key_tt_csj_node_line_";
        }
        if ("ad_show".equals(str)) {
            return "key_tt_csj_node_line_" + str + "_";
        }
        return "key_tt_csj_other_node_line_" + str + "_";
    }
}
