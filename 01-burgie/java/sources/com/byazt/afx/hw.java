package com.byazt.afx;

import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.view.animation.LinearInterpolator;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1253, 13})
public class hw extends Drawable {
    public final Matrix a;
    public final int aj;
    public boolean b;
    public final int[] c;
    public final Paint cz;
    public float e;
    public LinearGradient fo;
    public final boolean fw;
    public final int[] g;
    public PorterDuffXfermode gz;
    public final float[] hn;
    public final float[] ho;
    public final float hw;
    public Paint iu;
    public final float k;
    public final RectF lb;
    public boolean ls = true;
    public final int m;
    public LinearGradient n;
    public LinearGradient nl;
    public final RectF nt;
    public LinearGradient ny;
    public final Drawable pr;
    public final Path qa;
    public float rc;
    public Bitmap s;
    public final float[] uc;
    public Paint ve;
    public final boolean vk;
    public final float w;
    public LinearGradient ww;
    public final boolean x;
    public LinearGradient y;
    public final Path yb;
    public ValueAnimator z;
    public final int zo;

    public hw(Drawable drawable, int[] iArr, float[] fArr, float f, float[] fArr2, boolean z, int i, int i2, boolean z2, float f2, float f3, int i3, int[] iArr2, float[] fArr3) {
        this.pr = drawable;
        this.hw = f;
        this.hn = fArr2;
        this.x = (iArr == null || fArr == null) ? false : true;
        this.c = iArr;
        this.uc = fArr;
        this.fw = z;
        this.zo = i <= 0 ? 2200 : i;
        this.aj = i2;
        this.vk = z2;
        this.w = f2;
        this.k = Math.max(0.0f, Math.min(1.0f, f3));
        this.m = Math.max(2, Math.min(i3, 50));
        this.g = iArr2;
        this.ho = fArr3;
        this.nt = new RectF();
        this.yb = new Path();
        this.lb = new RectF();
        this.qa = new Path();
        this.a = new Matrix();
        Paint paint = new Paint(1);
        this.cz = paint;
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(f);
        if (z2) {
            Paint paint2 = new Paint(1);
            this.iu = paint2;
            paint2.setStyle(Paint.Style.FILL);
            Paint paint3 = new Paint(1);
            this.ve = paint3;
            paint3.setStyle(Paint.Style.FILL);
            this.gz = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.pr.setBounds(rect);
        float f = this.hw / 2.0f;
        this.nt.set(rect.left + f, rect.top + f, rect.right - f, rect.bottom - f);
        this.yb.reset();
        float[] fArr = this.hn;
        if (fArr != null) {
            this.yb.addRoundRect(this.nt, fArr, Path.Direction.CW);
        } else {
            this.yb.addRect(this.nt, Path.Direction.CW);
        }
        this.lb.set(rect.left, rect.top, rect.right, rect.bottom);
        this.qa.reset();
        float[] fArr2 = this.hn;
        if (fArr2 != null) {
            this.qa.addRoundRect(this.lb, fArr2, Path.Direction.CW);
        } else {
            this.qa.addRect(this.lb, Path.Direction.CW);
        }
        this.rc = this.nt.width();
        if (this.x) {
            this.ny = new LinearGradient(0.0f, 0.0f, this.rc, 0.0f, this.c, this.uc, Shader.TileMode.REPEAT);
            this.a.reset();
            this.cz.setShader(this.ny);
        }
        if (this.vk) {
            this.fo = new LinearGradient(0.0f, 0.0f, this.rc, 0.0f, this.g, this.ho, Shader.TileMode.REPEAT);
            x();
            this.ls = true;
        }
        if (this.b) {
            c();
        }
    }

    private void x() {
        float f = this.lb.left;
        float f2 = this.lb.top;
        float f3 = this.lb.right;
        float f4 = this.lb.bottom;
        this.e = Math.min(this.w, Math.min(this.lb.width(), this.lb.height()) / 2.0f);
        int i = this.m;
        int[] iArr = new int[i];
        float[] fArr = new float[i];
        int i2 = 0;
        while (true) {
            int i3 = this.m;
            if (i2 >= i3) {
                this.nl = new LinearGradient(0.0f, f2, 0.0f, f2 + this.e, iArr, fArr, Shader.TileMode.CLAMP);
                this.y = new LinearGradient(0.0f, f4, 0.0f, f4 - this.e, iArr, fArr, Shader.TileMode.CLAMP);
                this.ww = new LinearGradient(f, 0.0f, f + this.e, 0.0f, iArr, fArr, Shader.TileMode.CLAMP);
                this.n = new LinearGradient(f3, 0.0f, f3 - this.e, 0.0f, iArr, fArr, Shader.TileMode.CLAMP);
                this.iu.setShader(this.fo);
                return;
            }
            float f5 = i2 / (i3 - 1);
            fArr[i2] = f5;
            if (i2 == i3 - 1) {
                iArr[i2] = 16777215;
            } else {
                double d = f5;
                iArr[i2] = (((int) (Math.exp(((-4.0d) * d) * d) * 255.0d)) << 24) | ViewCompat.MEASURED_SIZE_MASK;
            }
            i2++;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.pr.draw(canvas);
        if (this.vk && this.fo != null) {
            pr(canvas);
        }
        if (this.x && this.ny != null) {
            canvas.drawPath(this.yb, this.cz);
        }
    }

    private void pr(Canvas canvas) {
        Bitmap bitmap;
        float f = this.lb.left;
        float f2 = this.lb.top;
        float f3 = this.lb.right;
        float f4 = this.lb.bottom;
        float f5 = this.e;
        int i = (int) (f3 - f);
        int i2 = (int) (f4 - f2);
        if (i <= 0 || i2 <= 0) {
            return;
        }
        if (!this.fw) {
            if (this.ls || (bitmap = this.s) == null || bitmap.getWidth() < i || this.s.getHeight() < i2) {
                Bitmap bitmap2 = this.s;
                if (bitmap2 != null) {
                    bitmap2.recycle();
                }
                this.s = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(this.s);
                canvas2.translate(-f, -f2);
                canvas2.save();
                canvas2.clipPath(this.qa);
                canvas2.saveLayer(f, f2, f3, f4, null);
                pr(canvas2, f, f2, f3, f4, f5);
                this.iu.setAlpha((int) (this.k * 255.0f));
                this.iu.setXfermode(this.gz);
                canvas2.drawRect(f, f2, f3, f4, this.iu);
                this.iu.setXfermode(null);
                canvas2.restore();
                canvas2.restore();
                this.ls = false;
            }
            canvas.drawBitmap(this.s, f, f2, (Paint) null);
            return;
        }
        canvas.save();
        canvas.clipPath(this.qa);
        canvas.saveLayer(f, f2, f3, f4, null);
        pr(canvas, f, f2, f3, f4, f5);
        this.iu.setAlpha((int) (this.k * 255.0f));
        this.iu.setXfermode(this.gz);
        canvas.drawRect(f, f2, f3, f4, this.iu);
        this.iu.setXfermode(null);
        canvas.restore();
        canvas.restore();
    }

    private void pr(Canvas canvas, float f, float f2, float f3, float f4, float f5) {
        this.ve.setShader(this.nl);
        canvas.drawRect(f, f2, f3, f2 + f5, this.ve);
        this.ve.setShader(this.y);
        canvas.drawRect(f, f4 - f5, f3, f4, this.ve);
        this.ve.setShader(this.ww);
        canvas.drawRect(f, f2, f + f5, f4, this.ve);
        this.ve.setShader(this.n);
        canvas.drawRect(f3 - f5, f2, f3, f4, this.ve);
    }

    public void pr() {
        if (!this.fw) {
            return;
        }
        this.b = true;
        if (this.rc > 0.0f) {
            if (this.ny != null || this.fo != null) {
                c();
            }
        }
    }

    private void c() {
        hw();
        this.b = false;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, this.rc);
        this.z = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(this.zo);
        this.z.setInterpolator(new LinearInterpolator());
        int i = this.aj;
        if (i != -1) {
            this.z.setRepeatCount(Math.max(0, i - 1));
        } else {
            this.z.setRepeatCount(-1);
        }
        this.z.setRepeatMode(1);
        this.z.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.byazt.afx.hw.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                hw.this.a.setTranslate(((Float) valueAnimator.getAnimatedValue()).floatValue(), 0.0f);
                if (hw.this.ny != null) {
                    hw.this.ny.setLocalMatrix(hw.this.a);
                }
                if (hw.this.fo != null) {
                    hw.this.fo.setLocalMatrix(hw.this.a);
                }
                hw.this.invalidateSelf();
            }
        });
        this.z.start();
    }

    public void hw() {
        this.b = false;
        ValueAnimator valueAnimator = this.z;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.z = null;
        }
    }

    public boolean hn() {
        return this.fw;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.pr.setAlpha(i);
        this.cz.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.pr.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }
}
