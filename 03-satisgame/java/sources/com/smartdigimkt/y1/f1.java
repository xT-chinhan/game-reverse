package com.smartdigimkt.y1;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.smartdigimkt.sdk.basead.ui.guidetoclickv2.SwipeG2CV2View;

/* JADX INFO: loaded from: classes3.dex */
public final class f1 extends AnimatorListenerAdapter {
    public final /* synthetic */ SwipeG2CV2View a;

    public f1(SwipeG2CV2View swipeG2CV2View) {
        this.a = swipeG2CV2View;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        SwipeG2CV2View.a(this.a);
    }
}
