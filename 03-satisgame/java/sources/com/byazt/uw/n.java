package com.byazt.uw;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.Choreographer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1462, 19})
public final class n extends Drawable {
    public Choreographer l;
    public final l n;
    public final qg.q[] qg;
    public final Paint s;
    public boolean w;
    public final Path q = new Path();
    public final Choreographer.FrameCallback x = new Choreographer.FrameCallback() { // from class: com.byazt.uw.n.1
        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j) {
            if (n.this.w) {
                n.this.invalidateSelf();
                if (!n.this.w || n.this.l == null) {
                    return;
                }
                n.this.l.postFrameCallback(this);
            }
        }
    };

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    public n(l lVar) {
        this.n = lVar;
        this.qg = lVar.s();
        Paint paint = new Paint(1);
        this.s = paint;
        paint.setStyle(Paint.Style.FILL);
        if (lVar.qg().n().w == 1) {
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.ADD));
        }
    }

    public void n() {
        if (this.w) {
            return;
        }
        this.w = true;
        try {
            Choreographer choreographer = Choreographer.getInstance();
            this.l = choreographer;
            choreographer.postFrameCallback(this.x);
        } catch (Throwable unused) {
            this.w = false;
        }
    }

    public void qg() {
        this.w = false;
        Choreographer choreographer = this.l;
        if (choreographer != null) {
            choreographer.removeFrameCallback(this.x);
            this.l = null;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.n.n(rect.width(), rect.height());
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        w wVarN;
        int i;
        Rect bounds = getBounds();
        if (bounds.width() <= 0 || bounds.height() <= 0 || (i = (wVarN = this.n.n()).n) <= 0) {
            return;
        }
        int iSave = canvas.save();
        canvas.translate(bounds.left, bounds.top);
        try {
            n(canvas, wVarN, i);
        } finally {
            canvas.restoreToCount(iSave);
        }
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0090  */
    private void n(Canvas canvas, w wVar, int i) {
        int i2;
        qg.n nVar;
        int i3;
        int i4 = i;
        int[] iArrN = n(wVar, i4);
        float[] fArr = wVar.s;
        float[] fArr2 = wVar.q;
        float[] fArr3 = wVar.l;
        float[] fArr4 = wVar.w;
        int[] iArr = wVar.fs;
        qg.q[] qVarArr = this.qg;
        int i5 = 0;
        while (i5 < i4) {
            int i6 = iArrN[i5];
            int i7 = iArr[i6];
            if (i7 < 0 || i7 >= qVarArr.length || (nVar = qVarArr[i7].d) == null) {
                i2 = i5;
            } else {
                float f = fArr3[i6];
                float f2 = nVar.s * f;
                float f3 = nVar.q * f;
                if (f2 <= 0.0f || f3 <= 0.0f || (i3 = (int) ((fArr4[i6] * 255.0f) + 0.5f)) <= 0) {
                    i2 = i5;
                } else {
                    i2 = i5;
                    if (i3 > 255) {
                        i3 = 255;
                    }
                    this.s.setColor(nVar.l);
                    this.s.setAlpha(i3);
                    float f4 = fArr[i6];
                    float f5 = fArr2[i6];
                    int i8 = nVar.qg;
                    if (i8 == 1) {
                        float f6 = f2 / 2.0f;
                        float f7 = f3 / 2.0f;
                        canvas.drawRect(f4 - f6, f5 - f7, f6 + f4, f7 + f5, this.s);
                    } else if (i8 == 2) {
                        n(canvas, f4, f5, Math.min(f2, f3) / 2.0f);
                    } else {
                        canvas.drawCircle(f4, f5, Math.min(f2, f3) / 2.0f, this.s);
                    }
                }
            }
            i5 = i2 + 1;
            i4 = i;
        }
    }

    private int[] n(w wVar, int i) {
        int[] iArr = wVar.rv;
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2] = i2;
        }
        int i3 = wVar.qg;
        if (i3 != 0 && i3 != 1 && i > 1) {
            n(iArr, wVar.x, i, i3 == 4);
        }
        return iArr;
    }

    private static void n(int[] iArr, float[] fArr, int i, boolean z) {
        for (int i2 = 1; i2 < i; i2++) {
            int i3 = iArr[i2];
            float f = fArr[i3];
            int i4 = i2 - 1;
            if (!z) {
                while (i4 >= 0) {
                    int i5 = iArr[i4];
                    if (fArr[i5] >= f) {
                        break;
                    }
                    iArr[i4 + 1] = i5;
                    i4--;
                }
            } else {
                while (i4 >= 0) {
                    int i6 = iArr[i4];
                    if (fArr[i6] <= f) {
                        break;
                    }
                    iArr[i4 + 1] = i6;
                    i4--;
                }
            }
            iArr[i4 + 1] = i3;
        }
    }

    private void n(Canvas canvas, float f, float f2, float f3) {
        float f4 = 0.5f * f3;
        Path path = this.q;
        path.rewind();
        float f5 = -1.5707964f;
        for (int i = 0; i < 10; i++) {
            float f6 = i % 2 == 0 ? f3 : f4;
            double d = f5;
            float fCos = (((float) Math.cos(d)) * f6) + f;
            float fSin = (((float) Math.sin(d)) * f6) + f2;
            if (i == 0) {
                path.moveTo(fCos, fSin);
            } else {
                path.lineTo(fCos, fSin);
            }
            f5 += 0.62831855f;
        }
        path.close();
        canvas.drawPath(path, this.s);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.s.setColorFilter(colorFilter);
    }
}
