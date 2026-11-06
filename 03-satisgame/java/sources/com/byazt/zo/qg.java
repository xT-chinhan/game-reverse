package com.byazt.zo;

import android.os.Bundle;
import android.util.SparseArray;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 588, 26})
public class qg {
    public static String q() {
        return "7.8.1.4";
    }

    public static int n() {
        return com.byazt.nf.tj.l;
    }

    public static com.byazt.vyf.x qg() {
        return DispatchAdSdkInitializerHolder.getCsjManger();
    }

    public static String s() {
        return com.byazt.nf.tj.w;
    }

    public static boolean l() {
        return DispatchAdSdkInitializerHolder.isInitSuccess();
    }

    public static void n(int i) {
        com.byazt.vyf.x xVarQg = qg();
        if (xVarQg != null) {
            xVarQg.n(i);
        }
    }

    public static void n(boolean z) {
        com.byazt.vyf.x xVarQg = qg();
        if (xVarQg == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_paid", z);
        if (bundle.keySet().isEmpty()) {
            return;
        }
        xVarQg.n(SparseArray.class, bundle);
    }
}
