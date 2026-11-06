package com.byazt.jd;

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
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.byazt.ca.g;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 93, 834})
public class CycleCountDownView extends View {
    public ValueAnimator a;
    public float aj;
    public boolean b;
    public float c;
    public boolean cz;
    public float e;
    public String er;
    public Bitmap fo;
    public boolean fw;
    public Paint g;
    public final Rect gz;
    public int hn;
    public Paint ho;
    public int hw;
    public boolean iu;
    public Paint k;
    public ValueAnimator lb;
    public String ls;
    public Paint m;
    public final Rect n;
    public final Rect nl;
    public float nt;
    public boolean ny;
    public int pr;
    public ValueAnimator qa;
    public Bitmap rc;
    public String s;
    public int uc;
    public String v;
    public final RectF ve;
    public int vk;
    public boolean w;
    public final Rect ww;
    public float x;
    public final Rect y;
    public AnimatorSet yb;
    public Bitmap z;
    public float zo;

    public CycleCountDownView(Context context) {
        super(context);
        this.pr = Color.parseColor("#FFDA7B");
        this.hw = Color.parseColor("#4D000000");
        this.hn = Color.parseColor("#ffffff");
        this.uc = MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_SWITCH_CACHE_TIME;
        this.fw = false;
        this.zo = 5.0f;
        this.aj = 0.0f;
        this.vk = 0;
        this.w = false;
        this.nt = 0.0f;
        this.cz = false;
        this.ny = false;
        this.b = false;
        this.iu = false;
        this.ve = new RectF();
        this.gz = new Rect();
        this.nl = new Rect();
        this.y = new Rect();
        this.ww = new Rect();
        this.n = new Rect();
        this.e = 1.0f;
        this.x = pr(4.0f);
        this.c = pr(34.0f);
        this.uc %= MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL;
        hw();
        hn();
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
        Paint paint4 = new Paint(1);
        this.ho = paint4;
        paint4.setFilterBitmap(true);
        this.ho.setDither(true);
    }

    private void hn() {
        this.z = fw();
        g.pr(getContext(), "tt_reward_chest_gift2", new com.byazt.ezf.pr<Bitmap>() { // from class: com.byazt.jd.CycleCountDownView.1
            @Override // com.byazt.ezf.pr
            public void pr(Bitmap bitmap) {
                CycleCountDownView.this.fo = bitmap;
                CycleCountDownView.this.x();
            }
        }, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        g.pr(getContext(), "tt_reward_chest_gift_open2", new com.byazt.ezf.pr<Bitmap>() { // from class: com.byazt.jd.CycleCountDownView.2
            @Override // com.byazt.ezf.pr
            public void pr(Bitmap bitmap) {
                CycleCountDownView.this.rc = bitmap;
                CycleCountDownView.this.x();
            }
        }, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        if (this.rc != null && this.fo != null) {
            c();
            post(new Runnable() { // from class: com.byazt.jd.CycleCountDownView.3
                @Override // java.lang.Runnable
                public void run() {
                    CycleCountDownView.this.invalidate();
                }
            });
        }
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
        pr(size, size2);
        setMeasuredDimension(size, size2);
        c();
    }

    private void c() {
        this.ve.left = -this.c;
        this.ve.right = this.c;
        this.ve.top = -this.c;
        this.ve.bottom = this.c;
        this.gz.left = 0;
        this.gz.top = 0;
        Rect rect = this.gz;
        Bitmap bitmap = this.fo;
        rect.right = bitmap != null ? bitmap.getWidth() : 0;
        Rect rect2 = this.gz;
        Bitmap bitmap2 = this.fo;
        rect2.bottom = bitmap2 != null ? bitmap2.getHeight() : 0;
        this.nl.left = 0;
        this.nl.top = 0;
        Rect rect3 = this.nl;
        Bitmap bitmap3 = this.rc;
        rect3.right = bitmap3 != null ? bitmap3.getWidth() : 0;
        Rect rect4 = this.nl;
        Bitmap bitmap4 = this.rc;
        rect4.bottom = bitmap4 != null ? bitmap4.getHeight() : 0;
        int minLine = getMinLine();
        int i = -minLine;
        int i2 = i / 2;
        this.y.left = i2;
        this.y.top = i2;
        int i3 = minLine / 2;
        this.y.right = i3;
        this.y.bottom = i3;
        this.ww.left = 0;
        this.ww.top = 0;
        this.ww.right = this.z.getWidth();
        this.ww.bottom = this.z.getHeight();
        this.n.left = i / 3;
        this.n.top = minLine / 8;
        int i4 = minLine / 3;
        this.n.right = i4;
        this.n.bottom = i4;
        this.g.setTextSize(((this.n.bottom - this.n.top) / 2) - hw(2.0f));
    }

    private int uc() {
        return (int) ((((this.x / 2.0f) + this.c) * 2.0f) + pr(4.0f));
    }

    private void pr(int i, int i2) {
        this.c = (Math.min(i, i2) / 2.0f) - this.x;
    }

    private int getMinLine() {
        return Math.min(getMeasuredHeight(), getMeasuredWidth());
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(getMeasuredWidth() / 2.0f, getMeasuredHeight() / 2.0f);
        pr(canvas);
        hn(canvas);
        hw(canvas);
    }

    private void pr(Canvas canvas) {
        Bitmap bitmap;
        canvas.save();
        boolean z = false;
        if (this.vk <= 0 && (bitmap = this.rc) != null) {
            boolean z2 = this.b;
            if ((z2 && this.iu) || (!z2 && !this.iu)) {
                z = true;
            } else {
                bitmap = this.fo;
            }
        } else {
            bitmap = this.fo;
        }
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, z ? this.nl : this.gz, this.y, this.ho);
        }
        canvas.restore();
    }

