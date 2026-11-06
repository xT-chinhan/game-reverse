package com.byazt.dz;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;
import com.byazt.cp.n;
import com.byazt.okk.s;
import com.bykv.vk.component.ttvideo.player.C;

/* JADX INFO: loaded from: classes.dex */
@n(n = {0, 1, 2412, 2413})
public class DoubleColorBallAnimationView extends View {
    public float a;
    public float cd;
    public float cp;
    public long cy;
    public boolean d;
    public int fs;
    public int hd;
    public boolean k;
    public final float l;
    public final float n;
    public boolean oa;
    public float py;
    public final float q;
    public final float qg;
    public Paint rv;
    public final float s;
    public int sz;
    public final PorterDuffXfermode tj;
    public float um;
    public final long w;
    public int x;

    private float n(float f) {
        return ((double) f) < 0.5d ? 2.0f * f * f : ((f * 2.0f) * (2.0f - f)) - 1.0f;
    }

    public DoubleColorBallAnimationView(Context context) {
        this(context, null);
    }

    public DoubleColorBallAnimationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DoubleColorBallAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.n = 0.25f;
        this.qg = 0.375f;
        this.s = 0.16f;
        this.q = 0.32f;
        this.l = 400.0f;
        this.w = 17L;
        this.x = -119723;
        this.fs = -14289682;
        this.tj = new PorterDuffXfermode(PorterDuff.Mode.XOR);
        this.d = false;
        this.oa = false;
        this.sz = 0;
        this.k = false;
        this.cy = -1L;
        this.hd = -1;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            qg();
        } else {
            s();
        }
    }

    public void setProgressBarInfo(int i) {
        if (i > 0) {
            this.hd = i;
            this.cd = i / 2.0f;
            float f = (i >> 1) * 0.32f;
            this.um = f;
            float f2 = (i * 0.16f) + f;
            this.a = f2;
            this.py = i - (f2 * 2.0f);
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        s();
    }

    public boolean n() {
        return this.k;
    }

    public void qg() {
        l();
        this.k = true;
        this.d = true;
        postInvalidate();
    }

    public void s() {
        this.k = false;
        this.oa = false;
        this.cp = 0.0f;
    }

    public void setProgress(float f) {
        if (!this.oa) {
            l();
        }
        this.cp = f;
        this.k = false;
        this.d = false;
        postInvalidate();
    }

    private Paint q() {
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
        if (this.hd <= iMin || iMin <= 0) {
            return;
        }
        setProgressBarInfo(iMin);
    }

    private void l() {
        this.cy = -1L;
        if (this.hd <= 0) {
            setProgressBarInfo(s.s(getContext(), 60.0f));
        }
        int iMin = Math.min(getMeasuredHeight(), getMeasuredWidth());
        if (this.hd > iMin && iMin > 0) {
            setProgressBarInfo(iMin);
        }
        if (this.rv == null) {
            this.rv = q();
        }
        this.oa = true;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if ((n() || !this.d) && this.oa) {
            boolean z = false;
            if (this.d) {
                long jNanoTime = System.nanoTime() / C.MICROS_PER_SECOND;
                if (this.cy < 0) {
                    this.cy = jNanoTime;
                }
                float f = (jNanoTime - this.cy) / 400.0f;
                this.cp = f;
                int i = (int) f;
                z = ((this.sz + i) & 1) == 1;
                this.cp = f - i;
            }
            try {
                float fN = n(this.cp);
                int i2 = this.hd;
                int iSaveLayer = canvas.saveLayer(0.0f, 0.0f, i2, i2, this.rv, 31);
                float f2 = (this.py * fN) + this.a;
                float f3 = ((double) fN) < 0.5d ? fN * 2.0f : 2.0f - (fN * 2.0f);
                float f4 = this.um;
                float f5 = (0.25f * f3 * f4) + f4;
                this.rv.setColor(z ? this.fs : this.x);
                canvas.drawCircle(f2, this.cd, f5, this.rv);
                float f6 = this.hd - f2;
                float f7 = this.um;
                float f8 = f7 - ((f3 * 0.375f) * f7);
                this.rv.setColor(z ? this.x : this.fs);
                this.rv.setXfermode(this.tj);
                canvas.drawCircle(f6, this.cd, f8, this.rv);
                this.rv.setXfermode(null);
                canvas.restoreToCount(iSaveLayer);
            } catch (Throwable unused) {
            }
            postInvalidateDelayed(17L);
        }
    }

    public void setCycleBias(int i) {
        this.sz = i;
    }
}
