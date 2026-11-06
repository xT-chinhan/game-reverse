package com.smartdigimkt.y1;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.smartdigimkt.sdk.basead.ui.guidetoclickv2.FullOrientationG2CV2View;

/* JADX INFO: loaded from: classes3.dex */
public final class l extends AnimatorListenerAdapter {
    public final /* synthetic */ FullOrientationG2CV2View a;

    public l(FullOrientationG2CV2View fullOrientationG2CV2View) {
        this.a = fullOrientationG2CV2View;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator animator) {
        super.onAnimationRepeat(animator);
        this.a.i++;
    }
}
