package com.byazt.yw;

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
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SIDX_INFOS, 1004})
public class CycleSkipView extends View {
    public boolean a;
    public float aj;
    public float c;
    public final RectF cz;
    public boolean fw;
    public Paint g;
    public int hn;
    public float ho;
    public int hw;
    public Paint k;
    public ValueAnimator lb;
    public Paint m;
    public AnimatorSet nt;
    public float ny;
    public int pr;
    public ValueAnimator qa;
    public int uc;
    public int vk;
    public boolean w;
    public float x;
    public ValueAnimator yb;
    public float zo;

    public CycleSkipView(Context context) {
        super(context);
        this.pr = Color.parseColor("#f9e8b9");
        this.hw = Color.parseColor("#ffffff");
        this.hn = Color.parseColor("#7b7b7b");
        this.uc = MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_SWITCH_CACHE_TIME;
        this.fw = false;
        this.zo = 5.0f;
        this.aj = 0.0f;
        this.vk = 0;
        this.w = true;
        this.ho = 0.0f;
        this.a = false;
        this.cz = new RectF();
        this.ny = 1.0f;
        this.x = pr(2.0f);
        this.c = pr(10.0f);
        this.uc %= MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL;
        hw();
        setBackgroundColor(-16711681);
    }

    private void hw() {
        Paint paint = new Paint(1);
        this.k = paint;
        paint.setColor(this.pr);
        this.k.setStrokeWidth(this.x);
        this.k.setAntiAlias(true);
        this.k.setStrokeCap(Paint.Cap.ROUND);
        this.k.setStyle(Paint.Style.STROKE);
        Paint paint2 = new Paint(1);
        this.m = paint2;
        paint2.setColor(this.hw);
        this.m.setAntiAlias(true);
        this.m.setStrokeWidth(this.x);
        this.m.setStyle(Paint.Style.FILL);
        Paint paint3 = new Paint(1);
        this.g = paint3;
        paint3.setColor(this.hn);
        this.g.setTextAlign(Paint.Align.CENTER);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (mode != 1073741824) {
            size = hn();
        }
        if (mode2 != 1073741824) {
            size2 = hn();
        }
        hw(size, size2);
        setMeasuredDimension(size, size2);
        this.cz.left = -this.c;
        this.cz.right = this.c;
        this.cz.top = -this.c;
        this.cz.bottom = this.c;
        this.g.setTextSize(getMinLine() / 3.0f);
    }

    private int hn() {
        return (int) ((((this.x / 2.0f) + this.c) * 2.0f) + pr(4.0f));
    }

    private void hw(int i, int i2) {
        this.c = (Math.min(i, i2) / 2.0f) - this.x;
    }

    private int getMinLine() {
        return Math.min(getMeasuredHeight(), getMeasuredWidth());
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(getMeasuredWidth() / 2.0f, getMeasuredHeight() / 2.0f);
        hw(canvas);
        pr(canvas);
    }

    private void pr(Canvas canvas) {
        canvas.save();
        Paint.FontMetrics fontMetrics = this.g.getFontMetrics();
        canvas.drawText("跳过", 0.0f, (getMinLine() / 3.0f) - ((fontMetrics.bottom - fontMetrics.top) / 2.0f), this.g);
        canvas.restore();
    }

    private void hw(Canvas canvas) {
        float fMax;
        float f;
        canvas.save();
        float f2 = this.ho * 360.0f;
        if (this.fw) {
            if (this.w) {
                fMax = -f2;
                f = this.uc;
            } else {
                fMax = f2;
                f = this.uc - f2;
            }
        } else if (this.w) {
            float f3 = this.uc + MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL;
            fMax = Math.max(0.0f, 360.0f - f2);
            f = f3;
        } else {
            fMax = f2;
            f = this.uc;
        }
        canvas.drawCircle(0.0f, 0.0f, this.c, this.m);
        canvas.drawArc(this.cz, f, fMax, false, this.k);
        canvas.restore();
    }

    private ValueAnimator getArcAnim() {
        ValueAnimator valueAnimator = this.lb;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.lb = null;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.ho, this.ny);
        this.lb = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        this.lb.setDuration(1000L);
        this.lb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.byazt.yw.CycleSkipView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                CycleSkipView.this.ho = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                CycleSkipView.this.postInvalidate();
            }
        });
        return this.lb;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        try {
            AnimatorSet animatorSet = this.nt;
            if (animatorSet != null) {
                animatorSet.cancel();
                this.nt = null;
            }
            ValueAnimator valueAnimator = this.qa;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.qa = null;
            }
            ValueAnimator valueAnimator2 = this.yb;
            if (valueAnimator2 != null) {
                valueAnimator2.cancel();
                this.yb = null;
            }
            ValueAnimator valueAnimator3 = this.lb;
            if (valueAnimator3 != null) {
                valueAnimator3.cancel();
                this.lb = null;
            }
            this.ho = 1.0f;
            invalidate();
        } catch (Exception e) {
        }
        super.onDetachedFromWindow();
    }

    private float pr(float f) {
        return TypedValue.applyDimension(1, f, getResources().getDisplayMetrics());
    }

    public void pr() {
        AnimatorSet animatorSet = this.nt;
        if (animatorSet != null && animatorSet.isRunning()) {
            this.nt.cancel();
            this.nt = null;
        }
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.nt = animatorSet2;
        animatorSet2.playTogether(getArcAnim());
        this.nt.setInterpolator(new LinearInterpolator());
        this.nt.addListener(new AnimatorListenerAdapter() { // from class: com.byazt.yw.CycleSkipView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                CycleSkipView.this.a = true;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (CycleSkipView.this.a) {
                    CycleSkipView.this.a = false;
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        this.nt.start();
    }

    public void pr(int i, int i2) {
        if (i == 0) {
            return;
        }
        float f = i;
        this.zo = f;
        float f2 = i2;
        this.aj = f2;
        this.vk = i - i2;
        this.ny = f2 / f;
        pr();
    }
}
