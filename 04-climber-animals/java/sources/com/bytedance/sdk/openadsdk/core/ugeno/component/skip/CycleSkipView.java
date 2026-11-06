package com.bytedance.sdk.openadsdk.core.ugeno.component.skip;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
public class CycleSkipView extends View {
    protected boolean ab;
    protected int ah;
    private AnimatorSet ao;
    private float b;
    protected int c;
    protected int ch;
    protected float d;
    private ValueAnimator h;
    protected boolean hi;
    protected float ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected int f3480ms;
    private final RectF nw;
    protected float ny;
    private ValueAnimator qv;
    private Paint sl;
    private boolean t;
    private Paint u;
    private float ub;
    protected float x;
    protected int xr;
    private ValueAnimator y;
    private Paint zb;

    public CycleSkipView(Context context) {
        super(context);
        this.f3480ms = Color.parseColor("#f9e8b9");
        this.xr = Color.parseColor("#ffffff");
        this.ah = Color.parseColor("#7b7b7b");
        this.c = MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_SWITCH_CACHE_TIME;
        this.ab = false;
        this.x = 5.0f;
        this.ny = 0.0f;
        this.ch = 0;
        this.hi = true;
        this.ub = 0.0f;
        this.t = false;
        this.nw = new RectF();
        this.b = 1.0f;
        this.d = ms(2.0f);
        this.ka = ms(10.0f);
        this.c %= MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL;
        xr();
        setBackgroundColor(-16711681);
    }

    private void xr() {
        Paint paint = new Paint(1);
        this.sl = paint;
        paint.setColor(this.f3480ms);
        this.sl.setStrokeWidth(this.d);
        this.sl.setAntiAlias(true);
        this.sl.setStrokeCap(Paint.Cap.ROUND);
        this.sl.setStyle(Paint.Style.STROKE);
        Paint paint2 = new Paint(1);
        this.zb = paint2;
        paint2.setColor(this.xr);
        this.zb.setAntiAlias(true);
        this.zb.setStrokeWidth(this.d);
        this.zb.setStyle(Paint.Style.FILL);
        Paint paint3 = new Paint(1);
        this.u = paint3;
        paint3.setColor(this.ah);
        this.u.setTextAlign(Paint.Align.CENTER);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (mode != 1073741824) {
            size = ah();
        }
        if (mode2 != 1073741824) {
            size2 = ah();
        }
        xr(size, size2);
        setMeasuredDimension(size, size2);
        this.nw.left = -this.ka;
        this.nw.right = this.ka;
        this.nw.top = -this.ka;
        this.nw.bottom = this.ka;
        this.u.setTextSize(getMinLine() / 3.0f);
    }

    private int ah() {
        return (int) ((((this.d / 2.0f) + this.ka) * 2.0f) + ms(4.0f));
    }

    private void xr(int i, int i2) {
        this.ka = (Math.min(i, i2) / 2.0f) - this.d;
    }

    private int getMinLine() {
        return Math.min(getMeasuredHeight(), getMeasuredWidth());
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(getMeasuredWidth() / 2.0f, getMeasuredHeight() / 2.0f);
        xr(canvas);
        ms(canvas);
    }

    private void ms(Canvas canvas) {
        canvas.save();
        Paint.FontMetrics fontMetrics = this.u.getFontMetrics();
        canvas.drawText("跳过", 0.0f, (getMinLine() / 3.0f) - ((fontMetrics.bottom - fontMetrics.top) / 2.0f), this.u);
        canvas.restore();
    }

    private void xr(Canvas canvas) {
        float f;
        float fMax;
        float f2;
        canvas.save();
        float f3 = this.ub * 360.0f;
        if (this.ab) {
            if (this.hi) {
                f = this.c;
                f3 = -f3;
            } else {
                f = this.c - f3;
            }
        } else {
            if (this.hi) {
                float f4 = this.c + MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL;
                fMax = Math.max(0.0f, 360.0f - f3);
                f2 = f4;
            } else {
                f = this.c;
            }
            canvas.drawCircle(0.0f, 0.0f, this.ka, this.zb);
            canvas.drawArc(this.nw, f2, fMax, false, this.sl);
            canvas.restore();
        }
        fMax = f3;
        f2 = f;
        canvas.drawCircle(0.0f, 0.0f, this.ka, this.zb);
        canvas.drawArc(this.nw, f2, fMax, false, this.sl);
        canvas.restore();
    }

    private ValueAnimator getArcAnim() {
        ValueAnimator valueAnimator = this.qv;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.qv = null;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.ub, this.b);
        this.qv = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        this.qv.setDuration(1000L);
        this.qv.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.skip.CycleSkipView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                CycleSkipView.this.ub = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                CycleSkipView.this.postInvalidate();
            }
        });
        return this.qv;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        try {
            AnimatorSet animatorSet = this.ao;
            if (animatorSet != null) {
                animatorSet.cancel();
                this.ao = null;
            }
            ValueAnimator valueAnimator = this.y;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.y = null;
            }
            ValueAnimator valueAnimator2 = this.h;
            if (valueAnimator2 != null) {
                valueAnimator2.cancel();
                this.h = null;
            }
            ValueAnimator valueAnimator3 = this.qv;
            if (valueAnimator3 != null) {
                valueAnimator3.cancel();
                this.qv = null;
            }
            this.ub = 1.0f;
            invalidate();
        } catch (Exception unused) {
        }
        super.onDetachedFromWindow();
    }

    private float ms(float f) {
        return TypedValue.applyDimension(1, f, getResources().getDisplayMetrics());
    }

    public void ms() {
        AnimatorSet animatorSet = this.ao;
        if (animatorSet != null && animatorSet.isRunning()) {
            this.ao.cancel();
            this.ao = null;
        }
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.ao = animatorSet2;
        animatorSet2.playTogether(getArcAnim());
        this.ao.setInterpolator(new LinearInterpolator());
        this.ao.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.skip.CycleSkipView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                CycleSkipView.this.t = true;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (CycleSkipView.this.t) {
                    CycleSkipView.this.t = false;
                }
            }
        });
        this.ao.start();
    }

    public void ms(int i, int i2) {
        if (i == 0) {
            return;
        }
        float f = i;
        this.x = f;
        float f2 = i2;
        this.ny = f2;
        this.ch = i - i2;
        this.b = f2 / f;
        ms();
    }
}
