package com.smartdigimkt.n1;

import android.animation.ValueAnimator;
import com.smartdigimkt.sdk.basead.ui.GuideToClickView;
import com.smartdigimkt.sdk.basead.ui.WaveAnimImageView;

/* JADX INFO: loaded from: classes3.dex */
public final class g3 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ WaveAnimImageView a;
    public final /* synthetic */ GuideToClickView b;

    public g3(GuideToClickView guideToClickView, WaveAnimImageView waveAnimImageView) {
        this.b = guideToClickView;
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
        GuideToClickView guideToClickView = this.b;
        float f4 = guideToClickView.i;
        float f5 = ((guideToClickView.j - f4) * f3) + f4;
        float f6 = ((guideToClickView.h - f4) * f3) + guideToClickView.g;
        double d3 = f3;
        if (d3 < 0.2d) {
            f = guideToClickView.e;
            d2 = f;
            d = 1.0d - (((double) (f3 * 1.0f)) / 0.2d);
            f2 = guideToClickView.f;
        } else {
            f = guideToClickView.e;
            d = ((d3 - 0.2d) * 1.0d) / 0.8d;
            f2 = guideToClickView.f;
            d2 = f;
        }
        float f7 = (float) ((d * ((double) (f2 - f))) + d2);
        try {
            if (guideToClickView.getVisibility() == 0) {
                this.a.setWaveAnimParams(new k6(f5, f6, f7));
                if (this.a.getVisibility() != 0) {
                    this.a.setVisibility(0);
                }
            }
        } catch (Throwable unused) {
        }
    }
}
