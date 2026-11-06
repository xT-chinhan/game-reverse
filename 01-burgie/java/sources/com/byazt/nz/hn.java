package com.byazt.nz;

import android.content.Context;
import com.byazt.sd.y;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 684, 20})
public class hn {
    public static com.byazt.r.pr pr;

    private static com.byazt.r.pr x() {
        if (pr == null) {
            pr = y.pr().uc();
        }
        return pr;
    }

    public static void pr(hw hwVar) {
        if (x() == null) {
            return;
        }
        pr.pr(hwVar);
    }

    public static void pr() {
        com.byazt.r.pr prVarX = x();
        if (prVarX == null) {
            return;
        }
        prVarX.pr();
    }

    public static void pr(int i) {
        com.byazt.r.pr prVarX = x();
        if (prVarX == null) {
            return;
        }
        prVarX.pr(i);
    }

    public static void pr(String str, String str2) {
        com.byazt.r.pr prVarX = x();
        if (prVarX == null) {
            return;
        }
        prVarX.hw(str, str2);
    }

    public static void hw(String str, String str2) {
        com.byazt.r.pr prVarX = x();
        if (prVarX == null) {
            return;
        }
        prVarX.hn(str, str2);
    }

    public static void hn(String str, String str2) {
        com.byazt.r.pr prVarX = x();
        if (prVarX == null) {
            return;
        }
        prVarX.c(str, str2);
    }

    public static void pr(String str, String str2, Throwable th) {
        com.byazt.r.pr prVarX = x();
        if (prVarX == null) {
            return;
        }
        prVarX.hw(str, str2, th);
    }

    public static void pr(String str, Throwable th) {
        com.byazt.r.pr prVarX = x();
        if (prVarX == null) {
            return;
        }
        prVarX.hw(str, th);
    }

    public static void hw() {
        com.byazt.r.pr prVarX = x();
        if (prVarX == null) {
            return;
        }
        prVarX.hn();
    }

    public static boolean pr(Context context, JSONObject jSONObject) {
        com.byazt.r.pr prVarX = x();
        if (prVarX == null) {
            return false;
        }
        prVarX.pr(context, jSONObject);
        return true;
    }

    public static void pr(Context context, String str, String str2) {
        com.byazt.r.pr prVarX = x();
        if (prVarX == null) {
            return;
        }
        prVarX.pr(context, str, str2);
    }

    public static void pr(String str) {
        com.byazt.r.pr prVarX = x();
        if (prVarX == null) {
            return;
        }
        prVarX.pr(str);
    }

    public static void hn() {
        com.byazt.r.pr prVarX = x();
        if (prVarX == null) {
            return;
        }
        prVarX.hw();
    }
}
