package com.byazt.qnt;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 2280, 37})
public class pr {
    public int c;
    public final int fw;
    public final Bitmap.Config hn;
    public final int uc;
    public int x;
    public final ImageView.ScaleType zo;
    public static final ImageView.ScaleType pr = ImageView.ScaleType.CENTER_INSIDE;
    public static final Bitmap.Config hw = Bitmap.Config.ARGB_4444;
    public final int aj = 3840;
    public final int vk = 104857600;

    public pr(int i, int i2, ImageView.ScaleType scaleType, Bitmap.Config config, int i3, int i4) {
        this.hn = config;
        this.x = i;
        this.c = i2;
        this.zo = scaleType;
        this.uc = i3;
        this.fw = i4;
        pr(i, i2);
    }

    public static int pr(int i, int i2, int i3, int i4, int i5, int i6) {
        double dMin = Math.min(((double) i) / ((double) i3), ((double) i2) / ((double) i4));
        if (i5 > 0 && i6 > 0) {
            dMin = Math.max(dMin, Math.min(((double) Math.max(i, i2)) / ((double) Math.max(i5, i6)), ((double) Math.min(i, i2)) / ((double) Math.min(i5, i6))));
        }
        float f = 1.0f;
        while (true) {
            float f2 = 2.0f * f;
            if (f2 <= dMin) {
                f = f2;
            } else {
                return (int) f;
            }
        }
    }

    private static int pr(int i, int i2, int i3, int i4, ImageView.ScaleType scaleType) {
        if (i == 0 && i2 == 0) {
            return i3;
        }
        if (scaleType == ImageView.ScaleType.FIT_XY) {
            if (i == 0) {
                return i3;
            }
            return i;
        }
        if (i == 0) {
            return (int) (((double) i3) * (((double) i2) / ((double) i4)));
        }
        if (i2 == 0) {
            return i;
        }
        double d = ((double) i4) / ((double) i3);
        if (scaleType == ImageView.ScaleType.CENTER_CROP) {
            double d2 = i2;
            if (((double) i) * d < d2) {
                return (int) (d2 / d);
            }
            return i;
        }
        double d3 = i2;
        if (((double) i) * d > d3) {
            return (int) (d3 / d);
        }
        return i;
    }

    public Bitmap pr(byte[] bArr) {
        Bitmap bitmapDecodeByteArray;
        BitmapFactory.Options options = new BitmapFactory.Options();
        if (this.x == 0 && this.c == 0) {
            options.inPreferredConfig = this.hn;
            bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        } else {
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            int i = options.outWidth;
            int i2 = options.outHeight;
            int iPr = pr(this.x, this.c, i, i2, this.zo);
            int iPr2 = pr(this.c, this.x, i2, i, this.zo);
            options.inJustDecodeBounds = false;
            options.inSampleSize = pr(i, i2, iPr, iPr2, this.uc, this.fw);
            bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            if (bitmapDecodeByteArray != null && (bitmapDecodeByteArray.getWidth() > iPr || bitmapDecodeByteArray.getHeight() > iPr2)) {
                Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapDecodeByteArray, iPr, iPr2, true);
                if (bitmapCreateScaledBitmap != bitmapDecodeByteArray) {
                    bitmapDecodeByteArray.recycle();
                }
                bitmapDecodeByteArray = bitmapCreateScaledBitmap;
            }
        }
        if (Build.VERSION.SDK_INT >= 12 && bitmapDecodeByteArray != null && bitmapDecodeByteArray.getByteCount() > 104857600) {
            int width = bitmapDecodeByteArray.getWidth() / 2;
            int height = bitmapDecodeByteArray.getHeight() / 2;
            if (width > 0 && height > 0) {
                Bitmap bitmapCreateScaledBitmap2 = Bitmap.createScaledBitmap(bitmapDecodeByteArray, width, height, true);
                if (bitmapCreateScaledBitmap2 != bitmapDecodeByteArray) {
                    bitmapDecodeByteArray.recycle();
                }
                return bitmapCreateScaledBitmap2;
            }
        }
        return bitmapDecodeByteArray;
    }

    private void pr(int i, int i2) {
        if (i > 3840 && i2 > 3840) {
            if (i > i2) {
                this.x = 3840;
                this.c = (i2 * 3840) / i;
                return;
            } else {
                this.x = (i * 3840) / i2;
                this.c = 3840;
                return;
            }
        }
        if (i > 3840) {
            this.x = 3840;
            this.c = (i2 * 3840) / i;
        } else if (i2 > 3840) {
            this.x = (i * 3840) / i2;
            this.c = 3840;
        }
    }
}
