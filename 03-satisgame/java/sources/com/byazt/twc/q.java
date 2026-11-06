package com.byazt.twc;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1103, 5})
public class q {
    public static Context getContext() {
        if (com.byazt.gkj.n.n().s() == null) {
            return null;
        }
        return com.byazt.gkj.n.n().s().getContext();
    }

    public static boolean n() {
        com.byazt.gkj.s sVarS = com.byazt.gkj.n.n().s();
        return sVarS != null && sVarS.l() == 1;
    }

    public static int qg() {
        return com.byazt.gkj.n.n().s().fs();
    }
}
