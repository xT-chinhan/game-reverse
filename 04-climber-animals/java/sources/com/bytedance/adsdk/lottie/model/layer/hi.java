package com.bytedance.adsdk.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;

/* JADX INFO: loaded from: classes2.dex */
public class hi extends ah {
    private final RectF ab;
    private final Path ch;
    private final x hi;
    private final float[] ny;
    private com.bytedance.adsdk.lottie.ms.xr.ms<ColorFilter, ColorFilter> sl;
    private final Paint x;

    hi(com.bytedance.adsdk.lottie.x xVar, x xVar2) {
        super(xVar, xVar2);
        this.ab = new RectF();
        com.bytedance.adsdk.lottie.ms.ms msVar = new com.bytedance.adsdk.lottie.ms.ms();
        this.x = msVar;
        this.ny = new float[8];
        this.ch = new Path();
        this.hi = xVar2;
        msVar.setAlpha(0);
        msVar.setStyle(Paint.Style.FILL);
        msVar.setColor(xVar2.ao());
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.ah
    public void xr(Canvas canvas, Matrix matrix, int i) {
        super.xr(canvas, matrix, i);
        int iAlpha = Color.alpha(this.hi.ao());
        if (iAlpha == 0) {
            return;
        }
        int iIntValue = (int) ((i / 255.0f) * (((iAlpha / 255.0f) * (this.d.ms() == null ? 100 : this.d.ms().ab().intValue())) / 100.0f) * 255.0f);
        this.x.setAlpha(iIntValue);
        com.bytedance.adsdk.lottie.ms.xr.ms<ColorFilter, ColorFilter> msVar = this.sl;
        if (msVar != null) {
            this.x.setColorFilter(msVar.ab());
        }
        if (iIntValue > 0) {
            float[] fArr = this.ny;
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            fArr[2] = this.hi.qv();
            float[] fArr2 = this.ny;
            fArr2[3] = 0.0f;
            fArr2[4] = this.hi.qv();
            this.ny[5] = this.hi.h();
            float[] fArr3 = this.ny;
            fArr3[6] = 0.0f;
            fArr3[7] = this.hi.h();
            matrix.mapPoints(this.ny);
            this.ch.reset();
            Path path = this.ch;
            float[] fArr4 = this.ny;
            path.moveTo(fArr4[0], fArr4[1]);
            Path path2 = this.ch;
            float[] fArr5 = this.ny;
            path2.lineTo(fArr5[2], fArr5[3]);
            Path path3 = this.ch;
            float[] fArr6 = this.ny;
            path3.lineTo(fArr6[4], fArr6[5]);
            Path path4 = this.ch;
            float[] fArr7 = this.ny;
            path4.lineTo(fArr7[6], fArr7[7]);
            Path path5 = this.ch;
            float[] fArr8 = this.ny;
            path5.lineTo(fArr8[0], fArr8[1]);
            this.ch.close();
            canvas.drawPath(this.ch, this.x);
        }
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.ah, com.bytedance.adsdk.lottie.ms.ms.ka
    public void ms(RectF rectF, Matrix matrix, boolean z) {
        super.ms(rectF, matrix, z);
        this.ab.set(0.0f, 0.0f, this.hi.qv(), this.hi.h());
        this.f183ms.mapRect(this.ab);
        rectF.set(this.ab);
    }
}
