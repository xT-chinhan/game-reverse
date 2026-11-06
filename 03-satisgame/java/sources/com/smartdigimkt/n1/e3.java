package com.smartdigimkt.n1;

import android.animation.ValueAnimator;
import com.smartdigimkt.sdk.basead.ui.GuideToClickV2View;
import com.smartdigimkt.sdk.basead.ui.WaveAnimImageView;

/* JADX INFO: loaded from: classes3.dex */
public final class e3 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ WaveAnimImageView a;
    public final /* synthetic */ GuideToClickV2View b;

    public e3(GuideToClickV2View guideToClickV2View, WaveAnimImageView waveAnimImageView) {
        this.b = guideToClickV2View;
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
        GuideToClickV2View guideToClickV2View = this.b;
        float f4 = guideToClickV2View.i;
        float f5 = ((guideToClickV2View.j - f4) * f3) + f4;
        float f6 = ((guideToClickV2View.h - f4) * f3) + guideToClickV2View.g;
        double d3 = f3;
        if (d3 < 0.2d) {
            f = guideToClickV2View.e;
            d2 = f;
            d = 1.0d - (((double) (f3 * 1.0f)) / 0.2d);
            f2 = guideToClickV2View.f;
        } else {
            f = guideToClickV2View.e;
            d = ((d3 - 0.2d) * 1.0d) / 0.8d;
            f2 = guideToClickV2View.f;
            d2 = f;
        }
        float f7 = (float) ((d * ((double) (f2 - f))) + d2);
        try {
            if (guideToClickV2View.getVisibility() == 0) {
                this.a.setWaveAnimParams(new k6(f5, f6, f7));
                if (this.a.getVisibility() != 0) {
                    this.a.setVisibility(0);
                }
            }
        } catch (Throwable unused) {
        }
    }
}
