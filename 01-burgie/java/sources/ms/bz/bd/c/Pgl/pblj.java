package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.util.DisplayMetrics;

/* JADX INFO: loaded from: classes3.dex */
public final class pblj {
    private static int pr;

    public static String pr(Context context) {
        if (context != null) {
            try {
                new DisplayMetrics();
                pr = context.getResources().getDisplayMetrics().densityDpi;
            } catch (Throwable th) {
            }
        }
        return "" + pr;
    }
}
