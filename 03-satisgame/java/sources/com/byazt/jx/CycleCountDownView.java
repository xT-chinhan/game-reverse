package com.byazt.jx;

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
import com.byazt.tk.sz;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 508, 1114})
public class CycleCountDownView extends View {
    public ValueAnimator a;
    public String ae;
    public float an;
    public final Rect bb;
    public ValueAnimator cd;
    public boolean cp;
    public float cy;
    public Paint d;
    public String df;
    public String f;
    public String fi;
    public float fs;
    public boolean h;
    public AnimatorSet hd;
    public Bitmap hu;
    public final Rect j;
    public Paint k;
    public float l;
    public final Rect lh;
    public final Rect ln;
    public Bitmap m;
    public int n;
    public Paint oa;
    public boolean ou;
    public boolean py;
    public float q;
    public int qg;
    public float rv;
    public int s;
    public Paint sz;
    public boolean t;
    public int tj;
    public ValueAnimator um;
    public final RectF ur;
    public final Rect v;
    public int w;
    public Bitmap wm;
    public boolean x;

    public CycleCountDownView(Context context) {
        super(context);
        this.n = Color.parseColor("#FFDA7B");
        this.qg = Color.parseColor("#4D000000");
        this.s = Color.parseColor("#ffffff");
        this.w = MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_SWITCH_CACHE_TIME;
        this.x = false;
        this.fs = 5.0f;
        this.rv = 0.0f;
        this.tj = 0;
        this.cp = false;
        this.cy = 0.0f;
        this.py = false;
        this.ou = false;
        this.h = false;
        this.t = false;
        this.ur = new RectF();
        this.bb = new Rect();
        this.ln = new Rect();
        this.lh = new Rect();
        this.v = new Rect();
        this.j = new Rect();
        this.an = 1.0f;
        this.q = n(4.0f);
        this.l = n(34.0f);
        this.w %= MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL;
        qg();
        s();
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
        Paint paint4 = new Paint(1);
        this.k = paint4;
        paint4.setFilterBitmap(true);
        this.k.setDither(true);
    }

    private void s() {
        this.hu = x();
        sz.n(getContext(), "tt_reward_chest_gift2", new com.byazt.qyj.n<Bitmap>() { // from class: com.byazt.jx.CycleCountDownView.1
            @Override // com.byazt.qyj.n
            public void n(Bitmap bitmap) {
                CycleCountDownView.this.wm = bitmap;
                CycleCountDownView.this.q();
            }
        }, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        sz.n(getContext(), "tt_reward_chest_gift_open2", new com.byazt.qyj.n<Bitmap>() { // from class: com.byazt.jx.CycleCountDownView.2
            @Override // com.byazt.qyj.n
            public void n(Bitmap bitmap) {
                CycleCountDownView.this.m = bitmap;
                CycleCountDownView.this.q();
            }
        }, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        if (this.m == null || this.wm == null) {
            return;
        }
        l();
        post(new Runnable() { // from class: com.byazt.jx.CycleCountDownView.3
            @Override // java.lang.Runnable
            public void run() {
                CycleCountDownView.this.invalidate();
            }
        });
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (mode != 1073741824) {
            size = w();
        }
        if (mode2 != 1073741824) {
            size2 = w();
        }
        n(size, size2);
        setMeasuredDimension(size, size2);
        l();
    }

    private void l() {
        this.ur.left = -this.l;
        this.ur.right = this.l;
        this.ur.top = -this.l;
        this.ur.bottom = this.l;
        this.bb.left = 0;
        this.bb.top = 0;
        Rect rect = this.bb;
        Bitmap bitmap = this.wm;
        rect.right = bitmap != null ? bitmap.getWidth() : 0;
        Rect rect2 = this.bb;
        Bitmap bitmap2 = this.wm;
        rect2.bottom = bitmap2 != null ? bitmap2.getHeight() : 0;
        this.ln.left = 0;
        this.ln.top = 0;
        Rect rect3 = this.ln;
        Bitmap bitmap3 = this.m;
        rect3.right = bitmap3 != null ? bitmap3.getWidth() : 0;
        Rect rect4 = this.ln;
        Bitmap bitmap4 = this.m;
        rect4.bottom = bitmap4 != null ? bitmap4.getHeight() : 0;
        int minLine = getMinLine();
        int i = -minLine;
        int i2 = i / 2;
        this.lh.left = i2;
        this.lh.top = i2;
        int i3 = minLine / 2;
        this.lh.right = i3;
        this.lh.bottom = i3;
        this.v.left = 0;
        this.v.top = 0;
        this.v.right = this.hu.getWidth();
        this.v.bottom = this.hu.getHeight();
        this.j.left = i / 3;
        this.j.top = minLine / 8;
        int i4 = minLine / 3;
        this.j.right = i4;
        this.j.bottom = i4;
        this.sz.setTextSize(((this.j.bottom - this.j.top) / 2) - qg(2.0f));
    }

    private int w() {
        return (int) ((((this.q / 2.0f) + this.l) * 2.0f) + n(4.0f));
    }

    private void n(int i, int i2) {
        this.l = (Math.min(i, i2) / 2.0f) - this.q;
    }

    private int getMinLine() {
        return Math.min(getMeasuredHeight(), getMeasuredWidth());
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(getMeasuredWidth() / 2.0f, getMeasuredHeight() / 2.0f);
        n(canvas);
        s(canvas);
        qg(canvas);
    }

    private void n(Canvas canvas) {
        Bitmap bitmap;
        canvas.save();
        boolean z = false;
        if (this.tj <= 0 && (bitmap = this.m) != null) {
            boolean z2 = this.h;
            if (!(z2 && this.t) && (z2 || this.t)) {
                bitmap = this.wm;
            } else {
                z = true;
            }
        } else {
            bitmap = this.wm;
        }
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, z ? this.ln : this.bb, this.lh, this.k);
        }
        canvas.restore();
    }

