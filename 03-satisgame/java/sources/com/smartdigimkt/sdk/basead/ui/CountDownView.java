package com.smartdigimkt.sdk.basead.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;

/* JADX INFO: loaded from: classes3.dex */
public class CountDownView extends CloseImageView {
    public final Paint d;
    public final Paint e;
    public final Paint f;
    public float g;
    public final float h;
    public int i;
    public int j;
    public final int k;
    public int l;
    public int m;
    public int n;
    public final RectF o;
    public float p;
    public String q;
    public long r;
    public final Paint.FontMetrics s;
    public Drawable t;

    public CountDownView(Context context) {
        this(context, null);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas canvas) {
        String str;
        super.onDraw(canvas);
        if (this.t != null && (str = this.q) != null && str.length() == 1 && this.q.charAt(0) == '0') {
            this.t.setBounds(0, 0, getWidth(), getHeight());
            this.t.draw(canvas);
            return;
        }
        canvas.drawCircle(this.o.centerX(), this.o.centerY(), this.n, this.e);
        this.d.setColor(this.j);
        canvas.drawArc(this.o, 0.0f, 360.0f, false, this.d);
        this.d.setColor(this.k);
        canvas.drawArc(this.o, -90.0f, this.p, false, this.d);
        if (TextUtils.isEmpty(this.q)) {
            return;
        }
        float fCenterY = this.o.centerY();
        Paint.FontMetrics fontMetrics = this.s;
        float f = fontMetrics.bottom;
        canvas.drawText(this.q, this.o.centerX(), (((f - fontMetrics.top) / 2.0f) - f) + fCenterY, this.f);
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.l = i;
        this.m = i2;
        float f = this.g * 0.5f;
        float f2 = 0.0f + f;
        this.o.set(f2, f2, i - f, i2 - f);
        this.n = ((int) this.o.width()) >> 1;
    }

    public void refresh(long j) {
        try {
            long j2 = this.r;
            if (j2 > 0) {
                this.p = (int) ((360 * j) / j2);
                this.q = String.valueOf((int) Math.ceil((j2 - j) / 1000.0d));
                if (Looper.getMainLooper() == Looper.myLooper()) {
                    invalidate();
                } else {
                    postInvalidate();
                }
            } else if (j2 == 0) {
                this.p = 360.0f;
                this.q = "0";
                if (Looper.getMainLooper() == Looper.myLooper()) {
                    invalidate();
                } else {
                    postInvalidate();
                }
            }
        } catch (Throwable unused) {
        }
    }

    public void refreshToEnd() {
        if (this.r > 0) {
            this.p = 360.0f;
            this.q = "0";
            if (Looper.getMainLooper() == Looper.myLooper()) {
                invalidate();
            } else {
                postInvalidate();
            }
        }
    }

    public void setBgColor(int i) {
        this.i = i;
        this.e.setColor(i);
    }

    public void setCountDownEndDrawable(Drawable drawable) {
        this.t = drawable;
        if (Looper.getMainLooper() == Looper.myLooper()) {
            invalidate();
        } else {
            postInvalidate();
        }
    }

    public void setDuration(long j) {
        this.r = j;
        this.q = (j / 1000) + "";
    }

    public void setThickInPx(int i) {
        float f = i;
        this.g = f;
        this.d.setStrokeWidth(f);
        float f2 = this.g * 0.5f;
        float f3 = 0.0f + f2;
        this.o.set(f3, f3, this.l - f2, this.m - f2);
        this.n = ((int) this.o.width()) >> 1;
    }

    public void setUnderRingColor(int i) {
        this.j = i;
    }

    public CountDownView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g = TypedValue.applyDimension(1, 2.5f, context.getResources().getDisplayMetrics());
        float fApplyDimension = TypedValue.applyDimension(1, 10.0f, context.getResources().getDisplayMetrics());
        this.h = fApplyDimension;
        this.i = Color.parseColor("#66000000");
        this.j = Color.parseColor("#CC000000");
        this.k = -1;
        Paint paint = new Paint();
        this.d = paint;
        paint.setAntiAlias(true);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(this.g);
        Paint paint2 = new Paint(paint);
        this.e = paint2;
        paint2.setColor(this.i);
        paint2.setStyle(Paint.Style.FILL);
        Paint paint3 = new Paint();
        this.f = paint3;
        paint3.setAntiAlias(true);
        paint3.setTextSize(fApplyDimension);
        paint3.setColor(-1);
        paint3.setTextAlign(Paint.Align.CENTER);
        this.s = paint3.getFontMetrics();
        this.o = new RectF();
        new Rect();
        this.r = -1L;
    }
}
