package com.smartdigimkt.n1;

import android.animation.ValueAnimator;
import com.smartdigimkt.sdk.basead.ui.SimpleGuideToClickView;
import com.smartdigimkt.sdk.basead.ui.WaveAnimImageView;

/* JADX INFO: loaded from: classes3.dex */
public final class a5 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ WaveAnimImageView a;
    public final /* synthetic */ SimpleGuideToClickView b;

    public a5(SimpleGuideToClickView simpleGuideToClickView, WaveAnimImageView waveAnimImageView) {
        this.b = simpleGuideToClickView;
        this.a = waveAnimImageView;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float f;
        double d;
        float f2;
        double d2;
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        if (fFloatValue > 0.71428573f) {
            this.a.setVisibility(4);
            return;
        }
        float f3 = fFloatValue / 0.71428573f;
        SimpleGuideToClickView simpleGuideToClickView = this.b;
        float f4 = simpleGuideToClickView.h;
        float f5 = ((simpleGuideToClickView.i - f4) * f3) + f4;
        float f6 = ((simpleGuideToClickView.g - f4) * f3) + simpleGuideToClickView.f;
        double d3 = f3;
        if (d3 < 0.2d) {
            f = simpleGuideToClickView.d;
            d2 = f;
            d = 1.0d - (((double) (f3 * 1.0f)) / 0.2d);
            f2 = simpleGuideToClickView.e;
        } else {
            f = simpleGuideToClickView.d;
            d = ((d3 - 0.2d) * 1.0d) / 0.8d;
            f2 = simpleGuideToClickView.e;
            d2 = f;
        }
        float f7 = (float) ((d * ((double) (f2 - f))) + d2);
        try {
            if (simpleGuideToClickView.getVisibility() == 0) {
                this.a.setWaveAnimParams(new k6(f5, f6, f7));
                if (this.a.getVisibility() != 0) {
                    this.a.setVisibility(0);
                }
            }
        } catch (Throwable unused) {
        }
    }
}
