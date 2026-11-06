package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.GradientDrawable;

/* JADX INFO: loaded from: classes2.dex */
public class xr extends GradientDrawable {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected Path f842ms;
    private final Paint xr;

    public xr() {
        this.f842ms = new Path();
        Paint paint = new Paint(1);
        this.xr = paint;
        paint.setColor(-1);
    }

    public xr(GradientDrawable.Orientation orientation, int[] iArr) {
        super(orientation, iArr);
        this.f842ms = new Path();
        Paint paint = new Paint(1);
        this.xr = paint;
        paint.setColor(-1);
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Path path = this.f842ms;
        if (path == null || path.isEmpty()) {
            ms(canvas);
            return;
        }
        int iSaveLayer = canvas.saveLayer(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), this.xr, 31);
        ms(canvas);
        this.xr.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        canvas.drawPath(this.f842ms, this.xr);
        this.xr.setXfermode(null);
        canvas.restoreToCount(iSaveLayer);
    }

    protected void ms(Canvas canvas) {
        super.draw(canvas);
    }

    public void update(int i, int i2, int i3, int i4) {
        this.f842ms.addRect(i, i2, i3, i4, Path.Direction.CW);
        invalidateSelf();
    }
}
