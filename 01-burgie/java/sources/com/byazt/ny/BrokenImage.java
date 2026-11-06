package com.byazt.ny;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import com.byazt.llk.c;
import java.lang.reflect.Array;
import java.security.SecureRandom;
import java.util.Random;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 36, 1949})
public class BrokenImage extends View {
    public boolean aj;
    public int c;
    public Point[][] fw;
    public final Random g;
    public final Path hn;
    public float ho;
    public final Paint hw;
    public Rect k;
    public int m;
    public float nt;
    public c pr;
    public Bitmap uc;
    public Rect vk;
    public Rect w;
    public int x;
    public boolean zo;

    public BrokenImage(Context context) {
        super(context);
        this.hw = new Paint();
        this.hn = new Path();
        this.zo = false;
        this.aj = true;
        this.m = 0;
        this.g = new SecureRandom();
    }

    public void setBitmap(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        this.uc = bitmap;
        this.vk = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        this.w = new Rect(0, 0, this.uc.getWidth(), this.uc.getHeight());
        invalidate();
    }

    public void pr(int i, int i2) {
        this.x = i;
        this.c = i2;
        this.k = new Rect(0, 0, getWidth(), getHeight());
        int width = getWidth() / i;
        int height = getHeight() / i2;
        this.fw = (Point[][]) Array.newInstance((Class<?>) Point.class, i2 + 1, i + 1);
        for (int i3 = 0; i3 < i2; i3++) {
            for (int i4 = 0; i4 < i; i4++) {
                int i5 = i4 * width;
                int i6 = i3 * height;
                Rect rect = new Rect(i5, i6, i5 + width, i6 + height);
                if (i3 == 0 || i4 == 0) {
                    this.fw[i3][i4] = new Point(rect.left, rect.top);
                }
                if (i3 == 0 || i4 == i - 1) {
                    this.fw[i3][i4 + 1] = new Point(rect.right, rect.top);
                }
                int i7 = i2 - 1;
                if (i3 == i7 || i4 == 0) {
                    this.fw[i3 + 1][i4] = new Point(rect.left, rect.bottom);
                }
                if (i3 == i7 || i4 == i - 1) {
                    this.fw[i3 + 1][i4 + 1] = new Point(rect.right, rect.bottom);
                } else {
                    this.fw[i3 + 1][i4 + 1] = new Point((int) (rect.right + ((this.g.nextFloat() - 0.5f) * width)), (int) (rect.bottom + ((this.g.nextFloat() - 0.5f) * height)));
                }
            }
        }
        this.zo = true;
        invalidate();
    }

    public void setBrokenProgress(int i) {
        this.m = i;
        try {
            invalidate();
        } catch (Exception e) {
        }
    }

    public void pr(int i) {
        ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(this, "brokenProgress", 0, getHeight());
        objectAnimatorOfInt.setInterpolator(new AccelerateInterpolator());
        objectAnimatorOfInt.setDuration(i <= 0 ? 600L : i);
        objectAnimatorOfInt.start();
        this.aj = false;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.k = new Rect(0, 0, i, i2);
        this.ho = i / 2.0f;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Rect rect;
        try {
            super.onDraw(canvas);
        } catch (Exception e) {
        }
        Bitmap bitmap = this.uc;
        if (bitmap == null || this.k == null || bitmap.isRecycled()) {
            return;
        }
        if (this.zo) {
            for (int i = 0; i < this.c; i++) {
                int i2 = 0;
                while (i2 < this.x) {
                    canvas.save();
                    int i3 = this.m;
                    int i4 = i2 + 1;
                    int i5 = i + 1;
                    canvas.translate((((Math.max(this.fw[i][i4].x, this.fw[i5][i4].x) + Math.min(this.fw[i][i2].x, this.fw[i5][i2].x)) / 2) - this.ho) * 0.01f * this.m * 0.05f, i5 * (i3 < 5 ? -i3 : i3 - 5));
                    canvas.save();
                    hw(i, i2);
                    canvas.clipPath(this.hn);
                    canvas.drawBitmap(this.uc, this.w, this.k, this.hw);
                    canvas.restore();
                    canvas.restore();
                    i2 = i4;
                }
            }
        }
        if (this.aj && this.vk != null && (rect = this.w) != null) {
            canvas.drawBitmap(this.uc, rect, this.k, this.hw);
        }
    }

    private void hw(int i, int i2) {
        this.hn.reset();
        this.hn.moveTo(this.fw[i][i2].x, this.fw[i][i2].y);
        int i3 = i2 + 1;
        this.hn.lineTo(this.fw[i][i3].x, this.fw[i][i3].y);
        int i4 = i + 1;
        this.hn.lineTo(this.fw[i4][i3].x, this.fw[i4][i3].y);
        this.hn.lineTo(this.fw[i4][i2].x, this.fw[i4][i2].y);
        this.hn.close();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.ho = motionEvent.getX();
            this.nt = motionEvent.getY();
        }
        return super.onTouchEvent(motionEvent);
    }

    public void pr(c cVar) {
        this.pr = cVar;
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        c cVar = this.pr;
        if (cVar != null) {
            cVar.c();
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c cVar = this.pr;
        if (cVar != null) {
            cVar.uc();
        }
    }
}
