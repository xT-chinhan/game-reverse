package com.smartdigimkt.c2;

import android.animation.Animator;
import com.smartdigimkt.sdk.basead.ui.improveclick.ambience.BubbleDropAnimView;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements Animator.AnimatorListener {
    public final /* synthetic */ BubbleDropAnimView a;

    public f(BubbleDropAnimView bubbleDropAnimView) {
        this.a = bubbleDropAnimView;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        this.a.f = true;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
    }
}
