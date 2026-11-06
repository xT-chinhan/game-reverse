package com.bytedance.sdk.openadsdk.core.ugeno.component.countdown;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.component.utils.t;

/* JADX INFO: loaded from: classes2.dex */
public class CycleCountDownView extends View {
    protected boolean ab;
    protected int ah;
    private float ao;
    private String az;
    private boolean b;
    protected int c;
    protected int ch;
    private final Rect cv;
    protected float d;
    private String f;
    private final Rect g;
    private AnimatorSet h;
    private boolean hi;
    private Bitmap i;
    private float jw;
    protected float ka;
    private final RectF le;
    private String m;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected int f3426ms;
    private boolean nw;
    protected float ny;
    private final Rect of;
    private boolean op;
    private final Rect p;
    private final Rect pc;
    private ValueAnimator qv;
    private Bitmap re;
    private Paint sl;
    private ValueAnimator t;
    private Paint u;
    private Paint ub;
    private String ul;
    private Bitmap w;
    protected float x;
    protected int xr;
    private ValueAnimator y;
    private boolean yu;
    private Paint zb;

    public CycleCountDownView(Context context) {
        super(context);
        this.f3426ms = Color.parseColor("#FFDA7B");
        this.xr = Color.parseColor("#4D000000");
        this.ah = Color.parseColor("#ffffff");
        this.c = MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_SWITCH_CACHE_TIME;
        this.ab = false;
        this.x = 5.0f;
        this.ny = 0.0f;
        this.ch = 0;
        this.hi = false;
        this.ao = 0.0f;
        this.nw = false;
        this.b = false;
        this.yu = false;
        this.op = false;
        this.le = new RectF();
        this.cv = new Rect();
        this.g = new Rect();
        this.of = new Rect();
        this.p = new Rect();
        this.pc = new Rect();
        this.jw = 1.0f;
        this.d = ms(4.0f);
        this.ka = ms(34.0f);
        this.c %= MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL;
        xr();
        ah();
        setBackgroundColor(-16711681);
    }

    private void xr() {
        Paint paint = new Paint(1);
        this.sl = paint;
        paint.setColor(this.f3426ms);
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
        Paint paint4 = new Paint(1);
        this.ub = paint4;
        paint4.setFilterBitmap(true);
        this.ub.setDither(true);
    }

    private void ah() {
        this.re = t.d(getContext(), "tt_reward_chest_gift2");
        this.i = t.d(getContext(), "tt_reward_chest_gift_open2");
        this.w = ms(getContext(), "tt_reward_chest_btn_bg");
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (mode != 1073741824) {
            size = d();
        }
        if (mode2 != 1073741824) {
            size2 = d();
        }
        ms(size, size2);
        setMeasuredDimension(size, size2);
        this.le.left = -this.ka;
        this.le.right = this.ka;
        this.le.top = -this.ka;
        this.le.bottom = this.ka;
        this.cv.left = 0;
        this.cv.top = 0;
        Rect rect = this.cv;
        Bitmap bitmap = this.re;
        rect.right = bitmap != null ? bitmap.getWidth() : 0;
        Rect rect2 = this.cv;
        Bitmap bitmap2 = this.re;
        rect2.bottom = bitmap2 != null ? bitmap2.getHeight() : 0;
        this.g.left = 0;
        this.g.top = 0;
        Rect rect3 = this.g;
        Bitmap bitmap3 = this.i;
        rect3.right = bitmap3 != null ? bitmap3.getWidth() : 0;
        Rect rect4 = this.g;
        Bitmap bitmap4 = this.i;
        rect4.bottom = bitmap4 != null ? bitmap4.getHeight() : 0;
        int minLine = getMinLine();
        int i3 = -minLine;
        int i4 = i3 / 2;
        this.of.left = i4;
        this.of.top = i4;
        int i5 = minLine / 2;
        this.of.right = i5;
        this.of.bottom = i5;
        this.p.left = 0;
        this.p.top = 0;
        this.p.right = this.w.getWidth();
        this.p.bottom = this.w.getHeight();
        this.pc.left = i3 / 3;
        this.pc.top = minLine / 8;
        int i6 = minLine / 3;
        this.pc.right = i6;
        this.pc.bottom = i6;
        this.u.setTextSize(((this.pc.bottom - this.pc.top) / 2) - xr(2.0f));
    }

    private int d() {
        return (int) ((((this.d / 2.0f) + this.ka) * 2.0f) + ms(4.0f));
    }

    private void ms(int i, int i2) {
        this.ka = (Math.min(i, i2) / 2.0f) - this.d;
    }

    private int getMinLine() {
        return Math.min(getMeasuredHeight(), getMeasuredWidth());
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(getMeasuredWidth() / 2.0f, getMeasuredHeight() / 2.0f);
        ms(canvas);
        ah(canvas);
        xr(canvas);
    }

