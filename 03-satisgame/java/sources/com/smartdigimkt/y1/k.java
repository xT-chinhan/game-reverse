package com.smartdigimkt.y1;

import android.animation.ValueAnimator;
import com.smartdigimkt.sdk.basead.ui.guidetoclickv2.FullOrientationG2CV2View;

/* JADX INFO: loaded from: classes3.dex */
public final class k implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ FullOrientationG2CV2View a;

    public k(FullOrientationG2CV2View fullOrientationG2CV2View) {
        this.a = fullOrientationG2CV2View;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        if (this.a.k != null) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            FullOrientationG2CV2View fullOrientationG2CV2View = this.a;
            int i = fullOrientationG2CV2View.i % 4;
            if (i == 1) {
                fullOrientationG2CV2View.k.setTranslationY(fFloatValue);
                return;
            }
            if (i == 2) {
                fullOrientationG2CV2View.k.setTranslationX(-fFloatValue);
            } else if (i != 3) {
                fullOrientationG2CV2View.k.setTranslationY(-fFloatValue);
            } else {
                fullOrientationG2CV2View.k.setTranslationX(fFloatValue);
            }
        }
    }
}
