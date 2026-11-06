package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.util.DisplayMetrics;

/* JADX INFO: loaded from: classes3.dex */
public final class pblj {
    private static int n;

    public static String n(Context context) {
        if (context != null) {
            try {
                new DisplayMetrics();
                n = context.getResources().getDisplayMetrics().densityDpi;
            } catch (Throwable unused) {
            }
        }
        return "" + n;
    }
}
