package com.byazt.tf;

import com.byazt.hcx.aj;
import com.byazt.hcx.m;
import com.byazt.vkw.gz;
import com.byazt.zs.uc;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1049, 20})
public class hn {
    private static aj pr(int i) {
        return ((gz) uc.pr("net")).pr().pr(i);
    }

    public static aj pr(String str) {
        return ((gz) uc.pr("net")).pr().pr(str);
    }

    public static aj hw(String str) {
        return pr(str).pr(1);
    }

    public static aj hn(String str) {
        return hw(str).c();
    }

    public static aj pr() {
        return pr(2);
    }

    public static aj x(String str) {
        return pr(str).pr(2);
    }

    public static aj pr(String str, String str2, String str3) {
        return pr(str).pr(3).x(str2, str3);
    }

    public static m c(String str) {
        return hw(str).pr();
    }
}
