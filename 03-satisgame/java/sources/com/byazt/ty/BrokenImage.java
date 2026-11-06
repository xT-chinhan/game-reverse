package com.byazt.ty;

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
import com.byazt.gu.l;
import com.taptap.sdk.compilance.constants.ComplianceMessage;
import java.lang.reflect.Array;
import java.security.SecureRandom;
import java.util.Random;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, ComplianceMessage.OPEN_ALERT_TIP, 1096})
public class BrokenImage extends View {
    public Rect cp;
    public float cy;
    public Rect d;
    public boolean fs;
    public float k;
    public int l;
    public l n;
    public int oa;
    public int q;
    public final Paint qg;
    public boolean rv;
    public final Path s;
    public final Random sz;
    public Rect tj;
    public Bitmap w;
    public Point[][] x;

    public BrokenImage(Context context) {
        super(context);
        this.qg = new Paint();
        this.s = new Path();
        this.fs = false;
        this.rv = true;
        this.oa = 0;
        this.sz = new SecureRandom();
    }

    public void setBitmap(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        this.w = bitmap;
        this.tj = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        this.cp = new Rect(0, 0, this.w.getWidth(), this.w.getHeight());
        invalidate();
    }

    public void n(int i, int i2) {
        this.q = i;
        this.l = i2;
        this.d = new Rect(0, 0, getWidth(), getHeight());
        int width = getWidth() / i;
        int height = getHeight() / i2;
        this.x = (Point[][]) Array.newInstance((Class<?>) Point.class, i2 + 1, i + 1);
        for (int i3 = 0; i3 < i2; i3++) {
            for (int i4 = 0; i4 < i; i4++) {
                int i5 = i4 * width;
                int i6 = i3 * height;
                Rect rect = new Rect(i5, i6, i5 + width, i6 + height);
                if (i3 == 0 || i4 == 0) {
                    this.x[i3][i4] = new Point(rect.left, rect.top);
                }
                if (i3 == 0 || i4 == i - 1) {
                    this.x[i3][i4 + 1] = new Point(rect.right, rect.top);
                }
                int i7 = i2 - 1;
                if (i3 == i7 || i4 == 0) {
                    this.x[i3 + 1][i4] = new Point(rect.left, rect.bottom);
                }
                if (i3 == i7 || i4 == i - 1) {
                    this.x[i3 + 1][i4 + 1] = new Point(rect.right, rect.bottom);
                } else {
                    this.x[i3 + 1][i4 + 1] = new Point((int) (rect.right + ((this.sz.nextFloat() - 0.5f) * width)), (int) (rect.bottom + ((this.sz.nextFloat() - 0.5f) * height)));
                }
            }
        }
        this.fs = true;
        invalidate();
    }

    public void setBrokenProgress(int i) {
        this.oa = i;
        try {
            invalidate();
        } catch (Exception unused) {
        }
    }

    public void n(int i) {
        ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(this, "brokenProgress", 0, getHeight());
        objectAnimatorOfInt.setInterpolator(new AccelerateInterpolator());
        objectAnimatorOfInt.setDuration(i <= 0 ? 600L : i);
        objectAnimatorOfInt.start();
        this.rv = false;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.d = new Rect(0, 0, i, i2);
        this.k = i / 2.0f;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Rect rect;
        try {
            super.onDraw(canvas);
        } catch (Exception unused) {
        }
        Bitmap bitmap = this.w;
        if (bitmap == null || this.d == null || bitmap.isRecycled()) {
            return;
        }
        if (this.fs) {
            for (int i = 0; i < this.l; i++) {
                int i2 = 0;
                while (i2 < this.q) {
                    canvas.save();
                    int i3 = this.oa;
                    int i4 = i2 + 1;
                    int i5 = i + 1;
                    canvas.translate((((Math.max(this.x[i][i4].x, this.x[i5][i4].x) + Math.min(this.x[i][i2].x, this.x[i5][i2].x)) / 2) - this.k) * 0.01f * this.oa * 0.05f, i5 * (i3 < 5 ? -i3 : i3 - 5));
                    canvas.save();
                    qg(i, i2);
                    canvas.clipPath(this.s);
                    canvas.drawBitmap(this.w, this.cp, this.d, this.qg);
                    canvas.restore();
                    canvas.restore();
                    i2 = i4;
                }
            }
        }
        if (!this.rv || this.tj == null || (rect = this.cp) == null) {
            return;
        }
        canvas.drawBitmap(this.w, rect, this.d, this.qg);
    }

    private void qg(int i, int i2) {
        this.s.reset();
        this.s.moveTo(this.x[i][i2].x, this.x[i][i2].y);
        int i3 = i2 + 1;
        this.s.lineTo(this.x[i][i3].x, this.x[i][i3].y);
        int i4 = i + 1;
        this.s.lineTo(this.x[i4][i3].x, this.x[i4][i3].y);
        this.s.lineTo(this.x[i4][i2].x, this.x[i4][i2].y);
        this.s.close();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.k = motionEvent.getX();
            this.cy = motionEvent.getY();
        }
        return super.onTouchEvent(motionEvent);
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
}
