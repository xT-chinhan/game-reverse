package com.byazt.im;

import android.content.Context;
import com.byazt.vx.w;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 147, 26})
public class qg {
    public static int n(Context context, String str) {
        try {
            return context.getResources().getIdentifier(str, "drawable", context.getPackageName());
        } catch (Exception e) {
            w.n(e);
            return 0;
        }
    }

    public static int n(Context context, String str, String str2) {
        try {
            return context.getResources().getIdentifier(str, "drawable", str2);
        } catch (Exception e) {
            w.n(e);
            return 0;
        }
    }

    public static int qg(Context context, String str) {
        try {
            return context.getResources().getIdentifier(str, "style", "android");
        } catch (Exception e) {
            w.n(e);
            return 0;
        }
    }

    public static int s(Context context, String str) {
        try {
            return context.getResources().getIdentifier(str, "id", context.getPackageName());
        } catch (Exception e) {
            w.n(e);
            return 0;
        }
    }

    public static int qg(Context context, String str, String str2) {
        try {
            return context.getResources().getIdentifier(str, "attr", str2);
        } catch (Exception e) {
            w.n(e);
            return 0;
        }
    }
}
