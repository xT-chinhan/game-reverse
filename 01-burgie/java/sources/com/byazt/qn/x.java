package com.byazt.qn;

import com.byazt.vkw.s;
import com.byazt.zq.fw;
import com.byazt.zs.uc;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 467, 121})
public class x {
    public static boolean pr() {
        return (com.byazt.nm.pr.pr().hw() & 2) == 2;
    }

    public static boolean hw() {
        return (com.byazt.nm.pr.pr().hw() & 4) == 4;
    }

    private static com.byazt.vkw.pr pr(String str) {
        return com.byazt.zb.pr.pr().pr(str);
    }

    public static com.byazt.zq.hn pr(String str, String str2) {
        return ((s) uc.pr("storage_service")).hw(pr(str), str2);
    }

    public static com.byazt.zq.c hw(String str, String str2) {
        return ((s) uc.pr("storage_service")).pr(pr(str), str2);
    }

    public static fw hn(String str, String str2) {
        return ((s) uc.pr("storage_service")).hn(pr(str), str2);
    }
}
