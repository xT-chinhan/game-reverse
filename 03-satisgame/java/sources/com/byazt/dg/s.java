package com.byazt.dg;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1140, 8})
public final class s {
    public static int n(String str) {
        if (str == null) {
            return 0;
        }
        int iIndexOf = str.indexOf(63);
        if (iIndexOf >= 0) {
            str = str.substring(0, iIndexOf);
        }
        return str.toLowerCase().endsWith(".json") ? 1 : 0;
    }
}
