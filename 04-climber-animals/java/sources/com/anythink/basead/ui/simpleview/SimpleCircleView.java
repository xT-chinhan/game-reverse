package com.anythink.basead.ui.simpleview;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class SimpleCircleView extends View {
    ValueAnimator a;
    private Paint b;
    private final long c;
    private final float d;
    private final float e;

    public SimpleCircleView(Context context) {
        this(context, null);
    }

    public SimpleCircleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SimpleCircleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = 500L;
        this.d = 0.1f;
        this.e = 3.0f;
        Paint paint = new Paint();
        this.b = paint;
        paint.setColor(1711276032);
        this.b.setAntiAlias(true);
        post(new AnonymousClass1());
    }

    private void a() {
        Paint paint = new Paint();
        this.b = paint;
        paint.setColor(1711276032);
        this.b.setAntiAlias(true);
        post(new AnonymousClass1());
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.simpleview.SimpleCircleView$1, reason: invalid class name */
    final class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            SimpleCircleView.this.setScaleX(0.1f);
            SimpleCircleView.this.setScaleY(0.1f);
            SimpleCircleView.this.a = ValueAnimator.ofFloat(0.1f, Math.max((SimpleCircleView.this.getWidth() <= 0 || SimpleCircleView.this.getHeight() <= 0) ? 3.0f : (float) (Math.hypot(SimpleCircleView.this.getWidth() / 2, SimpleCircleView.this.getHeight() / 2) / ((double) (Math.min(SimpleCircleView.this.getWidth(), SimpleCircleView.this.getHeight()) / 2))), 3.0f));
            SimpleCircleView.this.a.setDuration(500L);
            SimpleCircleView.this.a.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.anythink.basead.ui.simpleview.SimpleCircleView.1.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    try {
                        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        SimpleCircleView.this.setScaleX(fFloatValue);
                        SimpleCircleView.this.setScaleY(fFloatValue);
                    } catch (Throwable unused) {
                        SimpleCircleView.this.setScaleX(3.0f);
                        SimpleCircleView.this.setScaleY(3.0f);
                    }
                }
            });
            SimpleCircleView.this.a.start();
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.a;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float width = getWidth() / 2;
        float height = getHeight() / 2;
        canvas.drawCircle(width, height, Math.min(width, height), this.b);
    }
}
