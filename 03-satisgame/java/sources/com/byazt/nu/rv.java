package com.byazt.nu;

import android.graphics.Path;
import android.graphics.PointF;
import com.byazt.aw.sz;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1243, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE})
public class rv {
    public static final PointF n = new PointF();

    public static float n(float f, float f2, float f3) {
        return f + (f3 * (f2 - f));
    }

    public static int n(int i, int i2, float f) {
        return (int) (i + (f * (i2 - i)));
    }

    public static boolean s(float f, float f2, float f3) {
        return f >= f2 && f <= f3;
    }

    public static PointF n(PointF pointF, PointF pointF2) {
        return new PointF(pointF.x + pointF2.x, pointF.y + pointF2.y);
    }

    public static void n(sz szVar, Path path) {
        path.reset();
        PointF pointFN = szVar.n();
        path.moveTo(pointFN.x, pointFN.y);
        n.set(pointFN.x, pointFN.y);
        for (int i = 0; i < szVar.s().size(); i++) {
            com.byazt.ld.n nVar = szVar.s().get(i);
            PointF pointFN2 = nVar.n();
            PointF pointFQg = nVar.qg();
            PointF pointFS = nVar.s();
            PointF pointF = n;
            if (pointFN2.equals(pointF) && pointFQg.equals(pointFS)) {
                path.lineTo(pointFS.x, pointFS.y);
            } else {
                path.cubicTo(pointFN2.x, pointFN2.y, pointFQg.x, pointFQg.y, pointFS.x, pointFS.y);
            }
            pointF.set(pointFS.x, pointFS.y);
        }
        if (szVar.qg()) {
            path.close();
        }
    }

    public static int n(float f, float f2) {
        return n((int) f, (int) f2);
    }

    private static int n(int i, int i2) {
        return i - (i2 * qg(i, i2));
    }

    private static int qg(int i, int i2) {
        int i3 = i / i2;
        return (((i ^ i2) >= 0) || i % i2 == 0) ? i3 : i3 - 1;
    }

    public static int n(int i, int i2, int i3) {
        return Math.max(i2, Math.min(i3, i));
    }

    public static float qg(float f, float f2, float f3) {
        return Math.max(f2, Math.min(f3, f));
    }
}
