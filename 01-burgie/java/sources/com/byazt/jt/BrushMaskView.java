package com.byazt.jt;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import com.byazt.ca.ho;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 86, 1364})
public class BrushMaskView extends View {
    public static final String pr = BrushMaskView.class.getSimpleName();
    public Paint c;
    public Paint fw;
    public Bitmap hn;
    public Paint hw;
    public BitmapDrawable uc;
    public Canvas x;
    public Paint zo;

    public void setEraserSize(float f) {
        this.fw.setStrokeWidth(f);
        this.zo.setStrokeWidth(f);
    }

    public void setMaskColor(int i) {
        this.hw.setColor(i);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(pr(i), pr(i2));
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Bitmap bitmap = this.hn;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, this.c);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        pr(i, i2);
    }

    private void pr(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        try {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            this.hn = bitmapCreateBitmap;
            Canvas canvas = this.x;
            if (canvas == null) {
                this.x = new Canvas(this.hn);
            } else {
                canvas.setBitmap(bitmapCreateBitmap);
            }
            this.x.drawRoundRect(new RectF(0.0f, 0.0f, i, i2), 120.0f, 120.0f, this.hw);
            if (this.uc != null) {
                this.uc.setBounds(new Rect(0, 0, i, i2));
                this.uc.draw(this.x);
            }
        } catch (Exception e) {
            ho.hw(pr, e.getMessage());
        }
    }

    private int pr(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode != 1073741824) {
            if (mode != Integer.MIN_VALUE) {
                return 0;
            }
            return Math.min(0, size);
        }
        return size;
    }

    public void setWatermark(int i) {
        if (i == -1) {
            this.uc = null;
        } else {
            this.uc = new BitmapDrawable(BitmapFactory.decodeResource(getResources(), i));
        }
    }
}
