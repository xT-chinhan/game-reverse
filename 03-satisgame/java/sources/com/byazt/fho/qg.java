package com.byazt.fho;

import android.text.TextUtils;
import com.byazt.vyf.s;
import java.util.Random;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 528, 26})
public final class qg {
    public static final int n = new Random().nextInt(10000);

    public static boolean n(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return s(str, i);
    }

    public static boolean qg(String str, int i) {
        if (!TextUtils.isEmpty(str) && i > 0) {
            return i >= 10000 || n < i;
        }
        return false;
    }

    public static boolean n(boolean z, boolean z2, boolean z3) {
        if (z) {
            return (z2 || z3) && !s.cy().lh() && com.byazt.yq.qg.qg();
        }
        return false;
    }

    private static boolean s(String str, int i) {
        if (i <= 0) {
            return false;
        }
        return i >= 10000 || n(str) < i;
    }

    private static int n(String str) {
        int iCharAt = 31;
        for (int i = 0; i < str.length(); i++) {
            iCharAt = (iCharAt * 31) + str.charAt(i);
        }
        return (Integer.MAX_VALUE & iCharAt) % 10000;
    }
}
