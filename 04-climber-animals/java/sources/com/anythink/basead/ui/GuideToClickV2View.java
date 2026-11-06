package com.anythink.basead.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.anythink.core.common.v.q;

/* JADX INFO: loaded from: classes.dex */
public class GuideToClickV2View extends RelativeLayout {
    WaveAnimImageView a;
    WaveAnimImageView b;
    ImageView c;
    TextView d;
    float e;
    float f;
    float g;
    float h;
    float i;
    float j;
    final int k;
    final int l;
    final float m;
    ValueAnimator n;
    ValueAnimator o;
    ScaleAnimation p;

    public GuideToClickV2View(Context context) {
        super(context);
        this.k = 1000;
        this.l = 200;
        this.m = 0.71428573f;
        a(context);
    }

    public GuideToClickV2View(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.k = 1000;
        this.l = 200;
        this.m = 0.71428573f;
        a(context);
    }

    public GuideToClickV2View(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.k = 1000;
        this.l = 200;
        this.m = 0.71428573f;
        a(context);
    }

    private void a(Context context) {
        LayoutInflater.from(context).inflate(q.a(context, "myoffer_guide_to_click_v2", "layout"), this);
        setBackgroundColor(Color.parseColor("#66000000"));
        this.e = 0.8f;
        this.f = 0.05f;
        this.g = q.a(context, 4.0f);
        this.h = q.a(context, 8.0f);
        this.i = q.a(context, 2.0f);
        this.j = q.a(context, 30.0f);
        this.a = (WaveAnimImageView) findViewById(q.a(context, "myoffer_wave_anim_image", "id"));
        this.b = (WaveAnimImageView) findViewById(q.a(context, "myoffer_wave_anim_image2", "id"));
        this.n = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.o = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.c = (ImageView) findViewById(q.a(context, "myoffer_guide_to_click_finger", "id"));
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.1f, 1.0f, 1.1f);
        this.p = scaleAnimation;
        scaleAnimation.setRepeatMode(2);
        this.p.setRepeatCount(-1);
        this.p.setDuration(333L);
        this.d = (TextView) findViewById(q.a(context, "myoffer_guide_to_click_hint", "id"));
    }

    public void setFingerImageResource(Bitmap bitmap) {
        ImageView imageView = this.c;
        if (imageView == null || bitmap == null) {
            return;
        }
        imageView.setImageBitmap(bitmap);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        startAnim(this.n, this.a, 0L);
        startAnim(this.o, this.b, 800L);
        this.c.startAnimation(this.p);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.n;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.n.removeAllUpdateListeners();
            this.n.cancel();
        }
        ValueAnimator valueAnimator2 = this.o;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllListeners();
            this.o.removeAllUpdateListeners();
            this.o.cancel();
        }
        ScaleAnimation scaleAnimation = this.p;
        if (scaleAnimation != null) {
            scaleAnimation.cancel();
        }
    }

    private void a() {
        startAnim(this.n, this.a, 0L);
        startAnim(this.o, this.b, 800L);
        this.c.startAnimation(this.p);
    }

    private void b() {
        ValueAnimator valueAnimator = this.n;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.n.removeAllUpdateListeners();
            this.n.cancel();
        }
        ValueAnimator valueAnimator2 = this.o;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllListeners();
            this.o.removeAllUpdateListeners();
            this.o.cancel();
        }
        ScaleAnimation scaleAnimation = this.p;
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
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.anythink.basead.ui.GuideToClickV2View.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    float f;
                    float fFloatValue = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                    if (fFloatValue > 0.71428573f) {
                        waveAnimImageView.setVisibility(4);
                        return;
                    }
                    float f2 = fFloatValue / 0.71428573f;
                    float f3 = GuideToClickV2View.this.i + ((GuideToClickV2View.this.j - GuideToClickV2View.this.i) * f2);
                    float f4 = GuideToClickV2View.this.g + ((GuideToClickV2View.this.h - GuideToClickV2View.this.i) * f2);
                    double d = f2;
                    if (d < 0.2d) {
                        f = (float) (((double) GuideToClickV2View.this.e) + ((1.0d - (((double) (f2 * 1.0f)) / 0.2d)) * ((double) (GuideToClickV2View.this.f - GuideToClickV2View.this.e))));
                    } else {
                        f = (float) (((double) GuideToClickV2View.this.e) + ((((d - 0.2d) * 1.0d) / 0.8d) * ((double) (GuideToClickV2View.this.f - GuideToClickV2View.this.e))));
                    }
                    try {
                        if (GuideToClickV2View.this.getVisibility() == 0) {
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

    public void setFingerViewType(int i) {
        int iA = q.a(getContext(), 84.0f);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.a.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.b.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.c.getLayoutParams();
        this.d.getLayoutParams();
        if (i != 2) {
            if (i == 4 || i == 5 || i == 6) {
                int i2 = (int) (((double) iA) * 0.5d);
                this.g = q.a(getContext(), 2.0f);
                this.h = q.a(getContext(), 4.0f);
                this.j = q.a(getContext(), 8.0f);
                layoutParams.width = i2;
                layoutParams.height = i2;
                this.a.setLayoutParams(layoutParams);
                layoutParams2.width = i2;
                layoutParams2.height = i2;
                this.b.setLayoutParams(layoutParams2);
                layoutParams3.width = i2 / 3;
                layoutParams3.height = (int) ((((double) i2) / 3.0d) * 1.1d);
                int i3 = i2 / 2;
                layoutParams3.setMargins(i3, i3, 0, 0);
                this.c.setLayoutParams(layoutParams3);
                this.d.setVisibility(8);
                return;
            }
            return;
        }
        int i4 = (int) (((double) iA) * 0.7d);
        this.g = q.a(getContext(), 4.0f);
        this.h = q.a(getContext(), 4.0f);
        this.j = q.a(getContext(), 14.0f);
        layoutParams.width = i4;
        layoutParams.height = i4;
        this.a.setLayoutParams(layoutParams);
        layoutParams2.width = i4;
        layoutParams2.height = i4;
        this.b.setLayoutParams(layoutParams2);
        int i5 = i4 / 2;
        layoutParams3.width = i5;
        layoutParams3.height = (int) ((((double) i4) / 2.0d) * 1.1d);
        layoutParams3.setMargins((int) (((double) i5) * 0.9d), i5, 0, 0);
        this.c.setLayoutParams(layoutParams3);
        this.d.setVisibility(0);
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.d.getLayoutParams();
        layoutParams4.topMargin = q.a(getContext(), 6.0f);
        this.d.setLayoutParams(layoutParams4);
        this.d.setTextSize(1, 14.0f);
    }

    public void hideBackground() {
        setBackgroundColor(0);
    }
}
