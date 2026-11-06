package com.smartdigimkt.sdk.basead.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import com.smartdigimkt.n1.f6;
import com.smartdigimkt.n1.g6;
import com.smartdigimkt.n1.h6;
import com.smartdigimkt.r4.k;

/* JADX INFO: loaded from: classes3.dex */
public class SpreadAnimLayout extends FrameLayout {
    public final Paint a;
    public ValueAnimator b;
    public h6 c;
    public RectF d;
    public int e;
    public int f;
    public final int g;
    public final Paint h;
    public boolean i;
    public boolean j;

    public SpreadAnimLayout(Context context) {
        this(context, null, 0);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (!this.i || !this.j) {
            super.draw(canvas);
            return;
        }
        int iSaveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
        this.a.setAlpha(this.c.b);
        RectF rectF = this.c.a;
        float f = this.e;
        canvas.drawRoundRect(rectF, f, f, this.a);
        RectF rectF2 = this.d;
        float f2 = this.e;
        canvas.drawRoundRect(rectF2, f2, f2, this.h);
        canvas.restoreToCount(iSaveLayer);
        super.draw(canvas);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = this.f;
        setPadding(i3, i3, i3, i3);
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.i) {
            if (i == 0) {
                post(new f6(this));
                return;
            }
            ValueAnimator valueAnimator = this.b;
            if (valueAnimator != null) {
                valueAnimator.end();
            }
        }
    }

    public void setMaxSpreadDistance(int i) {
        this.f = i;
    }

    public void setRoundRadius(int i) {
        this.e = i;
    }

    public void startSpreadAnimation() {
        View childAt = getChildAt(0);
        if (childAt == null) {
            return;
        }
        this.i = true;
        if (!this.j) {
            this.d = new RectF(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom());
            RectF rectF = new RectF(this.d);
            h6 h6Var = new h6();
            this.c = h6Var;
            h6Var.b = 255;
            h6Var.a = rectF;
            this.f = Math.min(this.f, Math.min((getWidth() - childAt.getWidth()) / 2, (getHeight() - childAt.getHeight()) / 2));
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.b = valueAnimatorOfFloat;
            valueAnimatorOfFloat.setDuration(this.g);
            this.b.setRepeatMode(1);
            this.b.setRepeatCount(-1);
            this.b.setInterpolator(new AccelerateDecelerateInterpolator());
            this.b.addUpdateListener(new g6(this));
            this.j = true;
        }
        this.b.start();
    }

    public SpreadAnimLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SpreadAnimLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.i = true;
        setWillNotDraw(false);
        int color = getResources().getColor(k.a(context, "color_spread", "color"));
        this.f = getResources().getDimensionPixelSize(k.a(getContext(), "myoffer_spread_max_distance_normal", "dimen"));
        this.e = k.a(context, 4.0f);
        this.g = 1000;
        Paint paint = new Paint();
        this.a = paint;
        paint.setAntiAlias(true);
        paint.setAlpha(255);
        paint.setColor(color);
        Paint paint2 = new Paint(1);
        this.h = paint2;
        paint2.setColor(-1);
        paint2.setStyle(Paint.Style.FILL);
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }
}
