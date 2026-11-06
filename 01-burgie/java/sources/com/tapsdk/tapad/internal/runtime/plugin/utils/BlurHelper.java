package com.tapsdk.tapad.internal.runtime.plugin.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;

/* JADX INFO: loaded from: classes3.dex */
public final class BlurHelper {
    private BlurHelper() {
    }

    private static Bitmap applyBoxBlur(Bitmap bitmap, int i) {
        if (bitmap == null || i < 1) {
            return bitmap;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i2 = width * height;
        int[] iArr = new int[i2];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        int[] iArr2 = new int[i2];
        for (int i3 = 0; i3 < height; i3++) {
            for (int i4 = 0; i4 < width; i4++) {
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                int i8 = 0;
                int i9 = 0;
                for (int i10 = -i; i10 <= i; i10++) {
                    int i11 = iArr[(i3 * width) + Math.max(0, Math.min(width - 1, i4 + i10))];
                    i5 += (i11 >> 24) & 255;
                    i7 += (i11 >> 16) & 255;
                    i8 += (i11 >> 8) & 255;
                    i9 += i11 & 255;
                    i6++;
                }
                iArr2[(i3 * width) + i4] = ((i5 / i6) << 24) | ((i7 / i6) << 16) | ((i8 / i6) << 8) | (i9 / i6);
            }
        }
        int[] iArr3 = new int[i2];
        for (int i12 = 0; i12 < height; i12++) {
            for (int i13 = 0; i13 < width; i13++) {
                int i14 = 0;
                int i15 = 0;
                int i16 = 0;
                int i17 = 0;
                int i18 = 0;
                for (int i19 = -i; i19 <= i; i19++) {
                    int i20 = iArr2[(Math.max(0, Math.min(height - 1, i12 + i19)) * width) + i13];
                    i14 += (i20 >> 24) & 255;
                    i16 += (i20 >> 16) & 255;
                    i17 += (i20 >> 8) & 255;
                    i18 += i20 & 255;
                    i15++;
                }
                iArr3[(i12 * width) + i13] = ((i14 / i15) << 24) | ((i16 / i15) << 16) | ((i17 / i15) << 8) | (i18 / i15);
            }
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, bitmap.getConfig() == null ? Bitmap.Config.ARGB_8888 : bitmap.getConfig());
        bitmapCreateBitmap.setPixels(iArr3, 0, width, 0, 0, width, height);
        return bitmapCreateBitmap;
    }

    public static Bitmap fastBlur(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        return instantFakeBlur(bitmap);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v5, types: [int] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v9, types: [android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r3v3, types: [int] */
    private static Bitmap instantFakeBlur(Bitmap bitmap) throws Throwable {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f = 20;
        float f2 = width;
        float f3 = height;
        float fMin = Math.min(f / f2, f / f3);
        ?? Max = Math.max(1, (int) (f2 * fMin));
        Bitmap bitmapMax = Math.max(1, (int) (f3 * fMin));
        Bitmap bitmap2 = 0;
        bitmap = null;
        bitmap = null;
        bitmap = null;
        bitmap2 = 0;
        Bitmap bitmap3 = null;
        try {
            try {
                bitmapMax = Bitmap.createScaledBitmap(bitmap, Max, bitmapMax, false);
                try {
                    Bitmap bitmapApplyBoxBlur = applyBoxBlur(bitmapMax, 1);
                    try {
                        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, bitmap.getConfig() == null ? Bitmap.Config.ARGB_8888 : bitmap.getConfig());
                        try {
                            Paint paint = new Paint(3);
                            ColorMatrix colorMatrix = new ColorMatrix();
                            colorMatrix.setScale(0.85f, 0.85f, 0.85f, 1.0f);
                            ColorMatrix colorMatrix2 = new ColorMatrix();
                            colorMatrix2.setSaturation(0.75f);
                            colorMatrix.postConcat(colorMatrix2);
                            paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
                            new Canvas(bitmapCreateBitmap).drawBitmap(bitmapApplyBoxBlur, (Rect) null, new Rect(0, 0, width, height), paint);
                            safeRecycle(bitmapMax, bitmap, bitmapApplyBoxBlur);
                            safeRecycle(bitmapApplyBoxBlur, bitmap);
                            return bitmapCreateBitmap;
                        } catch (OutOfMemoryError | RuntimeException e) {
                            e = e;
                            bitmap3 = bitmapCreateBitmap;
                            safeRecycle(bitmap3, bitmap);
                            throw e;
                        }
                    } catch (OutOfMemoryError e2) {
                        e = e2;
                    } catch (RuntimeException e3) {
                        e = e3;
                    }
                } catch (OutOfMemoryError e4) {
                    e = e4;
                    safeRecycle(bitmap3, bitmap);
                    throw e;
                } catch (RuntimeException e5) {
                    e = e5;
                    safeRecycle(bitmap3, bitmap);
                    throw e;
                } catch (Throwable th) {
                    th = th;
                    safeRecycle(bitmapMax, bitmap, bitmap2);
                    safeRecycle(bitmap2, bitmap);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                bitmap2 = Max;
            }
        } catch (OutOfMemoryError e6) {
            e = e6;
            safeRecycle(bitmap3, bitmap);
            throw e;
        } catch (RuntimeException e7) {
            e = e7;
            safeRecycle(bitmap3, bitmap);
            throw e;
        } catch (Throwable th3) {
            th = th3;
            bitmapMax = 0;
        }
    }

    private static void safeRecycle(Bitmap bitmap, Bitmap... bitmapArr) {
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        for (Bitmap bitmap2 : bitmapArr) {
            if (bitmap == bitmap2) {
                return;
            }
        }
        try {
            bitmap.recycle();
        } catch (RuntimeException e) {
        }
    }
}
