package com.smartdigimkt.n1;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.smartdigimkt.sdk.basead.ui.BaseShakeView;

/* JADX INFO: loaded from: classes3.dex */
public final class s1 extends AnimatorListenerAdapter {
    public final /* synthetic */ BaseShakeView a;

    public s1(BaseShakeView baseShakeView) {
        this.a = baseShakeView;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator animator) {
        super.onAnimationRepeat(animator);
        this.a.c++;
    }
}
