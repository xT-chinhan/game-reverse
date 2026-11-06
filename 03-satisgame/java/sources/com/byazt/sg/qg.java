package com.byazt.sg;

import android.text.TextUtils;
import com.anythink.core.common.d.i;
import com.byazt.vy.hu;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 27, 26})
public class qg {
    public static final String n = hu.q();
    public static boolean qg = true;

    public static String n() {
        return com.byazt.zo.qg.s();
    }

    public static String qg() {
        if (TextUtils.isEmpty(n())) {
            return "";
        }
        String[] strArrSplit = n().split("\\.");
        if (strArrSplit.length < 4) {
            return "";
        }
        return strArrSplit[0] + i.E + strArrSplit[1] + i.E + strArrSplit[2];
    }

    public static String s() {
        return com.byazt.zo.qg.q();
    }
}
