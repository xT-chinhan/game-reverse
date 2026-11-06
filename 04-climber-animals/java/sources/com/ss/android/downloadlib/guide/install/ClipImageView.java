package com.ss.android.downloadlib.guide.install;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes3.dex */
public class ClipImageView extends ImageView {
    private RectF ah;
    private Paint d;
    private float[] ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private boolean f4496ms;
    private Path xr;

    public ClipImageView(Context context) {
        super(context);
        this.f4496ms = true;
        ms(context);
    }

    public ClipImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4496ms = true;
        ms(context);
    }

    public ClipImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4496ms = true;
        ms(context);
    }

    protected void ms(Context context) {
        this.xr = new Path();
        this.ah = new RectF();
    }

    public void setRadius(float[] fArr) {
        if (fArr == null || fArr.length != 8) {
            return;
        }
        this.ka = fArr;
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        Paint paint = new Paint(1);
        this.d = paint;
        paint.setStyle(Paint.Style.FILL);
        this.d.setColor(i);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.f4496ms) {
            this.xr.reset();
            this.ah.set(0.0f, 0.0f, getWidth(), getHeight());
            float[] fArr = this.ka;
            if (fArr != null) {
                this.xr.addRoundRect(this.ah, fArr, Path.Direction.CW);
            }
            canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
            canvas.clipPath(this.xr);
            Paint paint = this.d;
            if (paint != null) {
                canvas.drawPath(this.xr, paint);
            }
        }
        super.onDraw(canvas);
    }

    public void setRoundRadius(int i) {
        if (i > 0) {
            float f = i;
            setRadius(new float[]{f, f, f, f, f, f, f, f});
        }
    }

    public void setClip(boolean z) {
        this.f4496ms = z;
    }
}
