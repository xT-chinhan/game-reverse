package com.smartdigimkt.sdk.basead.ui;

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
import com.smartdigimkt.n1.e3;
import com.smartdigimkt.r4.k;

/* JADX INFO: loaded from: classes3.dex */
public class GuideToClickV2View extends RelativeLayout {
    public WaveAnimImageView a;
    public WaveAnimImageView b;
    public ImageView c;
    public TextView d;
    public float e;
    public float f;
    public float g;
    public float h;
    public float i;
    public float j;
    public ValueAnimator k;
    public ValueAnimator l;
    public ScaleAnimation m;

    public GuideToClickV2View(Context context) {
        super(context);
        a(context);
    }

    public final void a(Context context) {
        LayoutInflater.from(context).inflate(k.a(context, "myoffer_guide_to_click_v2", "layout"), this);
        setBackgroundColor(Color.parseColor("#66000000"));
        this.e = 0.8f;
        this.f = 0.05f;
        this.g = k.a(context, 4.0f);
        this.h = (int) ((context.getResources().getDisplayMetrics().density * 8.0f) + 0.5f);
        this.i = (int) ((context.getResources().getDisplayMetrics().density * 2.0f) + 0.5f);
        this.j = (int) ((context.getResources().getDisplayMetrics().density * 30.0f) + 0.5f);
        this.a = (WaveAnimImageView) findViewById(k.a(context, "myoffer_wave_anim_image", "id"));
        this.b = (WaveAnimImageView) findViewById(k.a(context, "myoffer_wave_anim_image2", "id"));
        this.k = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.l = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.c = (ImageView) findViewById(k.a(context, "myoffer_guide_to_click_finger", "id"));
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.1f, 1.0f, 1.1f);
        this.m = scaleAnimation;
        scaleAnimation.setRepeatMode(2);
        this.m.setRepeatCount(-1);
        this.m.setDuration(333L);
        this.d = (TextView) findViewById(k.a(context, "myoffer_guide_to_click_hint", "id"));
    }

    public void hideBackground() {
        setBackgroundColor(0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        startAnim(this.k, this.a, 0L);
        startAnim(this.l, this.b, 800L);
        this.c.startAnimation(this.m);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.k;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.k.removeAllUpdateListeners();
            this.k.cancel();
        }
        ValueAnimator valueAnimator2 = this.l;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllListeners();
            this.l.removeAllUpdateListeners();
            this.l.cancel();
        }
        ScaleAnimation scaleAnimation = this.m;
        if (scaleAnimation != null) {
            scaleAnimation.cancel();
        }
    }

    public void setFingerImageResource(Bitmap bitmap) {
        ImageView imageView = this.c;
        if (imageView == null || bitmap == null) {
            return;
        }
        imageView.setImageBitmap(bitmap);
    }

    public void setFingerViewType(int i) {
        int iA = k.a(getContext(), 84.0f);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.a.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.b.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.c.getLayoutParams();
        if (i != 2) {
            if (i == 4 || i == 5 || i == 6) {
                int i2 = (int) (((double) iA) * 0.5d);
                this.g = k.a(getContext(), 2.0f);
                this.h = k.a(getContext(), 4.0f);
                this.j = k.a(getContext(), 8.0f);
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
        this.g = k.a(getContext(), 4.0f);
        this.h = k.a(getContext(), 4.0f);
        this.j = k.a(getContext(), 14.0f);
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
        layoutParams4.topMargin = k.a(getContext(), 6.0f);
        this.d.setLayoutParams(layoutParams4);
        this.d.setTextSize(1, 14.0f);
    }

    public void startAnim(ValueAnimator valueAnimator, WaveAnimImageView waveAnimImageView, long j) {
        if (valueAnimator != null) {
            valueAnimator.setRepeatMode(1);
            valueAnimator.setRepeatCount(-1);
            valueAnimator.setDuration(1400L);
            valueAnimator.removeAllUpdateListeners();
            valueAnimator.removeAllListeners();
            valueAnimator.addUpdateListener(new e3(this, waveAnimImageView));
            valueAnimator.setStartDelay(j);
            valueAnimator.start();
        }
    }

    public GuideToClickV2View(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public GuideToClickV2View(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }
}
