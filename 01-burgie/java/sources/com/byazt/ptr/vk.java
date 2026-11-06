package com.byazt.ptr;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import com.byazt.ova.cz;
import java.io.Closeable;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.nio.channels.ClosedChannelException;
import javax.net.ssl.SSLException;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 950, 50})
public final class vk {
    public static final ThreadLocal<PathMeasure> pr = new ThreadLocal<PathMeasure>() { // from class: com.byazt.ptr.vk.1
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
        public PathMeasure initialValue() {
            return new PathMeasure();
        }
    };
    public static final ThreadLocal<Path> hw = new ThreadLocal<Path>() { // from class: com.byazt.ptr.vk.2
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
        public Path initialValue() {
            return new Path();
        }
    };
    public static final ThreadLocal<Path> hn = new ThreadLocal<Path>() { // from class: com.byazt.ptr.vk.3
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
        public Path initialValue() {
            return new Path();
        }
    };
    public static final ThreadLocal<float[]> x = new ThreadLocal<float[]>() { // from class: com.byazt.ptr.vk.4
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
        public float[] initialValue() {
            return new float[4];
        }
    };
    public static final float c = (float) (Math.sqrt(2.0d) / 2.0d);

    public static Path pr(PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
        Path path = new Path();
        path.moveTo(pointF.x, pointF.y);
        if (pointF3 != null && pointF4 != null && (pointF3.length() != 0.0f || pointF4.length() != 0.0f)) {
            path.cubicTo(pointF3.x + pointF.x, pointF.y + pointF3.y, pointF2.x + pointF4.x, pointF2.y + pointF4.y, pointF2.x, pointF2.y);
        } else {
            path.lineTo(pointF2.x, pointF2.y);
        }
        return path;
    }

    public static void pr(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e2) {
            }
        }
    }

    public static float pr(Matrix matrix) {
        float[] fArr = x.get();
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        float f = c;
        fArr[2] = f;
        fArr[3] = f;
        matrix.mapPoints(fArr);
        return (float) Math.hypot(fArr[2] - fArr[0], fArr[3] - fArr[1]);
    }

    public static boolean hw(Matrix matrix) {
        float[] fArr = x.get();
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        fArr[2] = 37394.73f;
        fArr[3] = 39575.234f;
        matrix.mapPoints(fArr);
        if (fArr[0] != fArr[2] && fArr[1] != fArr[3]) {
            return false;
        }
        return true;
    }

    public static void pr(Path path, cz czVar) {
        if (czVar == null || czVar.c()) {
            return;
        }
        pr(path, ((com.byazt.al.x) czVar.hw()).aj() / 100.0f, ((com.byazt.al.x) czVar.hn()).aj() / 100.0f, ((com.byazt.al.x) czVar.x()).aj() / 360.0f);
    }

    public static void pr(Path path, float f, float f2, float f3) {
        com.byazt.dx.c.pr("applyTrimPathIfNeeded");
        PathMeasure pathMeasure = pr.get();
        Path path2 = hw.get();
        Path path3 = hn.get();
        pathMeasure.setPath(path, false);
        float length = pathMeasure.getLength();
        if (f == 1.0f && f2 == 0.0f) {
            com.byazt.dx.c.hw("applyTrimPathIfNeeded");
            return;
        }
        if (length < 1.0f || Math.abs((f2 - f) - 1.0f) < 0.01d) {
            com.byazt.dx.c.hw("applyTrimPathIfNeeded");
            return;
        }
        float f4 = f * length;
        float f5 = f2 * length;
        float f6 = f3 * length;
        float fMin = Math.min(f4, f5) + f6;
        float fMax = Math.max(f4, f5) + f6;
        if (fMin >= length && fMax >= length) {
            fMin = aj.pr(fMin, length);
            fMax = aj.pr(fMax, length);
        }
        if (fMin < 0.0f) {
            fMin = aj.pr(fMin, length);
        }
        if (fMax < 0.0f) {
            fMax = aj.pr(fMax, length);
        }
        if (fMin == fMax) {
            path.reset();
            com.byazt.dx.c.hw("applyTrimPathIfNeeded");
            return;
        }
        if (fMin >= fMax) {
            fMin -= length;
        }
        path2.reset();
        pathMeasure.getSegment(fMin, fMax, path2, true);
        if (fMax > length) {
            path3.reset();
            pathMeasure.getSegment(0.0f, fMax % length, path3, true);
            path2.addPath(path3);
        } else if (fMin < 0.0f) {
            path3.reset();
            pathMeasure.getSegment(fMin + length, length, path3, true);
            path2.addPath(path3);
        }
        path.set(path2);
        com.byazt.dx.c.hw("applyTrimPathIfNeeded");
    }

    public static boolean pr(int i, int i2, int i3, int i4, int i5, int i6) {
        if (i < i4) {
            return false;
        }
        if (i > i4) {
            return true;
        }
        if (i2 < i5) {
            return false;
        }
        if (i2 <= i5 && i3 < i6) {
            return false;
        }
        return true;
    }

    public static int pr(float f, float f2, float f3, float f4) {
        int i;
        if (f == 0.0f) {
            i = 17;
        } else {
            i = (int) (f * 527.0f);
        }
        if (f2 != 0.0f) {
            i = (int) (i * 31 * f2);
        }
        if (f3 != 0.0f) {
            i = (int) (i * 31 * f3);
        }
        if (f4 != 0.0f) {
            return (int) (i * 31 * f4);
        }
        return i;
    }

    public static float pr() {
        return Resources.getSystem().getDisplayMetrics().density;
    }

    public static float pr(Context context) {
        if (Build.VERSION.SDK_INT >= 17) {
            return Settings.Global.getFloat(context.getContentResolver(), "animator_duration_scale", 1.0f);
        }
        return Settings.System.getFloat(context.getContentResolver(), "animator_duration_scale", 1.0f);
    }

    public static Bitmap pr(Bitmap bitmap, int i, int i2) {
        if (bitmap.getWidth() == i && bitmap.getHeight() == i2) {
            return bitmap;
        }
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, i, i2, true);
        bitmap.recycle();
        return bitmapCreateScaledBitmap;
    }

    public static boolean pr(Throwable th) {
        return (th instanceof SocketException) || (th instanceof ClosedChannelException) || (th instanceof InterruptedIOException) || (th instanceof ProtocolException) || (th instanceof SSLException) || (th instanceof UnknownHostException) || (th instanceof UnknownServiceException);
    }

    public static void pr(Canvas canvas, RectF rectF, Paint paint) {
        pr(canvas, rectF, paint, 31);
    }

    public static void pr(Canvas canvas, RectF rectF, Paint paint, int i) {
        com.byazt.dx.c.pr("Utils#saveLayer");
        if (Build.VERSION.SDK_INT < 23) {
            canvas.saveLayer(rectF, paint, i);
        } else {
            canvas.saveLayer(rectF, paint);
        }
        com.byazt.dx.c.hw("Utils#saveLayer");
    }

    public static float pr(String str, String str2, int i) {
        if (str2 != null) {
            try {
                if (str2.contains("%")) {
                    return (Integer.parseInt(str2.substring(0, str2.length() - 1)) / 100.0f) * i;
                }
                return Integer.parseInt(str2) * pr();
            } catch (Throwable th) {
            }
        }
        if (TextUtils.equals("x", str) || TextUtils.equals("y", str)) {
            return 0.0f;
        }
        return i;
    }
}
