package com.smartdigimkt.w1;

import android.animation.ValueAnimator;
import com.smartdigimkt.sdk.basead.ui.component.emdcardimprove.RedPacketPage;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ i a;

    public e(i iVar) {
        this.a = iVar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        RedPacketPage redPacketPage = this.a.a;
        if (redPacketPage.m == null || iIntValue >= redPacketPage.r.size()) {
            return;
        }
        RedPacketPage redPacketPage2 = this.a.a;
        redPacketPage2.m.setImageResource(((Integer) redPacketPage2.r.get(iIntValue)).intValue());
    }
}
