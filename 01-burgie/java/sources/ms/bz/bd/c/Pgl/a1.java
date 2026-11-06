package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;

/* JADX INFO: loaded from: classes3.dex */
public final class a1 {
    public static int hw;
    public static int pr;

    public static String pr(Context context) {
        int height;
        int i;
        try {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            int i2 = Build.VERSION.SDK_INT;
            if (i2 < 17) {
                if (i2 >= 13) {
                    defaultDisplay.getSize(point);
                    i = point.x;
                } else {
                    pr = defaultDisplay.getWidth();
                    height = defaultDisplay.getHeight();
                }
                hw = height;
                return pr + "*" + hw;
            }
            defaultDisplay.getRealSize(point);
            i = point.x;
            pr = i;
            height = point.y;
            hw = height;
        } catch (Throwable th) {
        }
        return pr + "*" + hw;
    }
}
