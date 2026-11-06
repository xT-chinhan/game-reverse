package com.byazt.tc;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;
import com.byazt.vzx.pr;
import com.byazt.wt.er;
import com.bykv.vk.component.ttvideo.player.C;

/* JADX INFO: loaded from: classes2.dex */
@pr(pr = {0, 1, 2148, 2149})
public class DoubleColorBallAnimationView extends View {
    public float a;
    public Paint aj;
    public final float c;
    public float cz;
    public int fw;
    public int g;
    public final float hn;
    public boolean ho;
    public final float hw;
    public boolean k;
    public float lb;
    public boolean m;
    public long nt;
    public final float pr;
    public float qa;
    public final long uc;
    public final PorterDuffXfermode vk;
    public float w;
    public final float x;
    public int yb;
    public int zo;

    public DoubleColorBallAnimationView(Context context) {
        this(context, null);
    }

    public DoubleColorBallAnimationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DoubleColorBallAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.pr = 0.25f;
        this.hw = 0.375f;
        this.hn = 0.16f;
        this.x = 0.32f;
        this.c = 400.0f;
        this.uc = 17L;
        this.fw = -119723;
        this.zo = -14289682;
        this.vk = new PorterDuffXfermode(PorterDuff.Mode.XOR);
        this.k = false;
        this.m = false;
        this.g = 0;
        this.ho = false;
        this.nt = -1L;
        this.yb = -1;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            hw();
        } else {
            hn();
        }
    }

    public void setProgressBarInfo(int i) {
        if (i > 0) {
            this.yb = i;
            this.lb = i / 2.0f;
            float f = (i >> 1) * 0.32f;
            this.qa = f;
            float f2 = (i * 0.16f) + f;
            this.a = f2;
            this.cz = i - (f2 * 2.0f);
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        hn();
    }

    public boolean pr() {
        return this.ho;
    }

    public void hw() {
        c();
        this.ho = true;
        this.k = true;
        postInvalidate();
    }

    public void hn() {
        this.ho = false;
        this.m = false;
        this.w = 0.0f;
    }

    public void setProgress(float f) {
        if (!this.m) {
            c();
        }
        this.w = f;
        this.ho = false;
        this.k = false;
        postInvalidate();
    }

    private Paint x() {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setStyle(Paint.Style.FILL);
        return paint;
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int iMin = Math.min(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
        if (this.yb > iMin && iMin > 0) {
            setProgressBarInfo(iMin);
        }
    }

    private void c() {
        this.nt = -1L;
        if (this.yb <= 0) {
            setProgressBarInfo(er.hn(getContext(), 60.0f));
        }
        int iMin = Math.min(getMeasuredHeight(), getMeasuredWidth());
        if (this.yb > iMin && iMin > 0) {
            setProgressBarInfo(iMin);
        }
        if (this.aj == null) {
            this.aj = x();
        }
        this.m = true;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        float f;
        super.onDraw(canvas);
        if ((!pr() && this.k) || !this.m) {
            return;
        }
        boolean z = false;
        if (this.k) {
            long jNanoTime = System.nanoTime() / C.MICROS_PER_SECOND;
            if (this.nt < 0) {
                this.nt = jNanoTime;
            }
            float f2 = (jNanoTime - this.nt) / 400.0f;
            this.w = f2;
            int i = (int) f2;
            z = ((this.g + i) & 1) == 1;
            this.w = f2 - i;
        }
        try {
            float fPr = pr(this.w);
            int i2 = this.yb;
            int iSaveLayer = canvas.saveLayer(0.0f, 0.0f, i2, i2, this.aj, 31);
            float f3 = (this.cz * fPr) + this.a;
            if (fPr < 0.5d) {
                f = fPr * 2.0f;
            } else {
                f = 2.0f - (fPr * 2.0f);
            }
            float f4 = this.qa;
            float f5 = (0.25f * f * f4) + f4;
            this.aj.setColor(z ? this.zo : this.fw);
            canvas.drawCircle(f3, this.lb, f5, this.aj);
            float f6 = this.yb - f3;
            float f7 = this.qa;
            float f8 = f7 - ((f * 0.375f) * f7);
            this.aj.setColor(z ? this.fw : this.zo);
            this.aj.setXfermode(this.vk);
            canvas.drawCircle(f6, this.lb, f8, this.aj);
            this.aj.setXfermode(null);
            canvas.restoreToCount(iSaveLayer);
        } catch (Throwable th) {
        }
        postInvalidateDelayed(17L);
    }

    public void setCycleBias(int i) {
        this.g = i;
    }

    private float pr(float f) {
        if (f < 0.5d) {
            return 2.0f * f * f;
        }
        return ((f * 2.0f) * (2.0f - f)) - 1.0f;
    }
}