    private void ms(Canvas canvas) {
        Bitmap bitmap;
        canvas.save();
        boolean z = false;
        if (this.ch <= 0 && (bitmap = this.i) != null) {
            boolean z2 = this.yu;
            if (!(z2 && this.op) && (z2 || this.op)) {
                bitmap = this.re;
            } else {
                z = true;
            }
        } else {
            bitmap = this.re;
        }
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, z ? this.g : this.cv, this.of, this.ub);
        }
        canvas.restore();
    }

    private void xr(Canvas canvas) {
        canvas.save();
        canvas.drawBitmap(this.w, this.p, this.pc, this.ub);
        Paint.FontMetrics fontMetrics = this.u.getFontMetrics();
        float f = (fontMetrics.bottom - fontMetrics.top) / 2.0f;
        String str = (!TextUtils.isEmpty(this.m) && this.ch <= 0) ? this.m : this.f + this.ch + this.ul;
        if (this.hi) {
            str = str + "｜" + this.az;
        }
        canvas.drawText(str, 0.0f, ((getMinLine() / 3.0f) - (getMinLine() / 9.0f)) + (f / 2.0f), this.u);
        canvas.restore();
    }

    private void ah(Canvas canvas) {
        float f;
        canvas.save();
        float f2 = this.ao * 360.0f;
        if (this.ab) {
            f = this.c - f2;
        } else {
            f = this.c;
        }
        canvas.drawCircle(0.0f, 0.0f, this.ka, this.zb);
        canvas.drawArc(this.le, f, f2, false, this.sl);
        canvas.restore();
    }

    private ValueAnimator getArcAnim() {
        ValueAnimator valueAnimator = this.y;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.y = null;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.ao, this.jw);
        this.y = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        this.y.setDuration(1000L);
        this.y.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.countdown.CycleCountDownView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                CycleCountDownView.this.ao = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                CycleCountDownView.this.postInvalidate();
            }
        });
        return this.y;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        try {
            AnimatorSet animatorSet = this.h;
            if (animatorSet != null) {
                animatorSet.cancel();
                this.h = null;
            }
            ValueAnimator valueAnimator = this.t;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.t = null;
            }
            ValueAnimator valueAnimator2 = this.qv;
            if (valueAnimator2 != null) {
                valueAnimator2.cancel();
                this.qv = null;
            }
            ValueAnimator valueAnimator3 = this.y;
            if (valueAnimator3 != null) {
                valueAnimator3.cancel();
                this.y = null;
            }
            this.ao = 1.0f;
            invalidate();
        } catch (Exception unused) {
        }
        super.onDetachedFromWindow();
    }

    private float ms(float f) {
        return TypedValue.applyDimension(1, f, getResources().getDisplayMetrics());
    }

    private float xr(float f) {
        return TypedValue.applyDimension(2, f, getResources().getDisplayMetrics());
    }

    public void ms() {
        AnimatorSet animatorSet = this.h;
        if (animatorSet != null && animatorSet.isRunning()) {
            this.h.cancel();
            this.h = null;
        }
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.h = animatorSet2;
        animatorSet2.playTogether(getArcAnim());
        this.h.setInterpolator(new LinearInterpolator());
        this.h.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.countdown.CycleCountDownView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                CycleCountDownView.this.nw = true;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (CycleCountDownView.this.nw) {
                    CycleCountDownView.this.nw = false;
                } else {
                    CycleCountDownView.this.b = true;
                }
            }
        });
        this.h.start();
    }

    public void ms(int i, int i2, int i3) {
        float f = i;
        this.x = f;
        float f2 = i2;
        this.ny = f2;
        this.ch = i3;
        this.jw = f2 / f;
        ms();
    }

    private Bitmap ms(Context context, String str) {
        Drawable drawableAh = t.ah(context, str);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(drawableAh.getIntrinsicWidth(), drawableAh.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawableAh.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawableAh.draw(canvas);
        return bitmapCreateBitmap;
    }

    public void setCanSkip(boolean z) {
        this.hi = z;
    }

    public void ms(String str, String str2, String str3, String str4) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        this.f = str;
        this.ul = TextUtils.isEmpty(str2) ? "" : str2;
        if (TextUtils.isEmpty(str3)) {
            str3 = "跳过";
        }
        this.az = str3;
        if (TextUtils.isEmpty(str2)) {
            str4 = "";
        }
        this.m = str4;
    }

    public void setBoxImage(Bitmap bitmap) {
        this.re = bitmap;
        this.yu = true;
        this.cv.left = 0;
        this.cv.top = 0;
        Rect rect = this.cv;
        Bitmap bitmap2 = this.re;
        rect.right = bitmap2 != null ? bitmap2.getWidth() : 0;
        Rect rect2 = this.cv;
        Bitmap bitmap3 = this.re;
        rect2.bottom = bitmap3 != null ? bitmap3.getHeight() : 0;
    }

    public void setBoxFinish(Bitmap bitmap) {
        this.i = bitmap;
        this.op = true;
        this.g.left = 0;
        this.g.top = 0;
        Rect rect = this.g;
        Bitmap bitmap2 = this.i;
        rect.right = bitmap2 != null ? bitmap2.getWidth() : 0;
        Rect rect2 = this.g;
        Bitmap bitmap3 = this.i;
        rect2.bottom = bitmap3 != null ? bitmap3.getHeight() : 0;
    }
}
