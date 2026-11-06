package com.bytedance.sdk.openadsdk.core.live.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.jw.ul;

/* JADX INFO: loaded from: classes2.dex */
public class DoubleColorBallAnimationView extends View {
    private int ab;
    private final float ah;
    private long ao;
    private final long c;
    private final PorterDuffXfermode ch;
    private final float d;
    private int h;
    private float hi;
    private final float ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final float f2846ms;
    private float nw;
    private Paint ny;
    private float qv;
    private boolean sl;
    private float t;
    private int u;
    private boolean ub;
    private int x;
    private final float xr;
    private float y;
    private boolean zb;

    private float ms(float f) {
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
        this.f2846ms = 0.25f;
        this.xr = 0.375f;
        this.ah = 0.16f;
        this.d = 0.32f;
        this.ka = 400.0f;
        this.c = 17L;
        this.ab = -119723;
        this.x = -14289682;
        this.ch = new PorterDuffXfermode(PorterDuff.Mode.XOR);
        this.sl = false;
        this.zb = false;
        this.u = 0;
        this.ub = false;
        this.ao = -1L;
        this.h = -1;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            xr();
        } else {
            ah();
        }
    }

    public void setProgressBarInfo(int i) {
        if (i > 0) {
            this.h = i;
            this.qv = i / 2.0f;
            float f = (i >> 1) * 0.32f;
            this.y = f;
            float f2 = (i * 0.16f) + f;
            this.t = f2;
            this.nw = i - (f2 * 2.0f);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ah();
    }

    public boolean ms() {
        return this.ub;
    }

    public void xr() {
        ka();
        this.ub = true;
        this.sl = true;
        postInvalidate();
    }

    public void ah() {
        this.ub = false;
        this.zb = false;
        this.hi = 0.0f;
    }

    public void setProgress(float f) {
        if (!this.zb) {
            ka();
        }
        this.hi = f;
        this.ub = false;
        this.sl = false;
        postInvalidate();
    }

    private Paint d() {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setStyle(Paint.Style.FILL);
        return paint;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int iMin = Math.min(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
        if (this.h <= iMin || iMin <= 0) {
            return;
        }
        setProgressBarInfo(iMin);
    }

    private void ka() {
        this.ao = -1L;
        if (this.h <= 0) {
            setProgressBarInfo(ul.ah(getContext(), 60.0f));
        }
        int iMin = Math.min(getMeasuredHeight(), getMeasuredWidth());
        if (this.h > iMin && iMin > 0) {
            setProgressBarInfo(iMin);
        }
        if (this.ny == null) {
            this.ny = d();
        }
        this.zb = true;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if ((ms() || !this.sl) && this.zb) {
            boolean z = false;
            if (this.sl) {
                long jNanoTime = System.nanoTime() / 1000000;
                if (this.ao < 0) {
                    this.ao = jNanoTime;
                }
                float f = (jNanoTime - this.ao) / 400.0f;
                this.hi = f;
                int i = (int) f;
                z = ((this.u + i) & 1) == 1;
                this.hi = f - i;
            }
            try {
                float fMs = ms(this.hi);
                int i2 = this.h;
                int iSaveLayer = canvas.saveLayer(0.0f, 0.0f, i2, i2, this.ny, 31);
                float f2 = (this.nw * fMs) + this.t;
                float f3 = ((double) fMs) < 0.5d ? fMs * 2.0f : 2.0f - (fMs * 2.0f);
                float f4 = this.y;
                float f5 = (0.25f * f3 * f4) + f4;
                this.ny.setColor(z ? this.x : this.ab);
                canvas.drawCircle(f2, this.qv, f5, this.ny);
                float f6 = this.h - f2;
                float f7 = this.y;
                float f8 = f7 - ((f3 * 0.375f) * f7);
                this.ny.setColor(z ? this.ab : this.x);
                this.ny.setXfermode(this.ch);
                canvas.drawCircle(f6, this.qv, f8, this.ny);
                this.ny.setXfermode(null);
                canvas.restoreToCount(iSaveLayer);
            } catch (Throwable unused) {
            }
            postInvalidateDelayed(17L);
        }
    }

    public void setCycleBias(int i) {
        this.u = i;
    }
}
