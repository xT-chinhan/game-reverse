package com.anythink.basead.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.anythink.core.common.d.t;
import com.anythink.core.common.res.e;
import com.anythink.core.common.v.g;
import com.anythink.core.common.v.q;

/* JADX INFO: loaded from: classes.dex */
public class GuideToClickView extends RelativeLayout {
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

    public static class a {
        public static final int a = 501;
        public static final int b = 502;
        public static final int c = 503;
        public static final int d = 504;
        public static final int e = 505;
        public static final int f = 506;
        public static final int g = 507;
    }

    public GuideToClickView(Context context) {
        super(context);
        this.k = 1000;
        this.l = 200;
        this.m = 0.71428573f;
        a(context);
    }

    public GuideToClickView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.k = 1000;
        this.l = 200;
        this.m = 0.71428573f;
        a(context);
    }

    public GuideToClickView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.k = 1000;
        this.l = 200;
        this.m = 0.71428573f;
        a(context);
    }

    private void a(Context context) {
        LayoutInflater.from(context).inflate(q.a(context, "myoffer_guide_to_click", "layout"), this);
        setBackgroundColor(Color.parseColor("#66000000"));
        this.e = 0.8f;
        this.f = 0.05f;
        this.g = q.a(context, 4.0f);
        this.h = q.a(context, 18.0f);
        this.i = q.a(context, 2.0f);
        this.j = q.a(context, 40.0f);
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
        String strA = g.a().a(com.anythink.core.common.a.b.d.i);
        if (TextUtils.isEmpty(strA)) {
            return;
        }
        com.anythink.core.common.res.b.a(t.b().g()).a(new e(3, strA), new com.anythink.core.common.res.b.a() { // from class: com.anythink.basead.ui.GuideToClickView.1
            @Override // com.anythink.core.common.res.b.a
            public final void onFail(String str, String str2) {
            }

            @Override // com.anythink.core.common.res.b.a
            public final void onSuccess(String str, Bitmap bitmap) {
                if (GuideToClickView.this.c != null) {
                    GuideToClickView.this.c.setImageBitmap(bitmap);
                }
            }
        });
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
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.o;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
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
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.o;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
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
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.anythink.basead.ui.GuideToClickView.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    float f;
                    float fFloatValue = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                    if (fFloatValue > 0.71428573f) {
                        waveAnimImageView.setVisibility(4);
                        return;
                    }
                    float f2 = fFloatValue / 0.71428573f;
                    float f3 = GuideToClickView.this.i + ((GuideToClickView.this.j - GuideToClickView.this.i) * f2);
                    float f4 = GuideToClickView.this.g + ((GuideToClickView.this.h - GuideToClickView.this.i) * f2);
                    double d = f2;
                    if (d < 0.2d) {
                        f = (float) (((double) GuideToClickView.this.e) + ((1.0d - (((double) (f2 * 1.0f)) / 0.2d)) * ((double) (GuideToClickView.this.f - GuideToClickView.this.e))));
                    } else {
                        f = (float) (((double) GuideToClickView.this.e) + ((((d - 0.2d) * 1.0d) / 0.8d) * ((double) (GuideToClickView.this.f - GuideToClickView.this.e))));
                    }
                    try {
                        if (GuideToClickView.this.getVisibility() == 0) {
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

    public void setFingerViewMode(int i) {
        int iA;
        int iA2;
        hideBackground();
        q.a(getContext(), 200.0f);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.a.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.b.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.c.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.d.getLayoutParams();
        switch (i) {
            case 501:
            case 507:
                layoutParams.addRule(14);
                layoutParams.addRule(13, 0);
                this.a.setLayoutParams(layoutParams);
                layoutParams2.addRule(14);
                layoutParams2.addRule(13, 0);
                this.b.setLayoutParams(layoutParams2);
                break;
            case 502:
            case a.c /* 503 */:
                if (i == 502) {
                    iA = q.a(getContext(), 100.0f);
                    this.d.setTextSize(1, 14.0f);
                    this.h = q.a(getContext(), 12.0f);
                    this.j = q.a(getContext(), 30.0f);
                } else {
                    iA = q.a(getContext(), 160.0f);
                    this.d.setTextSize(1, 16.0f);
                }
                layoutParams.width = iA;
                layoutParams.height = iA;
                layoutParams.addRule(14);
                layoutParams.addRule(13, 0);
                layoutParams2.width = iA;
                layoutParams2.height = iA;
                layoutParams2.addRule(14);
                layoutParams2.addRule(13, 0);
                int i2 = iA / 2;
                layoutParams3.width = i2;
                layoutParams3.height = (int) ((((double) iA) / 2.0d) * 1.1d);
                layoutParams3.setMargins(i2, i2, 0, 0);
                break;
            case 504:
            case 505:
            case a.f /* 506 */:
                if (i == 505 || i == 504) {
                    iA2 = q.a(getContext(), 50.0f);
                    this.h = q.a(getContext(), 6.0f);
                    this.j = q.a(getContext(), 18.0f);
                } else {
                    iA2 = q.a(getContext(), 120.0f);
                    this.h = q.a(getContext(), 8.0f);
                    this.j = q.a(getContext(), 24.0f);
                }
                layoutParams.width = iA2;
                layoutParams.height = iA2;
                layoutParams.addRule(15);
                layoutParams.addRule(13, 0);
                this.a.setLayoutParams(layoutParams);
                layoutParams2.width = iA2;
                layoutParams2.height = iA2;
                layoutParams2.addRule(15);
                layoutParams2.addRule(13, 0);
                this.b.setLayoutParams(layoutParams2);
                int i3 = iA2 / 2;
                layoutParams3.width = i3;
                layoutParams3.height = (int) ((((double) iA2) / 2.0d) * 1.1d);
                layoutParams3.setMargins(i3, i3, 0, 0);
                this.c.setLayoutParams(layoutParams3);
                layoutParams4.addRule(14, 0);
                layoutParams4.addRule(3, 0);
                layoutParams4.addRule(15);
                layoutParams4.addRule(1, this.a.getId());
                layoutParams4.setMargins(q.a(getContext(), 6.0f), 0, q.a(getContext(), 10.0f), 0);
                this.d.setLayoutParams(layoutParams4);
                this.d.setTextSize(1, 12.0f);
                break;
        }
    }

    public void hideBackground() {
        setBackgroundColor(0);
    }
}
