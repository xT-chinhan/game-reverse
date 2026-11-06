package com.smartdigimkt.p1;

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
import com.smartdigimkt.r4.k;

/* JADX INFO: loaded from: classes3.dex */
public class f extends b {
    public final Paint e;
    public final Paint f;
    public final Paint g;
    public Canvas h;
    public RectF i;
    public Bitmap j;
    public final int k;
    public final int l;
    public int m;
    public int n;
    public int o;
    public final int p;

    public f(View view) {
        super(view);
        if (view == null) {
            return;
        }
        int iA = k.a(view.getContext(), 5.0f);
        this.p = iA;
        this.k = k.a(view.getContext(), 24.0f);
        this.n = k.a(view.getContext(), 30.0f);
        Paint paint = new Paint(1);
        this.e = paint;
        paint.setColor(Color.parseColor("#cfffffff"));
        Paint paint2 = new Paint(1);
        this.f = paint2;
        paint2.setColor(ViewCompat.MEASURED_STATE_MASK);
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        Paint paint3 = new Paint(1);
        this.g = paint3;
        paint3.setColor(ViewCompat.MEASURED_STATE_MASK);
        paint.setStrokeWidth(iA);
        paint.setMaskFilter(new BlurMaskFilter(20, BlurMaskFilter.Blur.NORMAL));
        int i = -iA;
        this.l = i;
        this.m = i - this.n;
    }

    @Override // com.smartdigimkt.p1.b, com.smartdigimkt.o1.b
    public void a(int i, int i2) {
        if (this.c != i || this.d != i2) {
            c();
        }
        this.c = i;
        this.d = i2;
    }

    @Override // com.smartdigimkt.p1.b
    public final ValueAnimator b() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setDuration(1200L);
        valueAnimatorOfFloat.setRepeatMode(1);
        valueAnimatorOfFloat.setRepeatCount(-1);
        valueAnimatorOfFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        valueAnimatorOfFloat.addUpdateListener(new e(this));
        return valueAnimatorOfFloat;
    }

    @Override // com.smartdigimkt.p1.b
    public final void c() {
        super.c();
        if (this.a == null || this.c == 0 || this.d == 0) {
            return;
        }
        try {
            int i = (int) (((double) this.c) * 0.1d);
            this.n = i;
            this.m = this.l - i;
            RectF rectF = new RectF();
            this.i = rectF;
            rectF.left = 0.0f;
            rectF.top = 0.0f;
            int i2 = this.c;
            rectF.right = i2;
            int i3 = this.d;
            rectF.bottom = i3;
            this.j = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
            this.h = new Canvas(this.j);
        } catch (Throwable unused) {
        }
    }

    @Override // com.smartdigimkt.p1.b, com.smartdigimkt.o1.b
    public void a(Canvas canvas) {
        ValueAnimator valueAnimator;
        View view = this.a;
        if (view == null || view.getVisibility() != 0 || (valueAnimator = this.b) == null || !valueAnimator.isStarted() || this.j == null || this.h == null) {
            return;
        }
        int iSaveLayer = canvas.saveLayer(0.0f, 0.0f, this.c, this.d, null, 31);
        this.j.eraseColor(0);
        int i = this.l;
        int i2 = this.o;
        canvas.drawLine(i + i2, 0.0f, this.m + i2, this.d, this.e);
        Canvas canvas2 = this.h;
        RectF rectF = this.i;
        float f = this.k;
        canvas2.drawRoundRect(rectF, f, f, this.g);
        canvas.drawBitmap(this.j, 0.0f, 0.0f, this.f);
        canvas.restoreToCount(iSaveLayer);
    }
}
