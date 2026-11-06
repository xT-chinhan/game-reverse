package com.anythink.basead.ui.a.a;

import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.core.view.ViewCompat;
import com.anythink.core.common.v.q;

/* JADX INFO: loaded from: classes.dex */
public class d extends a {
    private int e;
    private Paint f;
    private Paint g;
    private Paint h;
    private Canvas i;
    private RectF j;
    private Bitmap k;
    private int l;
    private int m;
    private int n;
    private int o;
    private int p;
    private int q;

    public d(View view) {
        super(view);
        if (view == null) {
            return;
        }
        this.q = q.a(view.getContext(), 5.0f);
        this.l = q.a(view.getContext(), 24.0f);
        this.o = q.a(view.getContext(), 30.0f);
        this.e = 20;
        Paint paint = new Paint(1);
        this.f = paint;
        paint.setColor(Color.parseColor("#cfffffff"));
        Paint paint2 = new Paint(1);
        this.g = paint2;
        paint2.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.g.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        Paint paint3 = new Paint(1);
        this.h = paint3;
        paint3.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.f.setStrokeWidth(this.q);
        this.f.setMaskFilter(new BlurMaskFilter(this.e, BlurMaskFilter.Blur.NORMAL));
        int i = -this.q;
        this.m = i;
        this.n = i - this.o;
    }

    @Override // com.anythink.basead.ui.a.a.a, com.anythink.basead.ui.a.b
    public void a(int i, int i2) {
        if (this.c != i || this.d != i2) {
            f();
        }
        super.a(i, i2);
    }

    @Override // com.anythink.basead.ui.a.a.a
    protected final void f() {
        super.f();
        if (this.a == null || this.c == 0 || this.d == 0) {
            return;
        }
        try {
            Object[] objArr = new Object[3];
            Integer.valueOf(this.c);
            Integer.valueOf(this.d);
            Integer.valueOf(this.o);
            int i = (int) (((double) this.c) * 0.1d);
            this.o = i;
            this.n = this.m - i;
            RectF rectF = new RectF();
            this.j = rectF;
            rectF.left = 0.0f;
            this.j.top = 0.0f;
            this.j.right = this.c;
            this.j.bottom = this.d;
            this.k = Bitmap.createBitmap(this.c, this.d, Bitmap.Config.ARGB_8888);
            this.i = new Canvas(this.k);
        } catch (Throwable unused) {
        }
    }

    @Override // com.anythink.basead.ui.a.a.a
    protected final ValueAnimator e() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setDuration(1200L);
        valueAnimatorOfFloat.setRepeatMode(1);
        valueAnimatorOfFloat.setRepeatCount(-1);
        valueAnimatorOfFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.anythink.basead.ui.a.a.d.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (d.this.a == null || d.this.a.getVisibility() != 0) {
                    return;
                }
                if (d.this.k == null && d.this.i == null) {
                    return;
                }
                d.this.p = (int) ((d.this.c + d.this.o + (d.this.q * 2)) * ((Float) valueAnimator.getAnimatedValue()).floatValue());
                d.this.a.postInvalidate();
            }
        });
        return valueAnimatorOfFloat;
    }

    @Override // com.anythink.basead.ui.a.a.a, com.anythink.basead.ui.a.b
    public void a(Canvas canvas) {
        super.a(canvas);
        if (this.a == null || this.a.getVisibility() != 0 || this.b == null || !this.b.isStarted() || this.k == null || this.i == null) {
            return;
        }
        int iSaveLayer = canvas.saveLayer(0.0f, 0.0f, this.c, this.d, null, 31);
        this.k.eraseColor(0);
        int i = this.m;
        int i2 = this.p;
        canvas.drawLine(i + i2, 0.0f, this.n + i2, this.d, this.f);
        Canvas canvas2 = this.i;
        RectF rectF = this.j;
        int i3 = this.l;
        canvas2.drawRoundRect(rectF, i3, i3, this.h);
        canvas.drawBitmap(this.k, 0.0f, 0.0f, this.g);
        canvas.restoreToCount(iSaveLayer);
    }
}
