package com.bytedance.adsdk.lottie.ka;

import android.graphics.Path;
import android.graphics.PointF;
import com.bytedance.adsdk.lottie.model.xr.u;

/* JADX INFO: loaded from: classes2.dex */
public class x {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final PointF f174ms = new PointF();

    public static boolean ah(float f, float f2, float f3) {
        return f >= f2 && f <= f3;
    }

    public static float ms(float f, float f2, float f3) {
        return f + (f3 * (f2 - f));
    }

    public static int ms(int i, int i2, float f) {
        return (int) (i + (f * (i2 - i)));
    }

    public static PointF ms(PointF pointF, PointF pointF2) {
        return new PointF(pointF.x + pointF2.x, pointF.y + pointF2.y);
    }

    public static void ms(u uVar, Path path) {
        path.reset();
        PointF pointFMs = uVar.ms();
        path.moveTo(pointFMs.x, pointFMs.y);
        f174ms.set(pointFMs.x, pointFMs.y);
        for (int i = 0; i < uVar.ah().size(); i++) {
            com.bytedance.adsdk.lottie.model.ms msVar = uVar.ah().get(i);
            PointF pointFMs2 = msVar.ms();
            PointF pointFXr = msVar.xr();
            PointF pointFAh = msVar.ah();
            PointF pointF = f174ms;
            if (pointFMs2.equals(pointF) && pointFXr.equals(pointFAh)) {
                path.lineTo(pointFAh.x, pointFAh.y);
            } else {
                path.cubicTo(pointFMs2.x, pointFMs2.y, pointFXr.x, pointFXr.y, pointFAh.x, pointFAh.y);
            }
            pointF.set(pointFAh.x, pointFAh.y);
        }
        if (uVar.xr()) {
            path.close();
        }
    }

    static int ms(float f, float f2) {
        return ms((int) f, (int) f2);
    }

    private static int ms(int i, int i2) {
        return i - (i2 * xr(i, i2));
    }

    private static int xr(int i, int i2) {
        int i3 = i / i2;
        return (((i ^ i2) >= 0) || i % i2 == 0) ? i3 : i3 - 1;
    }

    public static int ms(int i, int i2, int i3) {
        return Math.max(i2, Math.min(i3, i));
    }

    public static float xr(float f, float f2, float f3) {
        return Math.max(f2, Math.min(f3, f));
    }
}
