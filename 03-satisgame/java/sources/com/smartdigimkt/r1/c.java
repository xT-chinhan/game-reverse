package com.smartdigimkt.r1;

import android.content.Context;
import android.graphics.Bitmap;
import java.util.Random;

/* JADX INFO: loaded from: classes3.dex */
public final class c {
    public Bitmap a;
    public final int b;
    public final int c;
    public final float d;
    public float e;
    public float f;

    public c(Context context, Bitmap bitmap, double d, double d2, int i) {
        i = i == 0 ? Math.min(context.getResources().getDisplayMetrics().widthPixels, context.getResources().getDisplayMetrics().heightPixels) : i;
        double dNextInt = ((d * 100.0d) + ((double) new Random().nextInt(6))) / 100.0d;
        if (dNextInt >= d && dNextInt <= d2) {
            d2 = dNextInt;
        }
        int i2 = (int) (((double) i) * d2);
        this.b = i2;
        if (bitmap != null && !bitmap.isRecycled()) {
            int height = (bitmap.getHeight() * i2) / bitmap.getWidth();
            this.c = height;
            try {
                this.a = Bitmap.createScaledBitmap(bitmap, i2, height, true);
            } catch (Throwable th) {
                th.getMessage();
            }
        }
        this.d = (new Random().nextFloat() * 30.0f) - 15.0f;
    }
}
