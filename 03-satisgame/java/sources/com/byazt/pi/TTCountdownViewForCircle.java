package com.byazt.pi;

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
import com.byazt.nf.rv;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 743, 1599})
public class TTCountdownViewForCircle extends View implements q {
    public float a;
    public AtomicBoolean bb;
    public Paint cd;
    public float cp;
    public Paint cy;
    public float d;
    public int fs;
    public ValueAnimator h;
    public Paint hd;
    public ValueAnimator hu;
    public boolean k;
    public float l;
    public final AtomicBoolean ln;
    public AnimatorSet m;
    public int n;
    public String oa;
    public RectF ou;
    public float py;
    public int q;
    public int qg;
    public boolean rv;
    public int s;
    public boolean sz;
    public ValueAnimator t;
    public float tj;
    public Paint um;
    public boolean ur;
    public float w;
    public n wm;
    public float x;

    @Override // com.byazt.pi.q
    public View getView() {
        return this;
    }

    public float n(float f, float f2) {
        return f * f2;
    }

    public float n(float f, int i) {
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
        this.n = Color.parseColor("#fce8b6");
        this.qg = Color.parseColor("#f0f0f0");
        this.s = Color.parseColor("#ffffff");
        this.q = Color.parseColor("#7c7c7c");
        this.l = 2.0f;
        this.w = 12.0f;
        this.x = 18.0f;
        this.fs = MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_SWITCH_CACHE_TIME;
        this.rv = false;
        this.tj = 5.0f;
        this.cp = 5.0f;
        this.d = 0.8f;
        this.oa = "跳过";
        this.sz = false;
        this.k = false;
        this.a = 1.0f;
        this.py = 1.0f;
        this.ur = false;
        this.bb = new AtomicBoolean(true);
        this.ln = new AtomicBoolean(false);
        this.l = n(2.0f);
        this.x = n(18.0f);
        this.w = qg(12.0f);
        this.fs %= MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL;
        w();
        x();
    }

    private void w() {
        Paint paint = new Paint(1);
        this.cy = paint;
        paint.setColor(this.n);
        this.cy.setStrokeWidth(this.l);
        this.cy.setAntiAlias(true);
        this.cy.setStyle(Paint.Style.STROKE);
        Paint paint2 = new Paint(1);
        this.hd = paint2;
        paint2.setColor(this.s);
        this.hd.setAntiAlias(true);
        this.hd.setStrokeWidth(this.l);
        this.hd.setStyle(Paint.Style.FILL);
        Paint paint3 = new Paint(1);
        this.cd = paint3;
        paint3.setColor(this.qg);
        this.cd.setAntiAlias(true);
        this.cd.setStrokeWidth(this.l / 2.0f);
        this.cd.setStyle(Paint.Style.STROKE);
        Paint paint4 = new Paint(1);
        this.um = paint4;
        paint4.setColor(this.q);
        this.cd.setAntiAlias(true);
        this.um.setTextSize(this.w);
        this.um.setTextAlign(Paint.Align.CENTER);
    }

    private void x() {
        float f = this.x;
        this.ou = new RectF(-f, -f, f, f);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (mode != 1073741824) {
            size = fs();
        }
        if (mode2 != 1073741824) {
            size2 = fs();
        }
        setMeasuredDimension(size, size2);
    }

    private int fs() {
        return (int) ((((this.l / 2.0f) + this.x) * 2.0f) + n(4.0f));
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
        Paint.FontMetrics fontMetrics = this.um.getFontMetrics();
        String strIz = rv.qg().iz();
        this.oa = strIz;
        if (TextUtils.isEmpty(strIz)) {
            this.oa = "跳过";
        }
        canvas.drawText(this.oa, 0.0f, 0.0f - ((fontMetrics.ascent + fontMetrics.descent) / 2.0f), this.um);
        canvas.restore();
    }

    private void qg(Canvas canvas) {
        float f;
        canvas.save();
        float fN = n(this.a, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL);
        if (this.rv) {
            f = this.fs - fN;
        } else {
            f = this.fs;
        }
        canvas.drawCircle(0.0f, 0.0f, this.x, this.hd);
        canvas.drawCircle(0.0f, 0.0f, this.x, this.cd);
        canvas.drawArc(this.ou, f, fN, false, this.cy);
        canvas.restore();
    }

