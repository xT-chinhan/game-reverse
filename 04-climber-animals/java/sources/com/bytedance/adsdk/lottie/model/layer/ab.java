package com.bytedance.adsdk.lottie.model.layer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

/* JADX INFO: loaded from: classes2.dex */
public class ab extends ah {
    protected final com.bytedance.adsdk.lottie.ny ab;
    private final Rect ch;
    private com.bytedance.adsdk.lottie.ms.xr.ms<ColorFilter, ColorFilter> hi;
    private final Rect ny;
    private com.bytedance.adsdk.lottie.ms.xr.ms<Bitmap, Bitmap> sl;
    private final Paint x;

    ab(com.bytedance.adsdk.lottie.x xVar, x xVar2) {
        super(xVar, xVar2);
        this.x = new com.bytedance.adsdk.lottie.ms.ms(3);
        this.ny = new Rect();
        this.ch = new Rect();
        this.ab = xVar.c(xVar2.ab());
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.ah
    public void xr(Canvas canvas, Matrix matrix, int i) {
        super.xr(canvas, matrix, i);
        Bitmap bitmapU = u();
        if (bitmapU == null || bitmapU.isRecycled() || this.ab == null) {
            return;
        }
        float fMs = com.bytedance.adsdk.lottie.ka.ny.ms();
        this.x.setAlpha(i);
        com.bytedance.adsdk.lottie.ms.xr.ms<ColorFilter, ColorFilter> msVar = this.hi;
        if (msVar != null) {
            this.x.setColorFilter(msVar.ab());
        }
        canvas.save();
        canvas.concat(matrix);
        this.ny.set(0, 0, bitmapU.getWidth(), bitmapU.getHeight());
        if (this.xr.c()) {
            this.ch.set(0, 0, (int) (this.ab.ms() * fMs), (int) (this.ab.xr() * fMs));
        } else {
            this.ch.set(0, 0, (int) (bitmapU.getWidth() * fMs), (int) (bitmapU.getHeight() * fMs));
        }
        canvas.drawBitmap(bitmapU, this.ny, this.ch, this.x);
        canvas.restore();
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.ah, com.bytedance.adsdk.lottie.ms.ms.ka
    public void ms(RectF rectF, Matrix matrix, boolean z) {
        super.ms(rectF, matrix, z);
        if (this.ab != null) {
            float fMs = com.bytedance.adsdk.lottie.ka.ny.ms();
            rectF.set(0.0f, 0.0f, this.ab.ms() * fMs, this.ab.xr() * fMs);
            this.f183ms.mapRect(rectF);
        }
    }

    private Bitmap u() {
        Bitmap bitmapAb;
        com.bytedance.adsdk.lottie.ms.xr.ms<Bitmap, Bitmap> msVar = this.sl;
        if (msVar != null && (bitmapAb = msVar.ab()) != null) {
            return bitmapAb;
        }
        Bitmap bitmapKa = this.xr.ka(this.ah.ab());
        if (bitmapKa != null) {
            return bitmapKa;
        }
        com.bytedance.adsdk.lottie.ny nyVar = this.ab;
        if (nyVar != null) {
            return nyVar.u();
        }
        return null;
    }
}
