package com.byazt.sa;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.internal.view.SupportMenu;
import com.byazt.gu.l;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 401, 402})
public class UGProgressBarView extends View {
    public boolean a;
    public boolean cd;
    public float cp;
    public Bitmap cy;
    public boolean d;
    public int fs;
    public n h;
    public Bitmap hd;
    public final RectF hu;
    public float k;
    public float l;
    public final Rect m;
    public l n;
    public int oa;
    public boolean ou;
    public int py;
    public int q;
    public float qg;
    public int rv;
    public int s;
    public float sz;
    public final Paint t;
    public float tj;
    public float um;
    public final RectF ur;
    public float w;
    public int wm;
    public float x;

    public interface n {
    }

    private static float n(float f) {
        if (f < 0.0f) {
            return 0.0f;
        }
        if (f > 1.0f) {
            return 1.0f;
        }
        return f;
    }

    public UGProgressBarView(Context context) {
        super(context);
        this.s = -3355444;
        this.q = SupportMenu.CATEGORY_MASK;
        this.fs = -1;
        this.rv = -1;
        this.m = new Rect();
        this.hu = new RectF();
        this.t = new Paint(1);
        this.ur = new RectF();
    }

    public void setProgress(float f) {
        this.qg = n(f);
        invalidate();
    }

    public float getProgress() {
        return this.qg;
    }

    public void setTrackColor(int i) {
        this.s = i;
    }

    public void setFillColor(int i) {
        this.q = i;
    }

    public void setLineHeight(float f) {
        this.l = f;
    }

    public void setCornerRadius(float f) {
        this.w = f;
    }

    public void setThumbSize(float f) {
        this.x = f;
    }

    public void setThumbColor(int i) {
        this.fs = i;
    }

    public void setThumbBorderColor(int i) {
        this.rv = i;
    }

    public void setThumbBorderWidth(float f) {
        this.tj = f;
    }

    public void setHorizontalInset(float f) {
        this.cp = f;
    }

    public void setInteractive(boolean z) {
        this.d = z;
    }

    public void n(int i, float f, float f2) {
        this.oa = i;
        this.sz = f;
        this.k = f2;
        invalidate();
    }

    public void setMilestoneDotRadius(float f) {
        this.um = f;
        this.cd = true;
        invalidate();
    }

    public void setMilestoneDotColor(int i) {
        this.py = i;
        this.a = true;
        invalidate();
    }

    public void setMilestoneDotReachedColor(int i) {
        this.wm = i;
        this.ou = true;
        invalidate();
    }

    public void n(int i, Bitmap bitmap) {
        if (i == 0) {
            this.cy = bitmap;
        } else if (i != 1) {
            return;
        } else {
            this.hd = bitmap;
        }
        invalidate();
    }

    public void setOnProgressChangeListener(n nVar) {
        this.h = nVar;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (width <= 0 || height <= 0) {
            return;
        }
        float f = this.cp;
        float f2 = width;
        float f3 = f2 - f;
        if (f3 <= f) {
            return;
        }
        float f4 = this.l;
        if (f4 <= 0.0f) {
            f4 = height;
        }
        boolean z = this.oa > 0 && this.sz > 0.0f;
        float f5 = this.x;
        float f6 = f5 > 0.0f ? f5 / 2.0f : 0.0f;
        float f7 = height;
        float f8 = z ? (f7 - f6) - (f4 / 2.0f) : f7 / 2.0f;
        float f9 = f4 / 2.0f;
        float f10 = f8 - f9;
        float f11 = f9 + f8;
        this.t.setStyle(Paint.Style.FILL);
        this.t.setColor(this.s);
        this.ur.set(f, f10, f3, f11);
        RectF rectF = this.ur;
        float f12 = this.w;
        canvas.drawRoundRect(rectF, f12, f12, this.t);
        float f13 = f3 - f;
        float f14 = (this.qg * f13) + f;
        if (f14 > f) {
            this.t.setColor(this.q);
            this.ur.set(f, f10, f14, f11);
            RectF rectF2 = this.ur;
            float f15 = this.w;
            canvas.drawRoundRect(rectF2, f15, f15, this.t);
        }
        if (this.x > 0.0f) {
            if (this.tj > 0.0f) {
                this.t.setColor(this.rv);
                canvas.drawCircle(f14, f8, f6, this.t);
                this.t.setColor(this.fs);
                canvas.drawCircle(f14, f8, f6 - this.tj, this.t);
            } else {
                this.t.setColor(this.fs);
                canvas.drawCircle(f14, f8, f6, this.t);
            }
        }
        if (!z) {
            return;
        }
        float f16 = this.sz;
        if (this.cd) {
            f4 = this.um;
        }
        boolean z2 = f4 > 0.0f;
        int i = this.a ? this.py : this.q;
        int i2 = this.ou ? this.wm : i;
        float f17 = f16 / 2.0f;
        float f18 = (f10 - this.k) - f17;
        int i3 = 1;
        while (true) {
            int i4 = this.oa;
            if (i3 > i4) {
                return;
            }
            float f19 = i3;
            int i5 = i;
            float f20 = f + (((f19 - 0.5f) / i4) * f13);
            float f21 = f;
            boolean z3 = this.qg >= (f19 / ((float) i4)) - 1.0E-4f;
            if (z2) {
                this.t.setColor(z3 ? i2 : i5);
                canvas.drawCircle(f20, f8, f4, this.t);
            }
            Bitmap bitmap = z3 ? this.hd : this.cy;
            if (bitmap != null) {
                float width2 = ((bitmap.getHeight() > 0 ? bitmap.getWidth() / bitmap.getHeight() : 1.0f) * f16) / 2.0f;
                if (f20 < width2) {
                    f20 = width2;
                } else {
                    float f22 = f2 - width2;
                    if (f20 > f22) {
                        f20 = f22;
                    }
                }
                this.m.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
                this.hu.set(f20 - width2, f18 - f17, f20 + width2, f18 + f17);
                canvas.drawBitmap(bitmap, this.m, this.hu, this.t);
            }
            i3++;
            f = f21;
            i = i5;
            f2 = f2;
            f8 = f8;
            f13 = f13;
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.d) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action == 0 || action == 1 || action == 2) {
            float f = this.cp;
            float width = getWidth() - this.cp;
            if (width > f) {
                this.qg = n((motionEvent.getX() - f) / (width - f));
                invalidate();
            }
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        l lVar = this.n;
        if (lVar != null) {
            lVar.n(i, i2);
        }
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        l lVar = this.n;
        if (lVar != null) {
            lVar.n(i, i2, i3, i4);
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        l lVar = this.n;
        if (lVar != null) {
            lVar.qg(i, i2, i3, i4);
        }
    }

    public void n(l lVar) {
        this.n = lVar;
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        l lVar = this.n;
        if (lVar != null) {
            lVar.l();
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        l lVar = this.n;
        if (lVar != null) {
            lVar.w();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        l lVar = this.n;
        if (lVar != null) {
            lVar.n(z);
        }
    }
}
