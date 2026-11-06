package com.byazt.eg;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 959, 29})
public class cp extends s {
    public final fs cp;
    public com.byazt.bd.n<ColorFilter, ColorFilter> d;
    public final Paint fs;
    public final float[] rv;
    public final Path tj;
    public final RectF x;

    public cp(com.byazt.pp.fs fsVar, fs fsVar2) {
        super(fsVar, fsVar2);
        this.x = new RectF();
        com.byazt.ft.n nVar = new com.byazt.ft.n();
        this.fs = nVar;
        this.rv = new float[8];
        this.tj = new Path();
        this.cp = fsVar2;
        nVar.setAlpha(0);
        nVar.setStyle(Paint.Style.FILL);
        nVar.setColor(fsVar2.cy());
    }

    @Override // com.byazt.eg.s
    public void qg(Canvas canvas, Matrix matrix, int i) {
        super.qg(canvas, matrix, i);
        int iAlpha = Color.alpha(this.cp.cy());
        if (iAlpha == 0) {
            return;
        }
        int iIntValue = (int) ((i / 255.0f) * (((iAlpha / 255.0f) * (this.q.n() == null ? 100 : this.q.n().x().intValue())) / 100.0f) * 255.0f);
        this.fs.setAlpha(iIntValue);
        com.byazt.bd.n<ColorFilter, ColorFilter> nVar = this.d;
        if (nVar != null) {
            this.fs.setColorFilter(nVar.x());
        }
        if (iIntValue > 0) {
            float[] fArr = this.rv;
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            fArr[2] = this.cp.cd();
            float[] fArr2 = this.rv;
            fArr2[3] = 0.0f;
            fArr2[4] = this.cp.cd();
            this.rv[5] = this.cp.hd();
            float[] fArr3 = this.rv;
            fArr3[6] = 0.0f;
            fArr3[7] = this.cp.hd();
            matrix.mapPoints(this.rv);
            this.tj.reset();
            Path path = this.tj;
            float[] fArr4 = this.rv;
            path.moveTo(fArr4[0], fArr4[1]);
            Path path2 = this.tj;
            float[] fArr5 = this.rv;
            path2.lineTo(fArr5[2], fArr5[3]);
            Path path3 = this.tj;
            float[] fArr6 = this.rv;
            path3.lineTo(fArr6[4], fArr6[5]);
            Path path4 = this.tj;
            float[] fArr7 = this.rv;
            path4.lineTo(fArr7[6], fArr7[7]);
            Path path5 = this.tj;
            float[] fArr8 = this.rv;
            path5.lineTo(fArr8[0], fArr8[1]);
            this.tj.close();
            canvas.drawPath(this.tj, this.fs);
        }
    }

    @Override // com.byazt.eg.s, com.byazt.sp.l
    public void n(RectF rectF, Matrix matrix, boolean z) {
        super.n(rectF, matrix, z);
        this.x.set(0.0f, 0.0f, this.cp.cd(), this.cp.hd());
        this.n.mapRect(this.x);
        rectF.set(this.x);
    }
}