    @Override // com.byazt.pi.q
    public void n() {
        if (this.k) {
            return;
        }
        AnimatorSet animatorSet = this.m;
        if (animatorSet != null && animatorSet.isRunning()) {
            this.m.cancel();
            this.m = null;
        }
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.m = animatorSet2;
        animatorSet2.playTogether(getNumAnim(), getArcAnim());
        this.m.setInterpolator(new LinearInterpolator());
        this.m.addListener(new AnimatorListenerAdapter() { // from class: com.byazt.pi.TTCountdownViewForCircle.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                TTCountdownViewForCircle.this.ur = true;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (TTCountdownViewForCircle.this.ur) {
                    TTCountdownViewForCircle.this.ur = false;
                } else if (TTCountdownViewForCircle.this.wm != null) {
                    TTCountdownViewForCircle.this.wm.n();
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
        this.m.start();
        if (this.bb.get()) {
            return;
        }
        q();
    }

    @Override // com.byazt.pi.q
    public void n(boolean z) {
        this.k = z;
        if (z) {
            rv();
        }
    }

    private ValueAnimator getNumAnim() {
        ValueAnimator valueAnimator = this.hu;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.hu = null;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.py, 0.0f);
        this.hu = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        this.hu.setDuration((long) (n(this.py, this.cp) * 1000.0f));
        this.hu.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.byazt.pi.TTCountdownViewForCircle.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                TTCountdownViewForCircle.this.py = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                TTCountdownViewForCircle.this.invalidate();
            }
        });
        return this.hu;
    }

    private ValueAnimator getArcAnim() {
        ValueAnimator valueAnimator = this.h;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.h = null;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.a, 0.0f);
        this.h = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        this.h.setDuration((long) (n(this.a, this.tj) * 1000.0f));
        this.h.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.byazt.pi.TTCountdownViewForCircle.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                TTCountdownViewForCircle.this.a = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                TTCountdownViewForCircle.this.invalidate();
            }
        });
        return this.h;
    }

    private void rv() {
        try {
            AnimatorSet animatorSet = this.m;
            if (animatorSet != null) {
                animatorSet.cancel();
                this.m = null;
            }
            ValueAnimator valueAnimator = this.t;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.t = null;
            }
            ValueAnimator valueAnimator2 = this.hu;
            if (valueAnimator2 != null) {
                valueAnimator2.cancel();
                this.hu = null;
            }
            ValueAnimator valueAnimator3 = this.h;
            if (valueAnimator3 != null) {
                valueAnimator3.cancel();
                this.h = null;
            }
            this.a = 1.0f;
            this.py = 1.0f;
            invalidate();
        } catch (Exception unused) {
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        rv();
        super.onDetachedFromWindow();
    }

    @Override // com.byazt.pi.q
    public void setCountDownTime(int i) {
        float f = i;
        this.cp = f;
        this.tj = f;
        rv();
    }

    private float n(float f) {
        return TypedValue.applyDimension(1, f, getResources().getDisplayMetrics());
    }

    private float qg(float f) {
        return TypedValue.applyDimension(2, f, getResources().getDisplayMetrics());
    }

    public n getCountdownListener() {
        return this.wm;
    }

    @Override // com.byazt.pi.q
    public void setCountdownListener(n nVar) {
        this.wm = nVar;
        this.bb.get();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.bb.set(z);
        if (this.k) {
            return;
        }
        if (!this.bb.get()) {
            q();
        } else {
            if (this.ln.get()) {
                return;
            }
            l();
        }
    }

    @Override // com.byazt.pi.q
    public void qg() {
        this.ln.set(true);
        q();
    }

    @Override // com.byazt.pi.q
    public void s() {
        this.ln.set(false);
        if (this.bb.get()) {
            l();
        }
    }

    public void q() {
        try {
            if (this.m != null) {
                this.m.pause();
            }
        } catch (Throwable unused) {
        }
    }

    public void l() {
        try {
            if (this.k || this.m == null) {
                return;
            }
            this.m.resume();
        } catch (Throwable unused) {
        }
    }
}