    private void qg(Canvas canvas) {
        canvas.save();
        canvas.drawBitmap(this.hu, this.v, this.j, this.k);
        Paint.FontMetrics fontMetrics = this.sz.getFontMetrics();
        float f = (fontMetrics.bottom - fontMetrics.top) / 2.0f;
        String str = (!TextUtils.isEmpty(this.df) && this.tj <= 0) ? this.df : this.ae + this.tj + this.f;
        if (this.cp) {
            str = str + "｜" + this.fi;
        }
        canvas.drawText(str, 0.0f, ((getMinLine() / 3.0f) - (getMinLine() / 9.0f)) + (f / 2.0f), this.sz);
        canvas.restore();
    }

    private void s(Canvas canvas) {
        float f;
        canvas.save();
        float f2 = this.cy * 360.0f;
        if (this.x) {
            f = this.w - f2;
        } else {
            f = this.w;
        }
        canvas.drawCircle(0.0f, 0.0f, this.l, this.oa);
        canvas.drawArc(this.ur, f, f2, false, this.d);
        canvas.restore();
    }

    private ValueAnimator getArcAnim() {
        ValueAnimator valueAnimator = this.um;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.um = null;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.cy, this.an);
        this.um = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        this.um.setDuration(1000L);
        this.um.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.byazt.jx.CycleCountDownView.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                CycleCountDownView.this.cy = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                CycleCountDownView.this.postInvalidate();
            }
        });
        return this.um;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        try {
            AnimatorSet animatorSet = this.hd;
            if (animatorSet != null) {
                animatorSet.cancel();
                this.hd = null;
            }
            ValueAnimator valueAnimator = this.a;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.a = null;
            }
            ValueAnimator valueAnimator2 = this.cd;
            if (valueAnimator2 != null) {
                valueAnimator2.cancel();
                this.cd = null;
            }
            ValueAnimator valueAnimator3 = this.um;
            if (valueAnimator3 != null) {
                valueAnimator3.cancel();
                this.um = null;
            }
            this.cy = 1.0f;
            invalidate();
        } catch (Exception unused) {
        }
        super.onDetachedFromWindow();
    }

    private float n(float f) {
        return TypedValue.applyDimension(1, f, getResources().getDisplayMetrics());
    }

    private float qg(float f) {
        return TypedValue.applyDimension(2, f, getResources().getDisplayMetrics());
    }

    public void n() {
        AnimatorSet animatorSet = this.hd;
        if (animatorSet != null && animatorSet.isRunning()) {
            this.hd.cancel();
            this.hd = null;
        }
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.hd = animatorSet2;
        animatorSet2.playTogether(getArcAnim());
        this.hd.setInterpolator(new LinearInterpolator());
        this.hd.addListener(new AnimatorListenerAdapter() { // from class: com.byazt.jx.CycleCountDownView.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                CycleCountDownView.this.py = true;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (CycleCountDownView.this.py) {
                    CycleCountDownView.this.py = false;
                } else {
                    CycleCountDownView.this.ou = true;
                }
            }
        });
        this.hd.start();
    }

    public void n(int i, int i2, int i3) {
        float f = i;
        this.fs = f;
        float f2 = i2;
        this.rv = f2;
        this.tj = i3;
        this.an = f2 / f;
        n();
    }

    private Bitmap x() {
        LayerDrawable layerDrawableN = com.byazt.cb.n.n(getContext());
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(layerDrawableN.getIntrinsicWidth(), layerDrawableN.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        layerDrawableN.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        layerDrawableN.draw(canvas);
        return bitmapCreateBitmap;
    }

    public void setCanSkip(boolean z) {
        this.cp = z;
    }

    public void n(String str, String str2, String str3, String str4) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        this.ae = str;
        this.f = TextUtils.isEmpty(str2) ? "" : str2;
        if (TextUtils.isEmpty(str3)) {
            str3 = "跳过";
        }
        this.fi = str3;
        if (TextUtils.isEmpty(str2)) {
            str4 = "";
        }
        this.df = str4;
    }

    public void setBoxImage(Bitmap bitmap) {
        this.wm = bitmap;
        this.h = true;
        this.bb.left = 0;
        this.bb.top = 0;
        Rect rect = this.bb;
        Bitmap bitmap2 = this.wm;
        rect.right = bitmap2 != null ? bitmap2.getWidth() : 0;
        Rect rect2 = this.bb;
        Bitmap bitmap3 = this.wm;
        rect2.bottom = bitmap3 != null ? bitmap3.getHeight() : 0;
    }

    public void setBoxFinish(Bitmap bitmap) {
        this.m = bitmap;
        this.t = true;
        this.ln.left = 0;
        this.ln.top = 0;
        Rect rect = this.ln;
        Bitmap bitmap2 = this.m;
        rect.right = bitmap2 != null ? bitmap2.getWidth() : 0;
        Rect rect2 = this.ln;
        Bitmap bitmap3 = this.m;
        rect2.bottom = bitmap3 != null ? bitmap3.getHeight() : 0;
    }
}
