package com.anythink.basead.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.anythink.core.common.v.q;

/* JADX INFO: loaded from: classes.dex */
public class SimpleGuideToClickView extends RelativeLayout {
    WaveAnimImageView a;
    WaveAnimImageView b;
    ImageView c;
    float d;
    float e;
    float f;
    float g;
    float h;
    float i;
    final int j;
    final int k;
    final float l;
    ValueAnimator m;
    ValueAnimator n;
    ScaleAnimation o;

    public SimpleGuideToClickView(Context context) {
        super(context);
        this.j = 1000;
        this.k = 200;
        this.l = 0.71428573f;
    }

    public SimpleGuideToClickView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.j = 1000;
        this.k = 200;
        this.l = 0.71428573f;
    }

    public SimpleGuideToClickView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.j = 1000;
        this.k = 200;
        this.l = 0.71428573f;
    }

    public void init(int i, int i2, int i3, int i4, int i5) {
        Context context = getContext();
        LayoutInflater.from(context).inflate(i, this);
        this.d = 0.8f;
        this.e = 0.05f;
        this.f = i2;
        this.g = i4;
        this.h = i3;
        this.i = i5;
        this.a = (WaveAnimImageView) findViewById(q.a(context, "myoffer_wave_anim_image", "id"));
        this.b = (WaveAnimImageView) findViewById(q.a(context, "myoffer_wave_anim_image2", "id"));
        this.m = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.n = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.c = (ImageView) findViewById(q.a(context, "myoffer_guide_to_click_finger", "id"));
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.1f, 1.0f, 1.1f);
        this.o = scaleAnimation;
        scaleAnimation.setRepeatMode(2);
        this.o.setRepeatCount(-1);
        this.o.setDuration(333L);
        setClipChildren(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.c != null) {
            startAnim(this.m, this.a, 0L);
            startAnim(this.n, this.b, 800L);
            this.c.startAnimation(this.o);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.m;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.m.removeAllUpdateListeners();
            this.m.cancel();
        }
        ValueAnimator valueAnimator2 = this.n;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllListeners();
            this.n.removeAllUpdateListeners();
            this.n.cancel();
        }
        ScaleAnimation scaleAnimation = this.o;
        if (scaleAnimation != null) {
            scaleAnimation.cancel();
        }
    }

    private void a() {
        if (this.c != null) {
            startAnim(this.m, this.a, 0L);
            startAnim(this.n, this.b, 800L);
            this.c.startAnimation(this.o);
        }
    }

    private void b() {
        ValueAnimator valueAnimator = this.m;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.m.removeAllUpdateListeners();
            this.m.cancel();
        }
        ValueAnimator valueAnimator2 = this.n;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllListeners();
            this.n.removeAllUpdateListeners();
            this.n.cancel();
        }
        ScaleAnimation scaleAnimation = this.o;
        if (scaleAnimation != null) {
            scaleAnimation.cancel();
        }
    }

    public void startAnim(ValueAnimator valueAnimator, final WaveAnimImageView waveAnimImageView, long j) {
        if (valueAnimator != null) {
            valueAnimator.setRepeatMode(1);
            valueAnimator.setRepeatCount(-1);
            valueAnimator.setDuration(1400L);
            valueAnimator.removeAllUpdateListeners();
            valueAnimator.removeAllListeners();
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.anythink.basead.ui.SimpleGuideToClickView.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    float f;
                    float fFloatValue = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                    if (fFloatValue > 0.71428573f) {
                        waveAnimImageView.setVisibility(4);
                        return;
                    }
                    float f2 = fFloatValue / 0.71428573f;
                    float f3 = SimpleGuideToClickView.this.h + ((SimpleGuideToClickView.this.i - SimpleGuideToClickView.this.h) * f2);
                    float f4 = SimpleGuideToClickView.this.f + ((SimpleGuideToClickView.this.g - SimpleGuideToClickView.this.h) * f2);
                    double d = f2;
                    if (d < 0.2d) {
                        f = (float) (((double) SimpleGuideToClickView.this.d) + ((1.0d - (((double) (f2 * 1.0f)) / 0.2d)) * ((double) (SimpleGuideToClickView.this.e - SimpleGuideToClickView.this.d))));
                    } else {
                        f = (float) (((double) SimpleGuideToClickView.this.d) + ((((d - 0.2d) * 1.0d) / 0.8d) * ((double) (SimpleGuideToClickView.this.e - SimpleGuideToClickView.this.d))));
                    }
                    try {
                        if (SimpleGuideToClickView.this.getVisibility() == 0) {
                            waveAnimImageView.setWaveAnimParams(new WaveAnimImageView.a(f3, f4, f));
                            if (waveAnimImageView.getVisibility() != 0) {
                                waveAnimImageView.setVisibility(0);
                            }
                        }
                    } catch (Throwable unused) {
                    }
                }
            });
            valueAnimator.setStartDelay(j);
            valueAnimator.start();
        }
    }
}
