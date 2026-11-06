package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;

/* JADX INFO: loaded from: classes4.dex */
public final class i1 {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public static int f4835ms;
    public static int xr;

    public static String ms(Context context) {
        try {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getRealSize(point);
            f4835ms = point.x;
            xr = point.y;
        } catch (Throwable unused) {
        }
        return f4835ms + "*" + xr;
    }
}
