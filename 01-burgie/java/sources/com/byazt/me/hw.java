package com.byazt.me;

import android.content.Context;
import com.byazt.dea.uc;
import com.tapsdk.tapad.internal.runtime.bundle.BundleId;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 126, 13})
public class hw {
    public static int pr(Context context, String str) {
        try {
            return context.getResources().getIdentifier(str, "drawable", context.getPackageName());
        } catch (Exception e) {
            uc.pr(e);
            return 0;
        }
    }

    public static int pr(Context context, String str, String str2) {
        try {
            return context.getResources().getIdentifier(str, "drawable", str2);
        } catch (Exception e) {
            uc.pr(e);
            return 0;
        }
    }

    public static int hw(Context context, String str) {
        try {
            return context.getResources().getIdentifier(str, BundleId.STYLE, "android");
        } catch (Exception e) {
            uc.pr(e);
            return 0;
        }
    }

    public static int hn(Context context, String str) {
        try {
            return context.getResources().getIdentifier(str, "id", context.getPackageName());
        } catch (Exception e) {
            uc.pr(e);
            return 0;
        }
    }

    public static int hw(Context context, String str, String str2) {
        try {
            return context.getResources().getIdentifier(str, "attr", str2);
        } catch (Exception e) {
            uc.pr(e);
            return 0;
        }
    }
}
