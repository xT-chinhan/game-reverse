package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;

/* JADX INFO: loaded from: classes3.dex */
public final class a1 {
    public static int n;
    public static int qg;

    public static String n(Context context) {
        try {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getRealSize(point);
            n = point.x;
            qg = point.y;
        } catch (Throwable unused) {
        }
        return n + "*" + qg;
    }
}
