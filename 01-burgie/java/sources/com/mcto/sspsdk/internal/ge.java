package com.mcto.sspsdk.internal;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.support.v4.content.ContextCompat;
import android.support.v4.internal.view.SupportMenu;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import com.mcto.sspsdk.R;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public final class ge extends View implements n7 {
    public static final double k = Math.toRadians(30.0d);
    public final AtomicBoolean a;
    public float b;
    public final ValueAnimator c;
    public boolean d;
    public int e;
    public final Bitmap f;
    public final Matrix g;
    public final DashPathEffect h;
    public final PorterDuffXfermode i;
    public final Paint j;

    public ge(Context context) {
        super(context, null, 0);
        this.a = new AtomicBoolean(false);
        this.b = 0.0f;
        this.d = false;
        this.e = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, R.styleable.qy_slide_view);
        try {
            this.b = typedArrayObtainStyledAttributes.getFloat(R.styleable.qy_slide_view_qy_rotation, 0.0f);
            typedArrayObtainStyledAttributes.recycle();
            Paint paint = new Paint();
            this.j = paint;
            paint.setColor(SupportMenu.CATEGORY_MASK);
            paint.setStyle(Paint.Style.FILL);
            paint.setStrokeWidth(20.0f);
            paint.setAntiAlias(true);
            this.g = new Matrix();
            this.i = new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP);
            this.h = new DashPathEffect(new float[]{32.0f, 15.0f}, 0.0f);
            this.f = BitmapFactory.decodeResource(getResources(), R.drawable.qy_lg_hand_click);
            ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, 100);
            this.c = valueAnimatorOfInt;
            valueAnimatorOfInt.setDuration(1500L);
            valueAnimatorOfInt.setRepeatCount(-1);
            valueAnimatorOfInt.setInterpolator(new DecelerateInterpolator());
            valueAnimatorOfInt.addUpdateListener(new fe(this));
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    @Override // com.mcto.sspsdk.internal.n7
    public final void a() {
        this.d = true;
    }

    @Override // com.mcto.sspsdk.internal.n7
    public final void b() {
        this.d = false;
        this.c.cancel();
        this.a.set(false);
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = this.f.getWidth();
        int height = this.f.getHeight();
        int width2 = getWidth() - 10;
        float f = width2;
        float f2 = width;
        float f3 = height;
        float fMin = Math.min(f / f2, getHeight() / f3);
        this.g.reset();
        this.g.postScale(fMin, fMin);
        int iSaveLayer = canvas.saveLayer(null, null, 31);
        if (this.b == 0.0f) {
            int height2 = getHeight() / 5;
            this.j.setColor(-1);
            double d = k;
            float f4 = height2;
            canvas.drawLine(f - ((float) (Math.cos(d) * 50.0d)), f4 - ((float) (Math.sin(d) * 50.0d)), f, f4 + 4.5f, this.j);
            canvas.drawLine(f - ((float) (Math.cos(d) * 50.0d)), f4 + ((float) (Math.sin(d) * 50.0d)), f, f4 - 4.5f, this.j);
            this.j.setPathEffect(this.h);
            canvas.drawLine(0.0f, f4, f, f4, this.j);
            this.j.setPathEffect(null);
            this.j.setColor(ContextCompat.getColor(getContext(), R.color.qy_btn_color_red));
            this.j.setXfermode(this.i);
            canvas.drawRect(0.0f, 0.0f, this.e, height2 + 50, this.j);
            this.j.setXfermode(null);
            this.g.postTranslate(this.e, (getHeight() / 2.0f) - ((f3 * fMin) / 2.0f));
            canvas.drawBitmap(this.f, this.g, null);
        } else {
            this.j.setColor(-1);
            this.j.setPathEffect(this.h);
            float f5 = width2 / 10;
            canvas.drawLine(f5, getHeight(), f5, 0.0f, this.j);
            this.j.setPathEffect(null);
            this.j.setColor(ContextCompat.getColor(getContext(), R.color.qy_btn_color_red));
            canvas.drawLine(f5, getHeight(), f5, (getHeight() - this.e) + (width2 / 5), this.j);
            this.g.postTranslate((f / 2.0f) - ((f2 * fMin) / 2.0f), getHeight() - this.e);
            canvas.drawBitmap(this.f, this.g, null);
        }
        canvas.restoreToCount(iSaveLayer);
    }

    @Override // android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.d && this.a.compareAndSet(false, true)) {
            if (this.b == 0.0f) {
                this.c.setIntValues(0, getWidth() - 10);
            } else {
                this.c.setIntValues(0, (getWidth() / 5) + getHeight());
            }
            this.c.start();
        }
    }

    @Override // android.view.View
    public final void setRotation(float f) {
        this.b = f;
    }
}
