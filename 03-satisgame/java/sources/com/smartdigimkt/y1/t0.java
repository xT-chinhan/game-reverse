package com.smartdigimkt.y1;

import android.animation.ValueAnimator;
import com.smartdigimkt.sdk.basead.ui.guidetoclickv2.PicVerifyG2CV2View;

/* JADX INFO: loaded from: classes3.dex */
public final class t0 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ PicVerifyG2CV2View a;

    public t0(PicVerifyG2CV2View picVerifyG2CV2View) {
        this.a = picVerifyG2CV2View;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        PicVerifyG2CV2View picVerifyG2CV2View = this.a;
        if (picVerifyG2CV2View.o != iIntValue) {
            picVerifyG2CV2View.o = iIntValue;
            picVerifyG2CV2View.i.setProgress(iIntValue);
        }
    }
}
