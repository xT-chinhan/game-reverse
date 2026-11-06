package com.byazt.rc;

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
import android.view.animation.LinearInterpolator;
import androidx.core.view.ViewCompat;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SKIP_BUFFER_LIMIT, 26})
public class qg extends Drawable {
    public final Matrix a;
    public Bitmap ae;
    public float an;
    public PorterDuffXfermode bb;
    public final RectF cd;
    public final float cp;
    public final RectF cy;
    public final float d;
    public boolean f = true;
    public final int fs;
    public boolean h;
    public final Path hd;
    public ValueAnimator hu;
    public LinearGradient j;
    public final float[] k;
    public final int[] l;
    public LinearGradient lh;
    public LinearGradient ln;
    public float m;
    public final Drawable n;
    public final int oa;
    public LinearGradient ou;
    public final Paint py;
    public final boolean q;
    public final float qg;
    public final int rv;
    public final float[] s;
    public final int[] sz;
    public Paint t;
    public final boolean tj;
    public final Path um;
    public Paint ur;
    public LinearGradient v;
    public final float[] w;
    public LinearGradient wm;
    public final boolean x;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public qg(Drawable drawable, int[] iArr, float[] fArr, float f, float[] fArr2, boolean z, int i, int i2, boolean z2, float f2, float f3, int i3, int[] iArr2, float[] fArr3) {
        this.n = drawable;
        this.qg = f;
        this.s = fArr2;
        this.q = (iArr == null || fArr == null) ? false : true;
        this.l = iArr;
        this.w = fArr;
        this.x = z;
        this.fs = i <= 0 ? 2200 : i;
        this.rv = i2;
        this.tj = z2;
        this.cp = f2;
        this.d = Math.max(0.0f, Math.min(1.0f, f3));
        this.oa = Math.max(2, Math.min(i3, 50));
        this.sz = iArr2;
        this.k = fArr3;
        this.cy = new RectF();
        this.hd = new Path();
        this.cd = new RectF();
        this.um = new Path();
        this.a = new Matrix();
        Paint paint = new Paint(1);
        this.py = paint;
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(f);
        if (z2) {
            Paint paint2 = new Paint(1);
            this.t = paint2;
            paint2.setStyle(Paint.Style.FILL);
            Paint paint3 = new Paint(1);
            this.ur = paint3;
            paint3.setStyle(Paint.Style.FILL);
            this.bb = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.n.setBounds(rect);
        float f = this.qg / 2.0f;
        this.cy.set(rect.left + f, rect.top + f, rect.right - f, rect.bottom - f);
        this.hd.reset();
        float[] fArr = this.s;
        if (fArr != null) {
            this.hd.addRoundRect(this.cy, fArr, Path.Direction.CW);
        } else {
            this.hd.addRect(this.cy, Path.Direction.CW);
        }
        this.cd.set(rect.left, rect.top, rect.right, rect.bottom);
        this.um.reset();
        float[] fArr2 = this.s;
        if (fArr2 != null) {
            this.um.addRoundRect(this.cd, fArr2, Path.Direction.CW);
        } else {
            this.um.addRect(this.cd, Path.Direction.CW);
        }
        this.m = this.cy.width();
        if (this.q) {
            this.ou = new LinearGradient(0.0f, 0.0f, this.m, 0.0f, this.l, this.w, Shader.TileMode.REPEAT);
            this.a.reset();
            this.py.setShader(this.ou);
        }
        if (this.tj) {
            this.wm = new LinearGradient(0.0f, 0.0f, this.m, 0.0f, this.sz, this.k, Shader.TileMode.REPEAT);
            q();
            this.f = true;
        }
        if (this.h) {
            l();
        }
    }

    private void q() {
        float f = this.cd.left;
        float f2 = this.cd.top;
        float f3 = this.cd.right;
        float f4 = this.cd.bottom;
        this.an = Math.min(this.cp, Math.min(this.cd.width(), this.cd.height()) / 2.0f);
        int i = this.oa;
        int[] iArr = new int[i];
        float[] fArr = new float[i];
        int i2 = 0;
        while (true) {
            int i3 = this.oa;
            if (i2 < i3) {
                float f5 = i2 / (i3 - 1);
                fArr[i2] = f5;
                if (i2 == i3 - 1) {
                    iArr[i2] = 16777215;
                } else {
                    double d = f5;
                    iArr[i2] = (((int) (Math.exp(((-4.0d) * d) * d) * 255.0d)) << 24) | ViewCompat.MEASURED_SIZE_MASK;
                }
                i2++;
            } else {
                this.ln = new LinearGradient(0.0f, f2, 0.0f, f2 + this.an, iArr, fArr, Shader.TileMode.CLAMP);
                this.lh = new LinearGradient(0.0f, f4, 0.0f, f4 - this.an, iArr, fArr, Shader.TileMode.CLAMP);
                this.v = new LinearGradient(f, 0.0f, f + this.an, 0.0f, iArr, fArr, Shader.TileMode.CLAMP);
                this.j = new LinearGradient(f3, 0.0f, f3 - this.an, 0.0f, iArr, fArr, Shader.TileMode.CLAMP);
                this.t.setShader(this.wm);
                return;
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.n.draw(canvas);
        if (this.tj && this.wm != null) {
            n(canvas);
        }
        if (!this.q || this.ou == null) {
            return;
        }
        canvas.drawPath(this.hd, this.py);
    }

    private void n(Canvas canvas) {
        Bitmap bitmap;
        float f = this.cd.left;
        float f2 = this.cd.top;
        float f3 = this.cd.right;
        float f4 = this.cd.bottom;
        float f5 = this.an;
        int i = (int) (f3 - f);
        int i2 = (int) (f4 - f2);
        if (i <= 0 || i2 <= 0) {
            return;
        }
        if (!this.x) {
            if (this.f || (bitmap = this.ae) == null || bitmap.getWidth() < i || this.ae.getHeight() < i2) {
                Bitmap bitmap2 = this.ae;
                if (bitmap2 != null) {
                    bitmap2.recycle();
                }
                this.ae = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(this.ae);
                canvas2.translate(-f, -f2);
                canvas2.save();
                canvas2.clipPath(this.um);
                canvas2.saveLayer(f, f2, f3, f4, null);
                n(canvas2, f, f2, f3, f4, f5);
                this.t.setAlpha((int) (this.d * 255.0f));
                this.t.setXfermode(this.bb);
                canvas2.drawRect(f, f2, f3, f4, this.t);
                this.t.setXfermode(null);
                canvas2.restore();
                canvas2.restore();
                this.f = false;
            }
            canvas.drawBitmap(this.ae, f, f2, (Paint) null);
            return;
        }
        canvas.save();
        canvas.clipPath(this.um);
        canvas.saveLayer(f, f2, f3, f4, null);
        n(canvas, f, f2, f3, f4, f5);
        this.t.setAlpha((int) (this.d * 255.0f));
        this.t.setXfermode(this.bb);
        canvas.drawRect(f, f2, f3, f4, this.t);
        this.t.setXfermode(null);
        canvas.restore();
        canvas.restore();
    }

    private void n(Canvas canvas, float f, float f2, float f3, float f4, float f5) {
        this.ur.setShader(this.ln);
        canvas.drawRect(f, f2, f3, f2 + f5, this.ur);
        this.ur.setShader(this.lh);
        canvas.drawRect(f, f4 - f5, f3, f4, this.ur);
        this.ur.setShader(this.v);
        canvas.drawRect(f, f2, f + f5, f4, this.ur);
        this.ur.setShader(this.j);
        canvas.drawRect(f3 - f5, f2, f3, f4, this.ur);
    }

    public void n() {
        if (this.x) {
            this.h = true;
            if (this.m > 0.0f) {
                if (this.ou == null && this.wm == null) {
                    return;
                }
                l();
            }
        }
    }

    private void l() {
        qg();
        this.h = false;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, this.m);
        this.hu = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(this.fs);
        this.hu.setInterpolator(new LinearInterpolator());
        int i = this.rv;
        if (i == -1) {
            this.hu.setRepeatCount(-1);
        } else {
            this.hu.setRepeatCount(Math.max(0, i - 1));
        }
        this.hu.setRepeatMode(1);
        this.hu.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.byazt.rc.qg.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                qg.this.a.setTranslate(((Float) valueAnimator.getAnimatedValue()).floatValue(), 0.0f);
                if (qg.this.ou != null) {
                    qg.this.ou.setLocalMatrix(qg.this.a);
                }
                if (qg.this.wm != null) {
                    qg.this.wm.setLocalMatrix(qg.this.a);
                }
                qg.this.invalidateSelf();
            }
        });
        this.hu.start();
    }

    public void qg() {
        this.h = false;
        ValueAnimator valueAnimator = this.hu;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.hu = null;
        }
    }

    public boolean s() {
        return this.x;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.n.setAlpha(i);
        this.py.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.n.setColorFilter(colorFilter);
    }
}
