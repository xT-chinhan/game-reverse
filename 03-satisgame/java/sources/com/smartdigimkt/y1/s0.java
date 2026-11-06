package com.smartdigimkt.y1;

import android.animation.ValueAnimator;
import com.smartdigimkt.sdk.basead.ui.guidetoclickv2.PicVerifyG2CV2View;

/* JADX INFO: loaded from: classes3.dex */
public final class s0 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ PicVerifyG2CV2View a;

    public s0(PicVerifyG2CV2View picVerifyG2CV2View) {
        this.a = picVerifyG2CV2View;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.i.setProgress(((Integer) valueAnimator.getAnimatedValue()).intValue());
    }
}
