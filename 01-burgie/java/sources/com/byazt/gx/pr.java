package com.byazt.gx;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 63, 37})
public class pr extends hw {
    public final Bitmap hn;
    public final Rect hw = new Rect();
    public final Paint x = new Paint(1);

    public pr(Bitmap bitmap, hw hwVar) {
        this.hn = bitmap;
        if (hwVar != null) {
            this.pr = hwVar.pr;
        }
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        int iHeight = rect.height();
        int iWidth = rect.width();
        int width = this.hn.getWidth();
        int height = this.hn.getHeight();
        this.hw.set(0, 0, width, height);
        if (height < iHeight || width < iWidth) {
            float f = iHeight;
            float f2 = f * 1.0f;
            float f3 = height;
            float f4 = f2 / f3;
            float f5 = iWidth;
            float f6 = 1.0f * f5;
            float f7 = width;
            if (Math.max(f4, f6 / f7) > f4) {
                int i = (int) ((f2 / f5) * f7);
                this.hw.top = (height - i) / 2;
                Rect rect2 = this.hw;
                rect2.bottom = rect2.top + i;
                return;
            }
            int i2 = (int) ((f6 / f) * f3);
            this.hw.left = (width - i2) / 2;
            Rect rect3 = this.hw;
            rect3.right = rect3.left + i2;
            return;
        }
        if (width > iWidth) {
            this.hw.left = (width - iWidth) / 2;
            Rect rect4 = this.hw;
            rect4.right = rect4.left + iWidth;
        }
        if (height > iHeight) {
            this.hw.top = (height - iHeight) / 2;
            Rect rect5 = this.hw;
            rect5.bottom = rect5.top + iHeight;
        }
    }

    @Override // com.byazt.gx.hw
    public void pr(Canvas canvas) {
        canvas.drawBitmap(this.hn, this.hw, getBounds(), this.x);
    }
}
