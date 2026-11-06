package com.byazt.eg;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 959, 21})
public class x extends s {
    public com.byazt.bd.n<ColorFilter, ColorFilter> cp;
    public com.byazt.bd.n<Bitmap, Bitmap> d;
    public final Paint fs;
    public final Rect rv;
    public final Rect tj;
    public final com.byazt.pp.rv x;

    public x(com.byazt.pp.fs fsVar, fs fsVar2) {
        super(fsVar, fsVar2);
        this.fs = new com.byazt.ft.n(3);
        this.rv = new Rect();
        this.tj = new Rect();
        this.x = fsVar.w(fsVar2.x());
    }

    @Override // com.byazt.eg.s
    public void qg(Canvas canvas, Matrix matrix, int i) {
        super.qg(canvas, matrix, i);
        Bitmap bitmapSz = sz();
        if (bitmapSz == null || bitmapSz.isRecycled() || this.x == null || bitmapSz.getWidth() <= 0 || bitmapSz.getHeight() <= 0) {
            return;
        }
        float fN = com.byazt.nu.tj.n();
        this.fs.setAlpha(i);
        com.byazt.bd.n<ColorFilter, ColorFilter> nVar = this.cp;
        if (nVar != null) {
            this.fs.setColorFilter(nVar.x());
        }
        canvas.save();
        canvas.concat(matrix);
        this.rv.set(0, 0, bitmapSz.getWidth(), bitmapSz.getHeight());
        int iN = (int) (this.x.n() * fN);
        int iQg = (int) (this.x.qg() * fN);
        if (this.qg.w()) {
            this.tj.set(0, 0, iN, iQg);
        } else {
            float fMin = Math.min(iN / bitmapSz.getWidth(), iQg / bitmapSz.getHeight());
            int iRound = Math.round(bitmapSz.getWidth() * fMin);
            int iRound2 = Math.round(bitmapSz.getHeight() * fMin);
            int iRound3 = Math.round((iN - iRound) / 2.0f);
            int iRound4 = Math.round((iQg - iRound2) / 2.0f);
            this.tj.set(iRound3, iRound4, iRound + iRound3, iRound2 + iRound4);
        }
        canvas.drawBitmap(bitmapSz, this.rv, this.tj, this.fs);
        canvas.restore();
    }

    @Override // com.byazt.eg.s, com.byazt.sp.l
    public void n(RectF rectF, Matrix matrix, boolean z) {
        super.n(rectF, matrix, z);
        if (this.x != null) {
            float fN = com.byazt.nu.tj.n();
            rectF.set(0.0f, 0.0f, this.x.n() * fN, this.x.qg() * fN);
            this.n.mapRect(rectF);
        }
    }

    public Bitmap sz() {
        Bitmap bitmapX;
        com.byazt.bd.n<Bitmap, Bitmap> nVar = this.d;
        if (nVar != null && (bitmapX = nVar.x()) != null) {
            return bitmapX;
        }
        Bitmap bitmapL = this.qg.l(this.s.x());
        if (bitmapL != null) {
            return bitmapL;
        }
        com.byazt.pp.rv rvVar = this.x;
        if (rvVar != null) {
            return rvVar.k();
        }
        return null;
    }
}
