package com.byazt.at;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1003, 13})
public final class hw {
    public static String pr(String str, int i) {
        if (str == null) {
            str = "__null__";
        }
        return str + "#" + i;
    }

    public static String pr(String str) {
        if (str == null) {
            str = "__null__";
        }
        return str + "#";
    }
}
