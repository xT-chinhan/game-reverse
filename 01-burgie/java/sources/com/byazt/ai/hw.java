package com.byazt.ai;

import android.text.TextUtils;
import java.util.Random;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 570, 13})
public final class hw {
    public static final int pr = new Random().nextInt(10000);

    public static boolean pr(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return hn(str, i);
    }

    public static boolean hw(String str, int i) {
        if (!TextUtils.isEmpty(str) && i > 0) {
            return i >= 10000 || pr < i;
        }
        return false;
    }

    private static boolean hn(String str, int i) {
        if (i <= 0) {
            return false;
        }
        return i >= 10000 || pr(str) < i;
    }

    private static int pr(String str) {
        int iCharAt = 31;
        for (int i = 0; i < str.length(); i++) {
            iCharAt = (iCharAt * 31) + str.charAt(i);
        }
        return (Integer.MAX_VALUE & iCharAt) % 10000;
    }
}
