package com.byazt.uo;

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
@com.byazt.cp.n(n = {0, 1, 1609, 1610})
public class CycleSkipView extends View {
    public boolean a;
    public ValueAnimator cd;
    public boolean cp;
    public AnimatorSet cy;
    public Paint d;
    public float fs;
    public ValueAnimator hd;
    public float k;
    public float l;
    public int n;
    public Paint oa;
    public float ou;
    public final RectF py;
    public float q;
    public int qg;
    public float rv;
    public int s;
    public Paint sz;
    public int tj;
    public ValueAnimator um;
    public int w;
    public boolean x;

    public CycleSkipView(Context context) {
        super(context);
        this.n = Color.parseColor("#f9e8b9");
        this.qg = Color.parseColor("#ffffff");
        this.s = Color.parseColor("#7b7b7b");
        this.w = MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_SWITCH_CACHE_TIME;
        this.x = false;
        this.fs = 5.0f;
        this.rv = 0.0f;
        this.tj = 0;
        this.cp = true;
        this.k = 0.0f;
        this.a = false;
        this.py = new RectF();
        this.ou = 1.0f;
        this.q = n(2.0f);
        this.l = n(10.0f);
        this.w %= MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL;
        qg();
        setBackgroundColor(-16711681);
    }

    private void qg() {
        Paint paint = new Paint(1);
        this.d = paint;
        paint.setColor(this.n);
        this.d.setStrokeWidth(this.q);
        this.d.setAntiAlias(true);
        this.d.setStrokeCap(Paint.Cap.ROUND);
        this.d.setStyle(Paint.Style.STROKE);
        Paint paint2 = new Paint(1);
        this.oa = paint2;
        paint2.setColor(this.qg);
        this.oa.setAntiAlias(true);
        this.oa.setStrokeWidth(this.q);
        this.oa.setStyle(Paint.Style.FILL);
        Paint paint3 = new Paint(1);
        this.sz = paint3;
        paint3.setColor(this.s);
        this.sz.setTextAlign(Paint.Align.CENTER);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (mode != 1073741824) {
            size = s();
        }
        if (mode2 != 1073741824) {
            size2 = s();
        }
        qg(size, size2);
        setMeasuredDimension(size, size2);
        this.py.left = -this.l;
        this.py.right = this.l;
        this.py.top = -this.l;
        this.py.bottom = this.l;
        this.sz.setTextSize(getMinLine() / 3.0f);
    }

    private int s() {
        return (int) ((((this.q / 2.0f) + this.l) * 2.0f) + n(4.0f));
    }

    private void qg(int i, int i2) {
        this.l = (Math.min(i, i2) / 2.0f) - this.q;
    }

    private int getMinLine() {
        return Math.min(getMeasuredHeight(), getMeasuredWidth());
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(getMeasuredWidth() / 2.0f, getMeasuredHeight() / 2.0f);
        qg(canvas);
        n(canvas);
    }

    private void n(Canvas canvas) {
        canvas.save();
        Paint.FontMetrics fontMetrics = this.sz.getFontMetrics();
        canvas.drawText("跳过", 0.0f, (getMinLine() / 3.0f) - ((fontMetrics.bottom - fontMetrics.top) / 2.0f), this.sz);
        canvas.restore();
    }

    private void qg(Canvas canvas) {
        float f;
        float fMax;
        float f2;
        canvas.save();
        float f3 = this.k * 360.0f;
        if (this.x) {
            if (this.cp) {
                f = this.w;
                f3 = -f3;
            } else {
                f = this.w - f3;
            }
        } else {
            if (this.cp) {
                float f4 = this.w + MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL;
                fMax = Math.max(0.0f, 360.0f - f3);
                f2 = f4;
            } else {
                f = this.w;
            }
            canvas.drawCircle(0.0f, 0.0f, this.l, this.oa);
            canvas.drawArc(this.py, f2, fMax, false, this.d);
            canvas.restore();
        }
        fMax = f3;
        f2 = f;
        canvas.drawCircle(0.0f, 0.0f, this.l, this.oa);
        canvas.drawArc(this.py, f2, fMax, false, this.d);
        canvas.restore();
    }

    private ValueAnimator getArcAnim() {
        ValueAnimator valueAnimator = this.cd;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.cd = null;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.k, this.ou);
        this.cd = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        this.cd.setDuration(1000L);
        this.cd.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.byazt.uo.CycleSkipView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                CycleSkipView.this.k = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                CycleSkipView.this.postInvalidate();
            }
        });
        return this.cd;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        try {
            AnimatorSet animatorSet = this.cy;
            if (animatorSet != null) {
                animatorSet.cancel();
                this.cy = null;
            }
            ValueAnimator valueAnimator = this.um;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.um = null;
            }
            ValueAnimator valueAnimator2 = this.hd;
            if (valueAnimator2 != null) {
                valueAnimator2.cancel();
                this.hd = null;
            }
            ValueAnimator valueAnimator3 = this.cd;
            if (valueAnimator3 != null) {
                valueAnimator3.cancel();
                this.cd = null;
            }
            this.k = 1.0f;
            invalidate();
        } catch (Exception unused) {
        }
        super.onDetachedFromWindow();
    }

    private float n(float f) {
        return TypedValue.applyDimension(1, f, getResources().getDisplayMetrics());
    }

    public void n() {
        AnimatorSet animatorSet = this.cy;
        if (animatorSet != null && animatorSet.isRunning()) {
            this.cy.cancel();
            this.cy = null;
        }
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.cy = animatorSet2;
        animatorSet2.playTogether(getArcAnim());
        this.cy.setInterpolator(new LinearInterpolator());
        this.cy.addListener(new AnimatorListenerAdapter() { // from class: com.byazt.uo.CycleSkipView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

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
        });
        this.cy.start();
    }

    public void n(int i, int i2) {
        if (i == 0) {
            return;
        }
        float f = i;
        this.fs = f;
        float f2 = i2;
        this.rv = f2;
        this.tj = i - i2;
        this.ou = f2 / f;
        n();
    }
}
