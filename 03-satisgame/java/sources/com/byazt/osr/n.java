package com.byazt.osr;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 38, 19})
public class n extends qg {
    public final Bitmap s;
    public final Rect qg = new Rect();
    public final Paint q = new Paint(1);

    public n(Bitmap bitmap, qg qgVar) {
        this.s = bitmap;
        if (qgVar != null) {
            this.n = qgVar.n;
        }
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        int iHeight = rect.height();
        int iWidth = rect.width();
        int width = this.s.getWidth();
        int height = this.s.getHeight();
        this.qg.set(0, 0, width, height);
        if (height >= iHeight && width >= iWidth) {
            if (width > iWidth) {
                this.qg.left = (width - iWidth) / 2;
                Rect rect2 = this.qg;
                rect2.right = rect2.left + iWidth;
            }
            if (height > iHeight) {
                this.qg.top = (height - iHeight) / 2;
                Rect rect3 = this.qg;
                rect3.bottom = rect3.top + iHeight;
                return;
            }
            return;
        }
        float f = iHeight;
        float f2 = f * 1.0f;
        float f3 = height;
        float f4 = f2 / f3;
        float f5 = iWidth;
        float f6 = 1.0f * f5;
        float f7 = width;
        if (Math.max(f4, f6 / f7) > f4) {
            int i = (int) ((f2 / f5) * f7);
            this.qg.top = (height - i) / 2;
            Rect rect4 = this.qg;
            rect4.bottom = rect4.top + i;
            return;
        }
        int i2 = (int) ((f6 / f) * f3);
        this.qg.left = (width - i2) / 2;
        Rect rect5 = this.qg;
        rect5.right = rect5.left + i2;
    }

    @Override // com.byazt.osr.qg
    public void n(Canvas canvas) {
        canvas.drawBitmap(this.s, this.qg, getBounds(), this.q);
    }
}
