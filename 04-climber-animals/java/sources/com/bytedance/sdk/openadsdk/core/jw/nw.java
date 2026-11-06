package com.bytedance.sdk.openadsdk.core.jw;

import com.bytedance.sdk.openadsdk.core.nw.fm;
import com.bytedance.sdk.openadsdk.core.nw.l;

/* JADX INFO: loaded from: classes2.dex */
public class nw {
    public static String ms(com.bytedance.sdk.openadsdk.core.nw.lm lmVar) {
        if (lmVar == null) {
            return "";
        }
        int iX = x(lmVar);
        if (iX != 3) {
            return iX != 4 ? "" : l.ka(lmVar);
        }
        return com.bytedance.sdk.openadsdk.core.nw.t.c(lmVar);
    }

    public static boolean xr(com.bytedance.sdk.openadsdk.core.nw.lm lmVar) {
        return (lmVar == null || x(lmVar) == 0) ? false : true;
    }

    private static int x(com.bytedance.sdk.openadsdk.core.nw.lm lmVar) {
        if (com.bytedance.sdk.openadsdk.core.nw.t.ms(lmVar)) {
            return 3;
        }
        return l.ms(lmVar) ? 4 : 0;
    }

    public static boolean ah(com.bytedance.sdk.openadsdk.core.nw.lm lmVar) {
        if (lmVar == null || fm.ms(lmVar) || x(lmVar) != 3) {
            return false;
        }
        return com.bytedance.sdk.openadsdk.core.nw.t.ms(lmVar);
    }

    public static boolean d(com.bytedance.sdk.openadsdk.core.nw.lm lmVar) {
        return lmVar != null && x(lmVar) == 4;
    }

    public static int ka(com.bytedance.sdk.openadsdk.core.nw.lm lmVar) {
        if (lmVar != null && x(lmVar) == 3) {
            return com.bytedance.sdk.openadsdk.core.nw.t.ny(lmVar);
        }
        return 0;
    }

    public static int c(com.bytedance.sdk.openadsdk.core.nw.lm lmVar) {
        if (lmVar == null) {
            return -1;
        }
        if (x(lmVar) != 3) {
            return 0;
        }
        return com.bytedance.sdk.openadsdk.core.nw.t.ch(lmVar);
    }

    public static boolean ab(com.bytedance.sdk.openadsdk.core.nw.lm lmVar) {
        return x(lmVar) == 3;
    }
}
