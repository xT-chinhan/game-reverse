package com.bytedance.sdk.component.adexpress.widget;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import com.bytedance.sdk.component.utils.sl;

/* JADX INFO: loaded from: classes2.dex */
public class BrushMaskView extends View {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final String f914ms = "BrushMaskView";
    private Paint ab;
    private Bitmap ah;
    private BitmapDrawable c;
    private Canvas d;
    private Paint ka;
    private Paint x;
    private Paint xr;

    public void setEraserSize(float f) {
        this.ab.setStrokeWidth(f);
        this.x.setStrokeWidth(f);
    }

    public void setMaskColor(int i) {
        this.xr.setColor(i);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(ms(i), ms(i2));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Bitmap bitmap = this.ah;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, this.ka);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        ms(i, i2);
    }

    private void ms(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        try {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            this.ah = bitmapCreateBitmap;
            Canvas canvas = this.d;
            if (canvas == null) {
                this.d = new Canvas(this.ah);
            } else {
                canvas.setBitmap(bitmapCreateBitmap);
            }
            this.d.drawRoundRect(new RectF(0.0f, 0.0f, i, i2), 120.0f, 120.0f, this.xr);
            if (this.c != null) {
                this.c.setBounds(new Rect(0, 0, i, i2));
                this.c.draw(this.d);
            }
        } catch (Exception e) {
            sl.d(f914ms, e.getMessage());
        }
    }

    private int ms(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            return size;
        }
        if (mode == Integer.MIN_VALUE) {
            return Math.min(0, size);
        }
        return 0;
    }

    public void setWatermark(int i) {
        if (i == -1) {
            this.c = null;
        } else {
            this.c = new BitmapDrawable(BitmapFactory.decodeResource(getResources(), i));
        }
    }
}
