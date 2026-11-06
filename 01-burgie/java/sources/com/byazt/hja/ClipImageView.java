package com.byazt.hja;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.RectF;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1512, 1513})
public class ClipImageView extends ImageView {
    public float[] c;
    public RectF hn;
    public Path hw;
    public boolean pr;
    public Paint x;

    public ClipImageView(Context context) {
        super(context);
        this.pr = true;
        pr(context);
    }

    public void pr(Context context) {
        this.hw = new Path();
        this.hn = new RectF();
    }

    public void setRadius(float[] fArr) {
        if (fArr == null || fArr.length != 8) {
            return;
        }
        this.c = fArr;
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        Paint paint = new Paint(1);
        this.x = paint;
        paint.setStyle(Paint.Style.FILL);
        this.x.setColor(i);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.pr) {
            this.hw.reset();
            this.hn.set(0.0f, 0.0f, getWidth(), getHeight());
            float[] fArr = this.c;
            if (fArr != null) {
                this.hw.addRoundRect(this.hn, fArr, Path.Direction.CW);
            }
            canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
            canvas.clipPath(this.hw);
            Paint paint = this.x;
            if (paint != null) {
                canvas.drawPath(this.hw, paint);
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
        this.pr = z;
    }
}
