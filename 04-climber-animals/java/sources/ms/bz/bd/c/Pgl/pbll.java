package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.util.DisplayMetrics;

/* JADX INFO: loaded from: classes4.dex */
public final class pbll {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static int f4852ms;

    public static String ms(Context context) {
        if (context != null) {
            try {
                new DisplayMetrics();
                f4852ms = context.getResources().getDisplayMetrics().densityDpi;
            } catch (Throwable unused) {
            }
        }
        return "" + f4852ms;
    }
}
