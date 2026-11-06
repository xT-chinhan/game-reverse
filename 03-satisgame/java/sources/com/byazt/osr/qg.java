package com.byazt.osr;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.GradientDrawable;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 38, 26})
public class qg extends GradientDrawable {
    public Path n;
    public final Paint qg;

    public qg() {
        this.n = new Path();
        Paint paint = new Paint(1);
        this.qg = paint;
        paint.setColor(-1);
    }

    public qg(GradientDrawable.Orientation orientation, int[] iArr) {
        super(orientation, iArr);
        this.n = new Path();
        Paint paint = new Paint(1);
        this.qg = paint;
        paint.setColor(-1);
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Path path = this.n;
        if (path == null || path.isEmpty()) {
            n(canvas);
            return;
        }
        int iSaveLayer = canvas.saveLayer(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), this.qg, 31);
        n(canvas);
        this.qg.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        canvas.drawPath(this.n, this.qg);
        this.qg.setXfermode(null);
        canvas.restoreToCount(iSaveLayer);
    }

    public void n(Canvas canvas) {
        super.draw(canvas);
    }

    public void update(int i, int i2, int i3, int i4) {
        this.n.addRect(i, i2, i3, i4, Path.Direction.CW);
        invalidateSelf();
    }
}
