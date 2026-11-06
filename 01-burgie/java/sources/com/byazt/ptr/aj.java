package com.byazt.ptr;

import android.graphics.Path;
import android.graphics.PointF;
import com.byazt.ynb.g;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 950, 61})
public class aj {
    public static final PointF pr = new PointF();

    public static PointF pr(PointF pointF, PointF pointF2) {
        return new PointF(pointF.x + pointF2.x, pointF.y + pointF2.y);
    }

    public static void pr(g gVar, Path path) {
        path.reset();
        PointF pointFPr = gVar.pr();
        path.moveTo(pointFPr.x, pointFPr.y);
        pr.set(pointFPr.x, pointFPr.y);
        for (int i = 0; i < gVar.hn().size(); i++) {
            com.byazt.uxi.pr prVar = gVar.hn().get(i);
            PointF pointFPr2 = prVar.pr();
            PointF pointFHw = prVar.hw();
            PointF pointFHn = prVar.hn();
            PointF pointF = pr;
            if (pointFPr2.equals(pointF) && pointFHw.equals(pointFHn)) {
                path.lineTo(pointFHn.x, pointFHn.y);
            } else {
                path.cubicTo(pointFPr2.x, pointFPr2.y, pointFHw.x, pointFHw.y, pointFHn.x, pointFHn.y);
            }
            pointF.set(pointFHn.x, pointFHn.y);
        }
        if (gVar.hw()) {
            path.close();
        }
    }

    public static float pr(float f, float f2, float f3) {
        return f + (f3 * (f2 - f));
    }

    public static int pr(int i, int i2, float f) {
        return (int) (i + (f * (i2 - i)));
    }

    public static int pr(float f, float f2) {
        return pr((int) f, (int) f2);
    }

    private static int pr(int i, int i2) {
        return i - (i2 * hw(i, i2));
    }

    private static int hw(int i, int i2) {
        int i3 = i / i2;
        boolean z = (i ^ i2) >= 0;
        int i4 = i % i2;
        if (!z && i4 != 0) {
            return i3 - 1;
        }
        return i3;
    }

    public static int pr(int i, int i2, int i3) {
        return Math.max(i2, Math.min(i3, i));
    }

    public static float hw(float f, float f2, float f3) {
        return Math.max(f2, Math.min(f3, f));
    }

    public static boolean hn(float f, float f2, float f3) {
        return f >= f2 && f <= f3;
    }
}
