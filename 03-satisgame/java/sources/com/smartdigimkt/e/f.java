package com.smartdigimkt.e;

import android.animation.Animator;
import android.os.Handler;
import com.smartdigimkt.china.formatbusiness.ui.BubbleVibrationFallLayer;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends com.smartdigimkt.q1.g {
    public final /* synthetic */ BubbleVibrationFallLayer a;

    public f(BubbleVibrationFallLayer bubbleVibrationFallLayer) {
        this.a = bubbleVibrationFallLayer;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        BubbleVibrationFallLayer bubbleVibrationFallLayer = this.a;
        Handler handler = bubbleVibrationFallLayer.c;
        if (handler == null || bubbleVibrationFallLayer.f) {
            return;
        }
        handler.removeMessages(101);
        this.a.c.sendEmptyMessageDelayed(101, 500L);
    }
}
