package com.mcto.sspsdk.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import com.mcto.sspsdk.R;

/* JADX INFO: loaded from: classes2.dex */
public final class vg extends AppCompatTextView {
    public final float a;
    public final float b;
    public final int c;
    public final int d;
    public float e;
    public final RectF f;
    public final Path g;
    public final Path h;
    public final PathMeasure i;
    public float j;
    public final Paint k;
    public final Paint l;

    public vg(Context context) {
        super(context, null);
        this.a = 80.0f;
        this.b = 4.0f;
        this.c = 1293819422;
        this.d = -1275068417;
        this.e = 0.0f;
        this.f = new RectF();
        this.g = new Path();
        this.h = new Path();
        this.i = new PathMeasure();
        this.j = 0.0f;
        Paint paint = new Paint();
        this.k = paint;
        Paint paint2 = new Paint();
        this.l = paint2;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, R.styleable.qy_round_count_down_view);
        try {
            int color = typedArrayObtainStyledAttributes.getColor(R.styleable.qy_round_count_down_view_qy_background_color, 1293819422);
            this.c = color;
            int color2 = typedArrayObtainStyledAttributes.getColor(R.styleable.qy_round_count_down_view_qy_border_color, ContextCompat.getColor(context, R.color.qy_text_color_white_70alpha));
            this.d = color2;
            this.a = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.qy_round_count_down_view_qy_radius, 20);
            float dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.qy_round_count_down_view_qy_border_width, 2);
            this.b = dimensionPixelSize;
            typedArrayObtainStyledAttributes.recycle();
            paint.setStyle(Paint.Style.STROKE);
            paint.setAntiAlias(true);
            paint.setStrokeWidth(dimensionPixelSize);
            paint.setStrokeCap(Paint.Cap.ROUND);
            paint.setColor(color2);
            paint2.setStyle(Paint.Style.FILL);
            paint2.setAntiAlias(true);
            paint2.setColor(color);
            setGravity(17);
            setIncludeFontPadding(false);
            setTextColor(-1);
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas canvas) {
        RectF rectF = this.f;
        float f = this.a;
        canvas.drawRoundRect(rectF, f, f, this.l);
        this.g.reset();
        float f2 = this.j;
        this.i.getSegment((1.0f - this.e) * f2, f2, this.g, true);
        canvas.drawPath(this.g, this.k);
        super.onDraw(canvas);
    }

    @Override // android.support.v7.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        RectF rectF = this.f;
        float f = this.b;
        rectF.set(f, f, getWidth() - this.b, getHeight() - this.b);
        Path path = this.h;
        RectF rectF2 = this.f;
        float f2 = this.a;
        path.addRoundRect(rectF2, f2, f2, Path.Direction.CW);
        this.i.setPath(this.h, true);
        this.j = this.i.getLength();
    }
}
