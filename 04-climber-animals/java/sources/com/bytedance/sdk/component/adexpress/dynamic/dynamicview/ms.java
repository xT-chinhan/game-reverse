package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

/* JADX INFO: loaded from: classes2.dex */
public class ms extends xr {
    private final Bitmap ah;
    private final Rect xr = new Rect();
    private final Paint d = new Paint(1);

    public ms(Bitmap bitmap, xr xrVar) {
        this.ah = bitmap;
        if (xrVar != null) {
            this.f842ms = xrVar.f842ms;
        }
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        int iHeight = rect.height();
        int iWidth = rect.width();
        int width = this.ah.getWidth();
        int height = this.ah.getHeight();
        this.xr.set(0, 0, width, height);
        if (height >= iHeight && width >= iWidth) {
            if (width > iWidth) {
                this.xr.left = (width - iWidth) / 2;
                Rect rect2 = this.xr;
                rect2.right = rect2.left + iWidth;
            }
            if (height > iHeight) {
                this.xr.top = (height - iHeight) / 2;
                Rect rect3 = this.xr;
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
            this.xr.top = (height - i) / 2;
            Rect rect4 = this.xr;
            rect4.bottom = rect4.top + i;
            return;
        }
        int i2 = (int) ((f6 / f) * f3);
        this.xr.left = (width - i2) / 2;
        Rect rect5 = this.xr;
        rect5.right = rect5.left + i2;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.xr
    protected void ms(Canvas canvas) {
        canvas.drawBitmap(this.ah, this.xr, getBounds(), this.d);
    }
}
