package com.smartdigimkt.sdk.basead.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.smartdigimkt.n1.k6;

/* JADX INFO: loaded from: classes3.dex */
public class WaveAnimImageView extends ImageView {
    public final Paint a;
    public k6 b;
    public int c;
    public int d;

    public WaveAnimImageView(Context context) {
        super(context);
        Paint paint = new Paint();
        this.a = paint;
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.parseColor("#FFFFFF"));
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        k6 k6Var = this.b;
        if (k6Var != null) {
            this.a.setAlpha((int) (k6Var.c * 255.0f));
            this.a.setStrokeWidth(this.b.b);
            canvas.drawCircle(this.c, this.d, this.b.a, this.a);
        }
    }

    @Override // android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.c = getWidth() / 2;
        this.d = getHeight() / 2;
    }

    public void setWaveAnimParams(k6 k6Var) {
        this.b = k6Var;
        if (Looper.getMainLooper() == Looper.myLooper()) {
            invalidate();
        } else {
            postInvalidate();
        }
    }

    public WaveAnimImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Paint paint = new Paint();
        this.a = paint;
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.parseColor("#FFFFFF"));
    }

    public WaveAnimImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Paint paint = new Paint();
        this.a = paint;
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.parseColor("#FFFFFF"));
    }
}
