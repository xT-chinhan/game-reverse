package com.byazt.gs;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.RectF;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1650, 1651})
public class ClipImageView extends ImageView {
    public float[] l;
    public boolean n;
    public Paint q;
    public Path qg;
    public RectF s;

    public ClipImageView(Context context) {
        super(context);
        this.n = true;
        n(context);
    }

    public void n(Context context) {
        this.qg = new Path();
        this.s = new RectF();
    }

    public void setRadius(float[] fArr) {
        if (fArr == null || fArr.length != 8) {
            return;
        }
        this.l = fArr;
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        Paint paint = new Paint(1);
        this.q = paint;
        paint.setStyle(Paint.Style.FILL);
        this.q.setColor(i);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.n) {
            this.qg.reset();
            this.s.set(0.0f, 0.0f, getWidth(), getHeight());
            float[] fArr = this.l;
            if (fArr != null) {
                this.qg.addRoundRect(this.s, fArr, Path.Direction.CW);
            }
            canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
            canvas.clipPath(this.qg);
            Paint paint = this.q;
            if (paint != null) {
                canvas.drawPath(this.qg, paint);
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
        this.n = z;
    }
}
