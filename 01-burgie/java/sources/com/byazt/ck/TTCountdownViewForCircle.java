package com.byazt.ck;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.byazt.sd.a;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AVG_PLAY_BITRATE, 1473})
public class TTCountdownViewForCircle extends View implements x {
    public float a;
    public boolean aj;
    public ValueAnimator b;
    public float c;
    public float cz;
    public pr fo;
    public float fw;
    public boolean g;
    public AtomicBoolean gz;
    public int hn;
    public boolean ho;
    public int hw;
    public ValueAnimator iu;
    public float k;
    public Paint lb;
    public String m;
    public Paint nt;
    public RectF ny;
    public int pr;
    public Paint qa;
    public AnimatorSet rc;
    public float uc;
    public boolean ve;
    public float vk;
    public float w;
    public int x;
    public Paint yb;
    public ValueAnimator z;
    public int zo;

    public TTCountdownViewForCircle(Context context) {
        this(context, null);
    }

    public TTCountdownViewForCircle(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TTCountdownViewForCircle(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.pr = Color.parseColor("#fce8b6");
        this.hw = Color.parseColor("#f0f0f0");
        this.hn = Color.parseColor("#ffffff");
        this.x = Color.parseColor("#7c7c7c");
        this.c = 2.0f;
        this.uc = 12.0f;
        this.fw = 18.0f;
        this.zo = MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_SWITCH_CACHE_TIME;
        this.aj = false;
        this.vk = 5.0f;
        this.w = 5.0f;
        this.k = 0.8f;
        this.m = "跳过";
        this.g = false;
        this.ho = false;
        this.a = 1.0f;
        this.cz = 1.0f;
        this.ve = false;
        this.gz = new AtomicBoolean(true);
        this.c = pr(2.0f);
        this.fw = pr(18.0f);
        this.uc = hw(12.0f);
        this.zo %= MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL;
        x();
        c();
    }

    private void x() {
        Paint paint = new Paint(1);
        this.nt = paint;
        paint.setColor(this.pr);
        this.nt.setStrokeWidth(this.c);
        this.nt.setAntiAlias(true);
        this.nt.setStyle(Paint.Style.STROKE);
        Paint paint2 = new Paint(1);
        this.yb = paint2;
        paint2.setColor(this.hn);
        this.yb.setAntiAlias(true);
        this.yb.setStrokeWidth(this.c);
        this.yb.setStyle(Paint.Style.FILL);
        Paint paint3 = new Paint(1);
        this.lb = paint3;
        paint3.setColor(this.hw);
        this.lb.setAntiAlias(true);
        this.lb.setStrokeWidth(this.c / 2.0f);
        this.lb.setStyle(Paint.Style.STROKE);
        Paint paint4 = new Paint(1);
        this.qa = paint4;
        paint4.setColor(this.x);
        this.lb.setAntiAlias(true);
        this.qa.setTextSize(this.uc);
        this.qa.setTextAlign(Paint.Align.CENTER);
    }

    private void c() {
        float f = this.fw;
        this.ny = new RectF(-f, -f, f, f);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (mode != 1073741824) {
            size = uc();
        }
        if (mode2 != 1073741824) {
            size2 = uc();
        }
        setMeasuredDimension(size, size2);
    }

    private int uc() {
        return (int) ((((this.c / 2.0f) + this.fw) * 2.0f) + pr(4.0f));
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
        Paint.FontMetrics fontMetrics = this.qa.getFontMetrics();
        String strYj = a.hw().yj();
        this.m = strYj;
        if (TextUtils.isEmpty(strYj)) {
            this.m = "跳过";
        }
        canvas.drawText(this.m, 0.0f, 0.0f - ((fontMetrics.ascent + fontMetrics.descent) / 2.0f), this.qa);
        canvas.restore();
    }

    private void hw(Canvas canvas) {
        float f;
        canvas.save();
        float fPr = pr(this.a, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL);
        if (this.aj) {
            f = this.zo - fPr;
        } else {
            f = this.zo;
        }
        canvas.drawCircle(0.0f, 0.0f, this.fw, this.yb);
        canvas.drawCircle(0.0f, 0.0f, this.fw, this.lb);
        canvas.drawArc(this.ny, f, fPr, false, this.nt);
        canvas.restore();
    }

    @Override // com.byazt.ck.x
    public void pr() {
        if (this.ho) {
            return;
        }
        AnimatorSet animatorSet = this.rc;
        if (animatorSet != null && animatorSet.isRunning()) {
            this.rc.cancel();
            this.rc = null;
        }
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.rc = animatorSet2;
        animatorSet2.playTogether(getNumAnim(), getArcAnim());
        this.rc.setInterpolator(new LinearInterpolator());
        this.rc.addListener(new AnimatorListenerAdapter() { // from class: com.byazt.ck.TTCountdownViewForCircle.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                TTCountdownViewForCircle.this.ve = true;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (TTCountdownViewForCircle.this.ve) {
                    TTCountdownViewForCircle.this.ve = false;
                } else if (TTCountdownViewForCircle.this.fo != null) {
                    TTCountdownViewForCircle.this.fo.pr();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        try {
            Field declaredField = ValueAnimator.class.getDeclaredField("sDurationScale");
            declaredField.setAccessible(true);
            if (declaredField.getFloat(null) < 1.0f) {
                declaredField.setFloat(null, 1.0f);
            }
        } catch (Throwable th) {
        }
        this.rc.start();
        if (!this.gz.get()) {
            hw();
        }
    }

    @Override // com.byazt.ck.x
    public void pr(boolean z) {
        this.ho = z;
        if (z) {
            fw();
        }
    }

    private ValueAnimator getNumAnim() {
        ValueAnimator valueAnimator = this.z;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.z = null;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.cz, 0.0f);
        this.z = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        this.z.setDuration((long) (pr(this.cz, this.w) * 1000.0f));
        this.z.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.byazt.ck.TTCountdownViewForCircle.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                TTCountdownViewForCircle.this.cz = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                TTCountdownViewForCircle.this.invalidate();
            }
        });
        return this.z;
    }

    private ValueAnimator getArcAnim() {
        ValueAnimator valueAnimator = this.b;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.b = null;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.a, 0.0f);
        this.b = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        this.b.setDuration((long) (pr(this.a, this.vk) * 1000.0f));
        this.b.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.byazt.ck.TTCountdownViewForCircle.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                TTCountdownViewForCircle.this.a = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                TTCountdownViewForCircle.this.invalidate();
            }
        });
        return this.b;
    }

    private void fw() {
        try {
            AnimatorSet animatorSet = this.rc;
            if (animatorSet != null) {
                animatorSet.cancel();
                this.rc = null;
            }
            ValueAnimator valueAnimator = this.iu;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.iu = null;
            }
            ValueAnimator valueAnimator2 = this.z;
            if (valueAnimator2 != null) {
                valueAnimator2.cancel();
                this.z = null;
            }
            ValueAnimator valueAnimator3 = this.b;
            if (valueAnimator3 != null) {
                valueAnimator3.cancel();
                this.b = null;
            }
            this.a = 1.0f;
            this.cz = 1.0f;
            invalidate();
        } catch (Exception e) {
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        fw();
        super.onDetachedFromWindow();
    }

    public float pr(float f, float f2) {
        return f * f2;
    }

    public float pr(float f, int i) {
        return i * f;
    }

    @Override // com.byazt.ck.x
    public void setCountDownTime(int i) {
        float f = i;
        this.w = f;
        this.vk = f;
        fw();
    }

    @Override // com.byazt.ck.x
    public View getView() {
        return this;
    }

    private float pr(float f) {
        return TypedValue.applyDimension(1, f, getResources().getDisplayMetrics());
    }

    private float hw(float f) {
        return TypedValue.applyDimension(2, f, getResources().getDisplayMetrics());
    }

    public pr getCountdownListener() {
        return this.fo;
    }

    @Override // com.byazt.ck.x
    public void setCountdownListener(pr prVar) {
        this.fo = prVar;
        this.gz.get();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.gz.set(z);
        if (this.ho) {
            return;
        }
        if (!this.gz.get()) {
            hw();
        } else {
            hn();
        }
    }

    public void hw() {
        try {
            if (this.rc != null && Build.VERSION.SDK_INT >= 19) {
                this.rc.pause();
            }
        } catch (Throwable th) {
        }
    }

    public void hn() {
        try {
            if (!this.ho && this.rc != null && Build.VERSION.SDK_INT >= 19) {
                this.rc.resume();
            }
        } catch (Throwable th) {
        }
    }
}