    private void hw(Canvas canvas) {
        canvas.save();
        canvas.drawBitmap(this.z, this.ww, this.n, this.ho);
        Paint.FontMetrics fontMetrics = this.g.getFontMetrics();
        float f = (fontMetrics.bottom - fontMetrics.top) / 2.0f;
        String str = (!TextUtils.isEmpty(this.v) && this.vk <= 0) ? this.v : this.s + this.vk + this.ls;
        if (this.w) {
            str = str + "｜" + this.er;
        }
        canvas.drawText(str, 0.0f, ((getMinLine() / 3.0f) - (getMinLine() / 9.0f)) + (f / 2.0f), this.g);
        canvas.restore();
    }

    private void hn(Canvas canvas) {
        float f;
        canvas.save();
        float f2 = this.nt * 360.0f;
        if (this.fw) {
            f = this.uc - f2;
        } else {
            f = this.uc;
        }
        canvas.drawCircle(0.0f, 0.0f, this.c, this.m);
        canvas.drawArc(this.ve, f, f2, false, this.k);
        canvas.restore();
    }

    private ValueAnimator getArcAnim() {
        ValueAnimator valueAnimator = this.qa;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.qa = null;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.nt, this.e);
        this.qa = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        this.qa.setDuration(1000L);
        this.qa.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.byazt.jd.CycleCountDownView.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                CycleCountDownView.this.nt = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                CycleCountDownView.this.postInvalidate();
            }
        });
        return this.qa;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        try {
            AnimatorSet animatorSet = this.yb;
            if (animatorSet != null) {
                animatorSet.cancel();
                this.yb = null;
            }
            ValueAnimator valueAnimator = this.a;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.a = null;
            }
            ValueAnimator valueAnimator2 = this.lb;
            if (valueAnimator2 != null) {
                valueAnimator2.cancel();
                this.lb = null;
            }
            ValueAnimator valueAnimator3 = this.qa;
            if (valueAnimator3 != null) {
                valueAnimator3.cancel();
                this.qa = null;
            }
            this.nt = 1.0f;
            invalidate();
        } catch (Exception e) {
        }
        super.onDetachedFromWindow();
    }

    private float pr(float f) {
        return TypedValue.applyDimension(1, f, getResources().getDisplayMetrics());
    }

    private float hw(float f) {
        return TypedValue.applyDimension(2, f, getResources().getDisplayMetrics());
    }

    public void pr() {
        AnimatorSet animatorSet = this.yb;
        if (animatorSet != null && animatorSet.isRunning()) {
            this.yb.cancel();
            this.yb = null;
        }
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.yb = animatorSet2;
        animatorSet2.playTogether(getArcAnim());
        this.yb.setInterpolator(new LinearInterpolator());
        this.yb.addListener(new AnimatorListenerAdapter() { // from class: com.byazt.jd.CycleCountDownView.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                CycleCountDownView.this.cz = true;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (CycleCountDownView.this.cz) {
                    CycleCountDownView.this.cz = false;
                } else {
                    CycleCountDownView.this.ny = true;
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        this.yb.start();
    }

    public void pr(int i, int i2, int i3) {
        float f = i;
        this.zo = f;
        float f2 = i2;
        this.aj = f2;
        this.vk = i3;
        this.e = f2 / f;
        pr();
    }

    private Bitmap fw() {
        LayerDrawable layerDrawablePr = com.byazt.sdv.x.pr(getContext());
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(layerDrawablePr.getIntrinsicWidth(), layerDrawablePr.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        layerDrawablePr.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        layerDrawablePr.draw(canvas);
        return bitmapCreateBitmap;
    }

    public void setCanSkip(boolean z) {
        this.w = z;
    }

    public void pr(String str, String str2, String str3, String str4) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        this.s = str;
        this.ls = TextUtils.isEmpty(str2) ? "" : str2;
        if (TextUtils.isEmpty(str3)) {
            str3 = "跳过";
        }
        this.er = str3;
        if (TextUtils.isEmpty(str2)) {
            str4 = "";
        }
        this.v = str4;
    }

    public void setBoxImage(Bitmap bitmap) {
        this.fo = bitmap;
        this.b = true;
        this.gz.left = 0;
        this.gz.top = 0;
        Rect rect = this.gz;
        Bitmap bitmap2 = this.fo;
        rect.right = bitmap2 != null ? bitmap2.getWidth() : 0;
        Rect rect2 = this.gz;
        Bitmap bitmap3 = this.fo;
        rect2.bottom = bitmap3 != null ? bitmap3.getHeight() : 0;
    }

    public void setBoxFinish(Bitmap bitmap) {
        this.rc = bitmap;
        this.iu = true;
        this.nl.left = 0;
        this.nl.top = 0;
        Rect rect = this.nl;
        Bitmap bitmap2 = this.rc;
        rect.right = bitmap2 != null ? bitmap2.getWidth() : 0;
        Rect rect2 = this.nl;
        Bitmap bitmap3 = this.rc;
        rect2.bottom = bitmap3 != null ? bitmap3.getHeight() : 0;
    }
}
