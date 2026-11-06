package com.smartdigimkt.sdk.basead.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.smartdigimkt.n1.a5;
import com.smartdigimkt.r4.k;

/* JADX INFO: loaded from: classes3.dex */
public class SimpleGuideToClickView extends RelativeLayout {
    public WaveAnimImageView a;
    public WaveAnimImageView b;
    public ImageView c;
    public float d;
    public float e;
    public float f;
    public float g;
    public float h;
    public float i;
    public ValueAnimator j;
    public ValueAnimator k;
    public ScaleAnimation l;

    public SimpleGuideToClickView(Context context) {
        super(context);
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
        this.a = (WaveAnimImageView) findViewById(k.a(context, "myoffer_wave_anim_image", "id"));
        this.b = (WaveAnimImageView) findViewById(k.a(context, "myoffer_wave_anim_image2", "id"));
        this.j = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.k = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.c = (ImageView) findViewById(k.a(context, "myoffer_guide_to_click_finger", "id"));
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.1f, 1.0f, 1.1f);
        this.l = scaleAnimation;
        scaleAnimation.setRepeatMode(2);
        this.l.setRepeatCount(-1);
        this.l.setDuration(333L);
        setClipChildren(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.c != null) {
            startAnim(this.j, this.a, 0L);
            startAnim(this.k, this.b, 800L);
            this.c.startAnimation(this.l);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.j;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.j.removeAllUpdateListeners();
            this.j.cancel();
        }
        ValueAnimator valueAnimator2 = this.k;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllListeners();
            this.k.removeAllUpdateListeners();
            this.k.cancel();
        }
        ScaleAnimation scaleAnimation = this.l;
        if (scaleAnimation != null) {
            scaleAnimation.cancel();
        }
    }

    public void startAnim(ValueAnimator valueAnimator, WaveAnimImageView waveAnimImageView, long j) {
        if (valueAnimator != null) {
            valueAnimator.setRepeatMode(1);
            valueAnimator.setRepeatCount(-1);
            valueAnimator.setDuration(1400L);
            valueAnimator.removeAllUpdateListeners();
            valueAnimator.removeAllListeners();
            valueAnimator.addUpdateListener(new a5(this, waveAnimImageView));
            valueAnimator.setStartDelay(j);
            valueAnimator.start();
        }
    }

    public SimpleGuideToClickView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SimpleGuideToClickView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
