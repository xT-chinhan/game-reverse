package com.byazt.gx;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.GradientDrawable;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 63, 13})
public class hw extends GradientDrawable {
    public final Paint hw;
    public Path pr;

    public hw() {
        this.pr = new Path();
        Paint paint = new Paint(1);
        this.hw = paint;
        paint.setColor(-1);
    }

    public hw(GradientDrawable.Orientation orientation, int[] iArr) {
        super(orientation, iArr);
        this.pr = new Path();
        Paint paint = new Paint(1);
        this.hw = paint;
        paint.setColor(-1);
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Path path = this.pr;
        if (path == null || path.isEmpty()) {
            pr(canvas);
            return;
        }
        int iSaveLayer = canvas.saveLayer(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), this.hw, 31);
        pr(canvas);
        this.hw.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        canvas.drawPath(this.pr, this.hw);
        this.hw.setXfermode(null);
        canvas.restoreToCount(iSaveLayer);
    }

    public void pr(Canvas canvas) {
        super.draw(canvas);
    }

    public void update(int i, int i2, int i3, int i4) {
        this.pr.addRect(i, i2, i3, i4, Path.Direction.CW);
        invalidateSelf();
    }
}
