package com.bytedance.sdk.openadsdk.core.component.splash.countdown;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.core.re;
import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class TTCountdownViewForCircle extends View implements d {
    private float ab;
    private int ah;
    private Paint ao;
    private RectF b;
    private float c;
    private float ch;
    private AtomicBoolean cv;
    private int d;
    private Paint h;
    private float hi;
    private AnimatorSet i;
    private float ka;
    private boolean le;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private int f2378ms;
    private float nw;
    private boolean ny;
    private ValueAnimator op;
    private Paint qv;
    private ms re;
    private float sl;
    private float t;
    private boolean u;
    private boolean ub;
    private ValueAnimator w;
    private int x;
    private int xr;
    private Paint y;
    private ValueAnimator yu;
    private String zb;

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.countdown.d
    public View getView() {
        return this;
    }

    public float ms(float f, float f2) {
        return f * f2;
    }

    public float ms(float f, int i) {
        return i * f;
    }

    public TTCountdownViewForCircle(Context context) {
        this(context, null);
    }

    public TTCountdownViewForCircle(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TTCountdownViewForCircle(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2378ms = Color.parseColor("#fce8b6");
        this.xr = Color.parseColor("#f0f0f0");
        this.ah = Color.parseColor("#ffffff");
        this.d = Color.parseColor("#7c7c7c");
        this.ka = 2.0f;
        this.c = 12.0f;
        this.ab = 18.0f;
        this.x = MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_SWITCH_CACHE_TIME;
        this.ny = false;
        this.ch = 5.0f;
        this.hi = 5.0f;
        this.sl = 0.8f;
        this.zb = "跳过";
        this.u = false;
        this.ub = false;
        this.t = 1.0f;
        this.nw = 1.0f;
        this.le = false;
        this.cv = new AtomicBoolean(true);
        this.ka = ms(2.0f);
        this.ab = ms(18.0f);
        this.c = xr(12.0f);
        this.x %= MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL;
        d();
        ka();
    }

    private void d() {
        Paint paint = new Paint(1);
        this.ao = paint;
        paint.setColor(this.f2378ms);
        this.ao.setStrokeWidth(this.ka);
        this.ao.setAntiAlias(true);
        this.ao.setStyle(Paint.Style.STROKE);
        Paint paint2 = new Paint(1);
        this.h = paint2;
        paint2.setColor(this.ah);
        this.h.setAntiAlias(true);
        this.h.setStrokeWidth(this.ka);
        this.h.setStyle(Paint.Style.FILL);
        Paint paint3 = new Paint(1);
        this.qv = paint3;
        paint3.setColor(this.xr);
        this.qv.setAntiAlias(true);
        this.qv.setStrokeWidth(this.ka / 2.0f);
        this.qv.setStyle(Paint.Style.STROKE);
        Paint paint4 = new Paint(1);
        this.y = paint4;
        paint4.setColor(this.d);
        this.qv.setAntiAlias(true);
        this.y.setTextSize(this.c);
        this.y.setTextAlign(Paint.Align.CENTER);
    }

    private void ka() {
        float f = this.ab;
        this.b = new RectF(-f, -f, f, f);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (mode != 1073741824) {
            size = c();
        }
        if (mode2 != 1073741824) {
            size2 = c();
        }
        setMeasuredDimension(size, size2);
    }

    private int c() {
        return (int) ((((this.ka / 2.0f) + this.ab) * 2.0f) + ms(4.0f));
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
        Paint.FontMetrics fontMetrics = this.y.getFontMetrics();
        String strZ = re.xr().z();
        this.zb = strZ;
        if (TextUtils.isEmpty(strZ)) {
            this.zb = "跳过";
        }
        canvas.drawText(this.zb, 0.0f, 0.0f - ((fontMetrics.ascent + fontMetrics.descent) / 2.0f), this.y);
        canvas.restore();
    }

    private void xr(Canvas canvas) {
        float f;
        canvas.save();
        float fMs = ms(this.t, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL);
        if (this.ny) {
            f = this.x - fMs;
        } else {
            f = this.x;
        }
        canvas.drawCircle(0.0f, 0.0f, this.ab, this.h);
        canvas.drawCircle(0.0f, 0.0f, this.ab, this.qv);
        canvas.drawArc(this.b, f, fMs, false, this.ao);
        canvas.restore();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.countdown.d
    public void ms() {
        if (this.ub) {
            return;
        }
        AnimatorSet animatorSet = this.i;
        if (animatorSet != null && animatorSet.isRunning()) {
            this.i.cancel();
            this.i = null;
        }
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.i = animatorSet2;
        animatorSet2.playTogether(getNumAnim(), getArcAnim());
        this.i.setInterpolator(new LinearInterpolator());
        this.i.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.countdown.TTCountdownViewForCircle.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                TTCountdownViewForCircle.this.le = true;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (TTCountdownViewForCircle.this.le) {
                    TTCountdownViewForCircle.this.le = false;
                } else if (TTCountdownViewForCircle.this.re != null) {
                    TTCountdownViewForCircle.this.re.ms();
                }
            }
        });
        try {
            Field declaredField = ValueAnimator.class.getDeclaredField("sDurationScale");
            declaredField.setAccessible(true);
            if (declaredField.getFloat(null) < 1.0f) {
                declaredField.setFloat(null, 1.0f);
            }
        } catch (Throwable unused) {
        }
        this.i.start();
        if (this.cv.get()) {
            return;
        }
        xr();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.countdown.d
    public void ms(boolean z) {
        this.ub = z;
        if (z) {
            ab();
        }
    }

    private ValueAnimator getNumAnim() {
        ValueAnimator valueAnimator = this.w;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.w = null;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.nw, 0.0f);
        this.w = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        this.w.setDuration((long) (ms(this.nw, this.hi) * 1000.0f));
        this.w.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.countdown.TTCountdownViewForCircle.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                TTCountdownViewForCircle.this.nw = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                TTCountdownViewForCircle.this.invalidate();
            }
        });
        return this.w;
    }

    private ValueAnimator getArcAnim() {
        ValueAnimator valueAnimator = this.yu;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.yu = null;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.t, 0.0f);
        this.yu = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        this.yu.setDuration((long) (ms(this.t, this.ch) * 1000.0f));
        this.yu.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.countdown.TTCountdownViewForCircle.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                TTCountdownViewForCircle.this.t = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                TTCountdownViewForCircle.this.invalidate();
            }
        });
        return this.yu;
    }

    private void ab() {
        try {
            AnimatorSet animatorSet = this.i;
            if (animatorSet != null) {
                animatorSet.cancel();
                this.i = null;
            }
            ValueAnimator valueAnimator = this.op;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.op = null;
            }
            ValueAnimator valueAnimator2 = this.w;
            if (valueAnimator2 != null) {
                valueAnimator2.cancel();
                this.w = null;
            }
            ValueAnimator valueAnimator3 = this.yu;
            if (valueAnimator3 != null) {
                valueAnimator3.cancel();
                this.yu = null;
            }
            this.t = 1.0f;
            this.nw = 1.0f;
            invalidate();
        } catch (Exception unused) {
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        ab();
        super.onDetachedFromWindow();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.countdown.d
    public void setCountDownTime(int i) {
        float f = i;
        this.hi = f;
        this.ch = f;
        ab();
    }

    private float ms(float f) {
        return TypedValue.applyDimension(1, f, getResources().getDisplayMetrics());
    }

    private float xr(float f) {
        return TypedValue.applyDimension(2, f, getResources().getDisplayMetrics());
    }

    public ms getCountdownListener() {
        return this.re;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.countdown.d
    public void setCountdownListener(ms msVar) {
        this.re = msVar;
        this.cv.get();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.cv.set(z);
        if (this.ub) {
            return;
        }
        if (!this.cv.get()) {
            xr();
        } else {
            ah();
        }
    }

    public void xr() {
        try {
            if (this.i != null) {
                this.i.pause();
            }
        } catch (Throwable unused) {
        }
    }

    public void ah() {
        try {
            if (this.ub || this.i == null) {
                return;
            }
            this.i.resume();
        } catch (Throwable unused) {
        }
    }
}
